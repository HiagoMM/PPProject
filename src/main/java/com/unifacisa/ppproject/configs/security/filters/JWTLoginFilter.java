package com.unifacisa.ppproject.configs.security.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unifacisa.ppproject.configs.security.services.TokenService;
import com.unifacisa.ppproject.models.entities.Usuario;
import com.unifacisa.ppproject.services.UsuarioService;

public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {
	private UsuarioService service;
	
	public JWTLoginFilter(String url, AuthenticationManager authManager,UsuarioService service) {
		super(new AntPathRequestMatcher(url));
		setAuthenticationManager(authManager);
		this.service = service;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException {
		
		Usuario credentials = new ObjectMapper()
				.readValue(request.getInputStream(), Usuario.class);
		
		Usuario fullUser = service.getByEmail(credentials.getEmail());
		
		return getAuthenticationManager().authenticate(
				new UsernamePasswordAuthenticationToken(
						credentials.getEmail(), 
						credentials.getPassword(), 
						fullUser.getAuthorities()
						)
				);
	}
	
	@Override
	protected void successfulAuthentication(
			HttpServletRequest request, 
			HttpServletResponse response,
			FilterChain filterChain,
			Authentication auth) throws IOException, ServletException {
		
		TokenService.addAuthentication(response, auth.getName());
	}

}