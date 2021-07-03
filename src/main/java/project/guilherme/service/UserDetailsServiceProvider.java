package project.guilherme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import project.guilherme.model.UserModel;
import project.guilherme.repository.UserRepository;

public class UserDetailsServiceProvider implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + username));

        return  UserDetailsProvider.build(user);
    }
}
