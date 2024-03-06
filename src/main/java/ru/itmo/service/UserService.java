package ru.itmo.service;

import ru.itmo.model.Owner;
import ru.itmo.model.Rentee;

public interface UserService {

    Owner registerOwner(String firstName, String lastName);

    Rentee registerRentee(String firstName, String lastName);

}
