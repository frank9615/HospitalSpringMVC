package com.example.hospital.config.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

public class SpringSecurityUserContext {
    SecurityContext securityContext = SecurityContextHolder.getContext();
    Authentication authentication = securityContext.getAuthentication();

    public String getCurrentUser(){
        String user = (authentication != null ) ? authentication.getName() : null;

        if(user != null && user.equals("anonymousUser")){
            user = null;
        }
        return user;
    }


}
