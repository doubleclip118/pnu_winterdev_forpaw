package com.hong.ForPaw.core.security;

import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.hong.ForPaw.domain.User.User;
import org.springframework.stereotype.Component;

import java.util.Date;

import static org.springframework.security.config.Elements.JWT;

@Component
public class JWTProvider {

    public static final Long ACCESS_EXP = 1000L * 60 * 60 * 24; // 1시간
    public static final Long REFRESH_EXP = 1000L * 60 * 60 * 24 * 7; // 일주일

    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER = "Authorization";
    public static final String SECRET = "MySecretKey";

    // access token 생성
    public static String createAccessToken(User user) {
        String jwt = createToken(user, ACCESS_EXP);
        return jwt;
    }

    // refresh token 생성
    public static String createRefreshToken(User user) {
        String jwt = createToken(user, REFRESH_EXP);
        return jwt;
    }

    public static String createToken(User user, Long exp) {
        return JWT.create()
                .withSubject(user.getEmail())
                .withExpiresAt(new Date(System.currentTimeMillis() + exp))
                .withClaim("id", user.getId())
                .withClaim("role", user.getRole().ordinal())
                .sign(Algorithm.HMAC512(SECRET));
    }

    public static DecodedJWT verify(String jwt) throws SignatureVerificationException, TokenExpiredException {
        jwt = jwt.replace(JWTProvider.TOKEN_PREFIX, "");
        return JWT.require(Algorithm.HMAC512(SECRET)).build().verify(jwt);
    }
}