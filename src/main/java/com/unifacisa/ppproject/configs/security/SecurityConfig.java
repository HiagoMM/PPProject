package com.unifacisa.ppproject.configs.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.unifacisa.ppproject.configs.security.filters.JWTAuthenticationFilter;
import com.unifacisa.ppproject.configs.security.filters.JWTLoginFilter;
import com.unifacisa.ppproject.models.enums.RoleEnum;
import com.unifacisa.ppproject.services.UsuarioService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UsuarioService usuarioService;
	

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable()
			.authorizeRequests()
			.antMatchers(SecurityConstants.SWAGGER).permitAll()
			.antMatchers("/usuarios").permitAll()
			.antMatchers("/pedidos/**").hasAuthority(RoleEnum.CLIENTE.getAuthority())
			.antMatchers("/bebidas/**").hasAuthority(RoleEnum.ADMIN.getAuthority())
			.antMatchers("/pratos/**").hasAuthority(RoleEnum.ADMIN.getAuthority())
			.antMatchers("/ingredientes/**").hasAuthority(RoleEnum.ADMIN.getAuthority())
			.antMatchers(HttpMethod.POST, "/login").permitAll()
			.antMatchers(HttpMethod.GET, "/pratos/**").hasAnyAuthority(RoleEnum.CLIENTE.getAuthority())
			.antMatchers(HttpMethod.GET, "/bebidas/**").hasAnyAuthority(RoleEnum.CLIENTE.getAuthority())
			.anyRequest().authenticated().and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
			.addFilterBefore(new JWTLoginFilter("/login", authenticationManager(),usuarioService),
	                UsernamePasswordAuthenticationFilter.class)
			.addFilterBefore(new JWTAuthenticationFilter(usuarioService),
	                UsernamePasswordAuthenticationFilter.class);
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(usuarioService).passwordEncoder(encoder());
	}
	
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
}