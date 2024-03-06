package ru.itmo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Owner extends User {

    @ToString.Exclude
    private final List<Announcemnt> announcements;

    public Owner(UUID id, String firstName, String lastName) {
        super(id, firstName, lastName);
        this.announcements = new ArrayList<>();
    }
}
