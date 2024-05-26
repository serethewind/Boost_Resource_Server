package com.noahandsons.Boost.resource.server.config;

//import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomJwtAuthenticationTokenConverter implements Converter<Jwt, JwtAuthenticationToken> {


    //the jwtAuthenticationToken actually means the authentication object

    @Override
    public JwtAuthenticationToken convert(Jwt source) {
      List<String> authorities = (List<String>) source.getClaims().get("authorities");
      JwtAuthenticationToken authenticationObject = new JwtAuthenticationToken(source, authorities.stream().map(SimpleGrantedAuthority::new).toList());
      return authenticationObject;
    }
}
