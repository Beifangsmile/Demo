package com.u_u.core.security;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Component
public class OauthInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    // 所有请求都会转发，此方法是为了判定用户请求的url是否在权限表中，如果在权限表中，则返回给decide 方法，用来判断用户是否有此权限，如果不在权限表中则放行
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        final HttpServletRequest request = ((FilterInvocation)object).getRequest();
        Set<ConfigAttribute> allAttribute = new HashSet<>();
        ConfigAttribute configAttribute = new UrlConfigAttribute(request);
        allAttribute.add(configAttribute);
        return allAttribute;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }
}
