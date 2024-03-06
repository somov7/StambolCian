package ru.itmo.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import ru.itmo.model.Announcemnt;
import ru.itmo.model.Owner;
import ru.itmo.model.Rentee;
import ru.itmo.model.User;

public interface UserRepository {
    User registerUser(User user);

    Optional<User> findUserById(UUID id);

    List<User> getAllUsers();

    void addAnnouncementToOwner(Owner owner, Announcemnt announcemnt);

    void addAnnouncementToRentee(Rentee rentee, Announcemnt announcemnt);
}
