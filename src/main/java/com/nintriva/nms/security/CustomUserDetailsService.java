package com.nintriva.nms.security;


import com.nintriva.nms.entity.Role;
import com.nintriva.nms.entity.User;
import com.nintriva.nms.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private String authServerUrl = "http://localhost:9090";
    private String realm = "NMS-realm";
    private String clientId = "nintriva";
    private String role = "admin";
    //Get client secret from the Keycloak admin console (in the credential tab)
    private String clientSecret = "fEsv6SxscDLbN5JhYTRWKtg2hB7JryLD";
    private UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        User user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with username or email:" + usernameOrEmail));
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(),Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN")));
    }

    private Collection< ? extends GrantedAuthority> mapRolesToAuthorities(Set<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());
    }


}
