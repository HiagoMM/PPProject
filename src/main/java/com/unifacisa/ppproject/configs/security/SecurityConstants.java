package com.unifacisa.ppproject.configs.security;

public class SecurityConstants {
	public static final String SECRET = "iuegahjoskdhlugchjkl";
    public static final long EXPIRATION_TIME = 844_444_000;
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String [] SWAGGER= {"/", "/v2/api-docs", "/configuration/ui", "/swagger-resources", "/swagger-resources/**",
			"/configuration/security", "/swagger-ui.html", "/webjars/**"};

}
