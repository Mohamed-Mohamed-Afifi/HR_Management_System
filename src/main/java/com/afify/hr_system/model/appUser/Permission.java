package com.afify.hr_system.model.appUser;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
public enum Permission {
	ADMIN_READ("admin:read"),
	ADMIN_UPDATE("admin:update"),
	ADMIN_DELETE("admin:delete"),
	ADMIN_WRITE("admin:write"),
	
	MANAGER_READ("manager:read"),
	MANAGER_UPDATE("manager:update"),
	MANAGER_DELETE("manager:delete"),
	MANAGER_WRITE("manager:write"),
	
	USER_READ("user:read"),
	USER_WRITE("user:write"),
	USER_UPDATE("user:update"),
	USER_DELETE("user:delete")
	;
@Getter
private final String permission;
}
