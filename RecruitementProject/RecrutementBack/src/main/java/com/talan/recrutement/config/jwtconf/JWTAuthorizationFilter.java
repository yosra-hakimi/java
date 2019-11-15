package com.talan.recrutement.config.jwtconf;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.talan.recrutement.config.UserPrincipal;
import com.talan.recrutement.persistence.entity.UserEntity;
import com.talan.recrutement.persistence.repository.UserRepository;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

	private UserRepository userRepository;

	public JWTAuthorizationFilter(AuthenticationManager authManager, UserRepository userRepository) {
		super(authManager);
		this.userRepository = userRepository;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		String header = req.getHeader(JwtProperties.HEADER_STRING);
		

		if (header == null || !header.startsWith(JwtProperties.TOKEN_PREFIX)) {
			chain.doFilter(req, res);
			return;
		}

		UsernamePasswordAuthenticationToken authentication = getAuthentication(req);

		SecurityContextHolder.getContext().setAuthentication(authentication);
		chain.doFilter(req, res);
		res.addHeader("access-control-expose-headers", "Authorization");

	}

	private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
		String token = request.getHeader(JwtProperties.HEADER_STRING);
		if (token != null) {
			// parse the token.
			String username = JWT.require(Algorithm.HMAC512(JwtProperties.SECRET.getBytes())).build()
					.verify(token.replace(JwtProperties.TOKEN_PREFIX, "")).getSubject();

			if (username != null) {
				
				String email = username.split(" ")[2];
				UserEntity userEntity = userRepository.findById(email).get();

				UserPrincipal principal = new UserPrincipal(userEntity);
				
				return new UsernamePasswordAuthenticationToken(email, "", principal.getAuthorities());
			}
			return null;
		}
		return null;
	}

}
