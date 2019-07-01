package com.bachue.snr.se.libraries.enums;

public enum RolesEnum {

	ADMIN("ADMIN", "/pages/index.xhtml"),
	USER("USER", "/pages/index.xhtml");
	
	private final String role;
	private final String index;
	
	private RolesEnum(final String role, String index) {
		this.role = role;
		this.index = index;
	}

	public String getRole() {
		return role;
	}

	public String getIndex() {
		return index;
	}	

	public static RolesEnum find(String role) {
		for (RolesEnum user : RolesEnum.values()) 
			if (user.role == role) return user;

		return null;
	}
}
