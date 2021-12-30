package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Configuration
@Component
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
 private RedirectStrategy redirectStrategy=new DefaultRedirectStrategy();

    @Override
    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String targetUrl=determineTargetUrl(authentication);
        if(response.isCommitted()){
            System.out.println("can't redirect");
            return;
        }
        redirectStrategy.sendRedirect(request,response,targetUrl);
    }
//    Phương thức này trích xuất các vai trò của người dùng hiện đã đăng nhập và trả về
//    URL thích hợp theo vai trò
    protected String determineTargetUrl(Authentication authentication){
        String url="";
        Collection<?extends GrantedAuthority> authorities=authentication.getAuthorities();
        List<String> roles=new ArrayList<String>();
        for(GrantedAuthority a:authorities){
            roles.add(a.getAuthority());
        }
        if (isDba(roles)) {
            url = "/dba";
        } else if (isAdmin(roles)) {
            url = "/admin";
        } else if (isUser(roles)) {
            url = "/home";
        } else {
            url = "/accessDenied";
        }

        return url;
    }
    private boolean isUser(List<String> roles) {
        if (roles.contains("ROLE_USER")) {
            return true;
        }
        return false;
    }

    private boolean isAdmin(List<String> roles) {
        if (roles.contains("ROLE_ADMIN")) {
            return true;
        }
        return false;
    }

    private boolean isDba(List<String> roles) {
        if (roles.contains("ROLE_DBA")) {
            return true;
        }
        return false;
    }
    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }

    protected RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }
}
