package ru.itmo.model;

import lombok.Data;

@Data
public class Address {
    private final String address;
    private final double longitude;
    private final double latitude;
}
