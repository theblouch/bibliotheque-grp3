package fr.formation.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.formation.dao.IDAOUser;

@Service
public class JpaUserDetailsService implements UserDetailsService {
    @Autowired
    private IDAOUser dao;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
 

        return this.dao.findByUsername(username)
            .map(user -> User
                    .withUsername(username)
                    .password(user.getPassword())
                    .roles("USER")
                    .build()
            )
            .orElseThrow(() -> new UsernameNotFoundException("User not found"))
        ;
    }
}
