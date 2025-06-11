package com.itsupport.backend.service;

import com.itsupport.backend.model.User;
import com.itsupport.backend.model.UserPrincipal;
import com.itsupport.backend.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(
            final UserRepository userRepository
    ) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException
    {

        User user = userRepository.findUserByEmail(email);

//        System.out.println("*********************************************");
//        System.out.println(user.toString());
//        System.out.println("*********************************************");

        if ( user == null ) {
            System.out.println("user not found");
            throw new UsernameNotFoundException("this user is not found");
        }

        return new UserPrincipal(user);
    }
}
