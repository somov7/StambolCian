package ru.itmo.model;

import java.util.ArrayList;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Rentee extends User {

    @ToString.Exclude
    private final List<Announcemnt> rentedFlats;

    public Rentee(String firstName, String lastName) {
        super(null, firstName, lastName);
        this.rentedFlats = new ArrayList<>();
    }
}
