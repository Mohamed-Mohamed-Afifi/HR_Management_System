package com.afify.hr_system.model.appUser;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Role {

    ADMIN(Set.of(
        Permission.ADMIN_READ, 
        Permission.ADMIN_WRITE, 
        Permission.ADMIN_UPDATE, 
        Permission.ADMIN_DELETE,
        Permission.MANAGER_READ, 
        Permission.MANAGER_UPDATE, 
        Permission.MANAGER_DELETE, 
        Permission.MANAGER_WRITE
    )),
    USER(Collections.emptySet()),
    MANAGER(Set.of(
        Permission.MANAGER_READ, 
        Permission.MANAGER_UPDATE, 
        Permission.MANAGER_DELETE, 
        Permission.MANAGER_WRITE
    ));

//	this mean each field has set of permission
    @Getter
    private final Set<Permission> permissions;
// List of GrantedAuthorites with each Role
    public List<SimpleGrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = getPermissions()
            .stream()
            .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
            .collect(Collectors.toList());
//        Add role itself to autorites ["ROLE_ADMIN","admin:read","admin:write", ...]
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }
}
