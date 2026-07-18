package com.example.ArpegioBackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@AllArgsConstructor
public enum Role {
    ADMIN(Set.of(PERMISSIONS.READ, PERMISSIONS.WRITE, PERMISSIONS.UPDATE)),
    USER(Set.of(PERMISSIONS.READ));

    private final Set<PERMISSIONS> permissions;

    public Set<PERMISSIONS> getPermissions() {
        return permissions;
    }

}
