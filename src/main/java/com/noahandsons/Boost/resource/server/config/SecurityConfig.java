package com.noahandsons.Boost.resource.server.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final CustomJwtAuthenticationTokenConverter authenticationTokenConverter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http.authorizeHttpRequests(authorize ->
                authorize.anyRequest().authenticated())
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(jwtConfigurer -> jwtConfigurer
                                .jwtAuthenticationConverter(authenticationTokenConverter)
                                .jwkSetUri("http://localhost:8080/oauth2/jwks")
                ));

//        http.authorizeHttpRequests(authorize ->
//                authorize.anyRequest().authenticated())
//                .oauth2ResourceServer(configurer -> configurer.opaqueToken(
//                        opaqueTokenConfigurer -> opaqueTokenConfigurer
//                                .introspectionUri("http://localhost:8080/oauth2/introspect")
//                                .introspectionClientCredentials("rs", "rs-secret")
//                ));

        return http.build();

    }
}
