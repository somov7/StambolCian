package ru.itmo.model;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.Data;

@Data
public class Announcemnt {
    private UUID id;
    private final Owner owner;
    private String name;
    private String description;
    private final Address address;
    private AnnouncemntStatus status;
    private BigDecimal price;
    private Rentee rentee;

    public Announcemnt(Owner owner, String name, String description, Address address, BigDecimal price) {
        this.id = null;
        this.owner = owner;
        this.name = name;
        this.description = description;
        this.address = address;
        this.status = AnnouncemntStatus.OPEN;
        this.price = price;
        this.rentee = null;
    }
}
