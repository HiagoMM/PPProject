package com.unifacisa.ppproject.models.enums;

import org.springframework.security.core.GrantedAuthority;

public enum RoleEnum implements GrantedAuthority{
	CLIENTE,ADMIN;

	@Override
	public String getAuthority() {
		return this.name();
	}
}
