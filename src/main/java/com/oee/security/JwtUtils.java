package com.oee.security;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.oee.serviceimpl.UserDetailsImpl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;



@Component
public class JwtUtils {

	 private String secretKey = null;
	
	private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

	public String generateJwtToken(Authentication authentication) {

		UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();

		return generateTokenFromUsername(userPrincipal.getUsername());

	}
	
	
	public String generateTokenFromUsername(String username) {
//	    return Jwts.builder().setSubject(username).setIssuedAt(new Date())
//	        .setExpiration(new Date((new Date()).getTime() + SecurityConstants.EXPIRATION_TIME)).signWith(SignatureAlgorithm.HS512, SecurityConstants.SECRET)
//	        .compact();
	    
	    Map<String, Object> claims  = new HashMap<>();
		return Jwts
		        .builder()
		        .claims()
		        .add(claims)
		        .subject(username)
		        .issuer("DCB")
		        .issuedAt(new Date(System.currentTimeMillis()))
//		        .expiration(new Date(System.currentTimeMillis()+ 60*10*1000))
		        .expiration(new Date(System.currentTimeMillis()+ 60*100*1000))
		        .and()
		        .signWith(generateKey())
		        .compact();
	}

	public String getUserNameFromJwtToken(String token) {
//		return Jwts.parser().setSigningKey(SecurityConstants.SECRET).parseClaimsJws(token).getBody().getSubject();
		 return validateJwtToken(token, Claims::getSubject);
	}
	
    private <T> T validateJwtToken(String token, Function<Claims,T> claimResolver) {
        Claims claims = validateJwtToken(token);
        return claimResolver.apply(claims);
    }

    
	public Claims validateJwtToken(String authToken){
	//		Jwts.parser().setSigningKey(SecurityConstants.SECRET).parseClaimsJws(authToken);
		        return Jwts
		                .parser()
		                .verifyWith(generateKey())
		                .build()
		                .parseSignedClaims(authToken)
		                .getPayload();
	}
	
    private SecretKey generateKey() {
        byte[] decode
                = Decoders.BASE64.decode(getSecretKey());

        return Keys.hmacShaKeyFor(decode);
    }
    
    public String getSecretKey() {
        return secretKey = SecurityConstants.SECRET;
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String userName = getUserNameFromJwtToken(token);
        return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
    
    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return validateJwtToken(token, Claims::getExpiration);
    }
}
