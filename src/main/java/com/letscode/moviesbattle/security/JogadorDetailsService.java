package com.letscode.moviesbattle.security;

import com.letscode.moviesbattle.domain.Jogador;
import com.letscode.moviesbattle.service.JogadorService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JogadorDetailsService implements UserDetailsService {

    private final JogadorService jogadorService;

    public JogadorDetailsService(JogadorService jogadorService) {
            this.jogadorService = jogadorService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username != null) {
            Jogador jogador = jogadorService.searchByEmail(username);
            if (jogador != null) {
                return new JogadorPrincipal(jogador);
            }
        }
        throw new UsernameNotFoundException(username);
    }
}
