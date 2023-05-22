package com.codegym.jwt_springboot_angular.security.jwt;

import com.codegym.jwt_springboot_angular.security.userPrincal.UserPrinciple;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class JwtTokenProvider {
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenProvider.class);
    private String jwtSecret = "namdn2312";
    private int jwtExpiration = 86400;

    //Build 1 chuỗi Token Login sẽ gọi hàm này
    public String createToken(Authentication authentication) {
        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
        return Jwts.builder()
                .setSubject(userPrinciple.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + (jwtExpiration*1000)))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    //Hàm CHECK Token này có tồn tại hay còn sống hay không
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        } catch (SignatureException e) {
            LOGGER.error("Invalid JWT signature: {}", e.getMessage()); // Token không hợp lệ
        } catch (MalformedJwtException e) {
            LOGGER.error("Invalid JWT format: {}", e.getMessage()); // Token không đúng định dạng
        } catch (ExpiredJwtException e) {
            LOGGER.error("JWT token is expired: {}", e.getMessage()); // Token hết hạn
        } catch (UnsupportedJwtException e) {
            LOGGER.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            LOGGER.error("JWT claims string is empty: {}", e.getMessage()); // Token không được có khoảng trắng
        }
        return false;
    }

    //Hàm tìm UserName trong token
    public String getUserNameFromToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }
}
