package com.example.selfproject.model;

public enum UserPermission {
    MODIFY("modify"),
    READ("read");

    private String permission;

    UserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
