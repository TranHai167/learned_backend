package com.example.selfproject.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public enum UserRole {
    ADMIN(Set.of(UserPermission.MODIFY, UserPermission.READ)),
    CLIENT(Set.of(UserPermission.READ));

    private Set<UserPermission> permissions;
    UserRole(Set<UserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<UserPermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<UserPermission> permissions) {
        this.permissions = permissions;
    }

    public Collection<? extends GrantedAuthority> getSimpleAuthority() {
        Set<SimpleGrantedAuthority> setOfPermission = this.getPermissions().stream()
                .map(p -> new SimpleGrantedAuthority(p.getPermission()))
                .collect(Collectors.toSet());

        setOfPermission.add(new SimpleGrantedAuthority("ROLE_" + this));

        return setOfPermission;
    }
}
