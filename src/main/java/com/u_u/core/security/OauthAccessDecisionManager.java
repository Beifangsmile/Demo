package com.u_u.core.security;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class OauthAccessDecisionManager implements AccessDecisionManager {

    /**
     *  重写接口方法
     *     decide  方法判断是否拥有权限的 决策方法
     * @param authentication
     * @param object
     * @param configAttributes
     * @throws AccessDeniedException
     * @throws InsufficientAuthenticationException
     */
    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        if(null == configAttributes || configAttributes.size() <= 0){
            return ;
        }
        for(ConfigAttribute attribute : configAttributes){
            if(!(attribute instanceof UrlConfigAttribute))
                continue;
            UrlConfigAttribute urlConfigAttribute = (UrlConfigAttribute) attribute;
            for(GrantedAuthority authority : authentication.getAuthorities()){
                if( !(authority instanceof UrlGrantedAuthority))
                    continue;
                UrlGrantedAuthority urlGrantedAuthority = (UrlGrantedAuthority) authority;
                if(StringUtils.isBlank(urlGrantedAuthority.getAuthority()))
                    continue;
                String httpMethod = StringUtils.isNotBlank(urlGrantedAuthority.getHttpMethod()) ?
                        urlGrantedAuthority.getHttpMethod() : urlConfigAttribute.getHttpServletRequest().getMethod();
                AntPathRequestMatcher antPathRequestMatcher = new AntPathRequestMatcher(urlGrantedAuthority.getAuthority(),httpMethod.toUpperCase());
                if(antPathRequestMatcher.matches(urlConfigAttribute.getHttpServletRequest()))
                    return;
            }
        }
        throw new AccessDeniedException("no right to access");

    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return false;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }
}
