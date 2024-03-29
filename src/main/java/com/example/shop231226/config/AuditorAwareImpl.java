package com.example.shop231226.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.naming.AuthenticationException;
import javax.swing.text.html.Option;
import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String userId = "";

        if(authentication != null) {
            userId = authentication.getName();
        }
        return Optional.of(userId);
    }

}
