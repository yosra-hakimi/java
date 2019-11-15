package com.talan.recrutement.config.jwtconf;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.talan.recrutement.config.CredintielInput;
import com.talan.recrutement.config.UserPrincipal;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private AuthenticationManager authenticationManager;

	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
			throws AuthenticationException {
		try {
			CredintielInput creds = new ObjectMapper().readValue(getBody(req), CredintielInput.class);

			res.addHeader("access-control-expose-headers", "Authorization");

			return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(creds.getUsername(),
					creds.getPassword(), new ArrayList<>()));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain,
			Authentication auth) throws IOException, ServletException {

		UserPrincipal user = (UserPrincipal) auth.getPrincipal();

		String token = JWT.create()
				.withSubject(user.getUserFirstName() + " " + user.getUserLastName() + " " + user.getUsername() + " "
						+ user.getUserProfile())
				.withExpiresAt(new Date(System.currentTimeMillis() + JwtProperties.EXPIRATION_TIME))
				.sign(HMAC512(JwtProperties.SECRET.getBytes()));
		res.addHeader(JwtProperties.HEADER_STRING, JwtProperties.TOKEN_PREFIX + token);
		res.addHeader("access-control-expose-headers", "Authorization");
	}

	private String getBody(HttpServletRequest req) {
		String body = "";
		if (req.getMethod().equals("POST")) {
			StringBuilder sb = new StringBuilder();
			BufferedReader bufferedReader = null;

			try {
				bufferedReader = req.getReader();
				char[] charBuffer = new char[128];
				int bytesRead;
				while ((bytesRead = bufferedReader.read(charBuffer)) != -1) {
					sb.append(charBuffer, 0, bytesRead);
				}
			} catch (IOException ex) {
				// swallow silently -- can't get body, won't
			} finally {
				if (bufferedReader != null) {
					try {
						bufferedReader.close();
					} catch (IOException ex) {
						// swallow silently -- can't get body, won't
					}
				}
			}
			body = sb.toString();
		}
		return body;
	}

}
