package project.guilherme.service;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import project.guilherme.payload.request.LoginRequest;
import project.guilherme.payload.response.JwtResponse;
import project.guilherme.security.JwtUtils;

import java.util.List;
import java.util.stream.Collectors;

public class AuthService {

    public static ResponseEntity<JwtResponse> signin(AuthenticationManager authenticationManager, LoginRequest loginRequest, JwtUtils jwtUtils) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsProvider userDetailsProvider = (UserDetailsProvider) authentication.getPrincipal();
        List<String> roles = userDetailsProvider.getAuthorities().stream()
                .map(role -> role.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetailsProvider.getId(),
                userDetailsProvider.getUsername(),
                userDetailsProvider.getEmail(),
                roles));
    }

}
