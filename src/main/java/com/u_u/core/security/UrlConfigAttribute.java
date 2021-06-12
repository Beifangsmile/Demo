package com.u_u.core.security;

import org.springframework.security.access.ConfigAttribute;

import javax.servlet.http.HttpServletRequest;

public class UrlConfigAttribute implements ConfigAttribute {
    private final HttpServletRequest request;

    public UrlConfigAttribute(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public String getAttribute() {
        return null;
    }

    public HttpServletRequest getHttpServletRequest(){
        return request;
    }
}
