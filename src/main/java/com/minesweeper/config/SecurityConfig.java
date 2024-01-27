package com.minesweeper.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final RsaKeyProperties rsaKeys;

    public SecurityConfig(RsaKeyProperties rsaKeys) {
        this.rsaKeys = rsaKeys;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                // disable csrf
                .csrf(csrf -> csrf.disable())
                // authorize all requests
                .authorizeHttpRequests( auth -> auth
                        .anyRequest().authenticated()
                )
                // jwt resource server
                .oauth2ResourceServer(oAuth2ResourceServerConfigurer -> oAuth2ResourceServerConfigurer
                        .jwt(Customizer.withDefaults())
                )
                // stateless session management
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                // not entirely sure what this is
                .httpBasic(Customizer.withDefaults())
                .build();
    }

    @Bean
    public InMemoryUserDetailsManager user() {
        return new InMemoryUserDetailsManager(
                User.withUsername("user")
                        .password("{noop}password")
                        .authorities("read")
                        .build()
        );
    }

    @Bean
    JwtDecoder jwtDecoder() {
        return NimbusJwtDecoder.withPublicKey(rsaKeys.publicKey()).build();
    }


//    @Bean
//    public UserDetailsService userDetailsService(DataSource dataSource) {
//        return new JdbcUserDetailsManager(dataSource);
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests(configurer ->
//                        configurer
//                                .requestMatchers(HttpMethod.GET, "/**").permitAll()
//                                .requestMatchers(HttpMethod.POST, "/**").permitAll()
//                                .requestMatchers(HttpMethod.PUT, "/**").permitAll()
//                                .requestMatchers(HttpMethod.DELETE, "/**").permitAll()
//                )
//                .formLogin(Customizer.withDefaults())  // Enable form-based login
//                .csrf().disable()
//                .logout()
//                .deleteCookies("JSESSIONID")  // Delete the session cookie on logout
//                .invalidateHttpSession(true)
//                .clearAuthentication(true);
//
//        return http.build();
//    }
}
