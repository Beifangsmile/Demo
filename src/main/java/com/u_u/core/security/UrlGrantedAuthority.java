package com.u_u.core.security;

import org.springframework.security.core.GrantedAuthority;

import java.util.Objects;

public class UrlGrantedAuthority implements GrantedAuthority {
    private final String httpMethod;
    private final String url;

    public UrlGrantedAuthority(String httpMethod, String url) {
        this.httpMethod = httpMethod;
        this.url = url;
    }

    @Override
    public String getAuthority() {
        return url;
    }

    public String getHttpMethod(){
        return httpMethod;
    }

    public String getUrl(){
        return url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UrlGrantedAuthority that = (UrlGrantedAuthority) o;
        return Objects.equals(httpMethod, that.httpMethod) && Objects.equals(url, that.url);
    }

    @Override
    public int hashCode() {
        int result = httpMethod != null ? httpMethod.hashCode() : 0;
        result = 31 * result + (url != null?url.hashCode():0);
        return result;
    }
}
