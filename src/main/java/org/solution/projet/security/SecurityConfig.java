package org.solution.projet.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration //pour analyser l'ensemble des methodes
public class SecurityConfig {
    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder(){  //algorithme de cryptage
        return new BCryptPasswordEncoder();
    }




    //pour que la methode soit connu dans la classe
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults())
                .authorizeHttpRequests(authCustomizer -> authCustomizer
                        .requestMatchers("/editClient", "deleleClient", "createClient", "clientsList", "saveClient", "updateClient").hasRole("ADMIN")
                        .requestMatchers("/editAvocat", "deleleAvocat", "createAvocat", "saveAvocat", "updateAvocat").hasRole("ADMIN")
                        .requestMatchers("/avocatsList").hasAnyRole("USER", "AVOCAT", "ADMIN") // Autoriser les utilisateurs avec les rôles USER et AVOCAT
                        .anyRequest().authenticated()
                )
                .exceptionHandling(e -> e.accessDeniedPage("/accessDenied"))
                .build();
    }


    //@Bean  //n'ai plus executable apres commenté annotation bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){  //permet de créer des utilisateur avec leurs roles
        return new InMemoryUserDetailsManager(
                User.withUsername("admin").password(bCryptPasswordEncoder().encode("123")).roles("ADMIN").build(),
                User.withUsername("avocat").password(bCryptPasswordEncoder().encode("123")).roles("AVOCAT","USER").build(),
                User.withUsername("client").password(bCryptPasswordEncoder().encode("123")).roles("USER").build()

        );
    }
}
