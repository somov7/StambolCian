package ru.itmo.model;

import java.util.UUID;

import lombok.Data;

@Data
public abstract class User {
    private UUID id;
    private final String firstName;
    private final String lastName;

    public User(UUID id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
