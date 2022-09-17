package com.login.loginUser.security;

import com.login.loginUser.domain.WebUser;
import com.login.loginUser.repositories.WebUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

/**
 * Created by IntelliJ IDEA.
 * User: Muhammad NUman
 * Date: 16/09/22
 * Time: 5:07 PM
 * To change this template use File | Settings | File Templates.
 */
@Transactional(readOnly = true)
public class UserAuthenticationService implements UserDetailsService {

    @Autowired
    private WebUserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmailIgnoreCaseAndStatus(username, WebUser.STATUS_ACTIVE)
                .map(webUser -> {
                    if (webUser.isActive()) {
                        return new AuthUserInfo(webUser, Collections.emptyList(), true);
                    } else {
                        throw new UsernameNotFoundException("User with username: " + username + " is inactive. Please contact administrator.");
                    }

                })
                .orElseThrow(() -> new UsernameNotFoundException("No user present with username: " + username));
    }
}
