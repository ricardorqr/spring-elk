package com.example.elk.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.elk.util.Util;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor
public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;
    private final String secretKeyWord;

    @SneakyThrows
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {
        String jsonString = Util.jsonToString(request);
        Map<String, String> jsonMap = Util.stringToMap(jsonString);
        String username = jsonMap.get("username");
        String password = jsonMap.get("password");
        log.info("Username: {} and password: {}", username, password);
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        return authenticationManager.authenticate(authenticationToken);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authentication) throws IOException {
        User user = (User) authentication.getPrincipal();
        Algorithm algorithm = Algorithm.HMAC256(secretKeyWord.getBytes());

        String accessToken = createToken(request, user, algorithm);
        log.info("Token: {}", accessToken);

        String refreshToken = createRefreshToken(request, user, algorithm);
        log.info("Refresh Token: {}", refreshToken);

        HashMap<String, String> tokens = new HashMap<>();
        tokens.put("access_token", accessToken);
        tokens.put("refresh_token", refreshToken);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        new ObjectMapper().writeValue(response.getOutputStream(), tokens);
    }

    private String createToken(HttpServletRequest request, User user, Algorithm algorithm) {
        return JWT.create()
                  .withSubject(user.getUsername())
                  .withExpiresAt(new Date(System.currentTimeMillis() + 15 * 60 * 1000)) // 15 min * 1 min * 1000 millisecond
                  .withIssuer(request.getRequestURL().toString())
                  .withClaim("roles", getRoles(user))
                  .sign(algorithm);
    }

    private String createRefreshToken(HttpServletRequest request, User user, Algorithm algorithm) {
        return JWT.create()
                  .withSubject(user.getUsername())
                  .withExpiresAt(new Date(System.currentTimeMillis() + 30 * 60 * 1000)) // 30 min * 1 min * 1000 millisecond
                  .withIssuer(request.getRequestURL().toString())
                  .withClaim("roles", getRoles(user))
                  .sign(algorithm);
    }

    private List<String> getRoles(User user) {
        return user.getAuthorities()
                   .stream()
                   .map(GrantedAuthority::getAuthority)
                   .collect(Collectors.toList());
    }

}
