package com.u_u.core.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

public class OAuth2ServerConfig {
    private static final String API_RESOURCE_ID = "api";
    private static String PASSWORD_CLIENT_ID = "client_2";
    private static String PASSWORD_CLIENT_SECRET = "123465";

    @Configuration
    @EnableResourceServer
    protected static class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
        @Autowired
        OauthInvocationSecurityMetadataSource oauthInvocationSecurityMetadataSource;

        @Autowired
        OauthAccessDecisionManager oauthAccessDecisionManager;
    }

}
