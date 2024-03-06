package ru.itmo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import ru.itmo.model.Announcemnt;
import ru.itmo.model.Owner;
import ru.itmo.model.Rentee;
import ru.itmo.model.User;

public class InMemoryUserRepository implements UserRepository {

    private List<User> users;

    public InMemoryUserRepository() {
        this.users = new ArrayList<>();
    }

    @Override
    public User registerUser(User user) {
        user.setId(UUID.randomUUID());
        users.add(user);
        return user;
    }

    @Override
    public Optional<User> findUserById(UUID id) {
        return users.stream()
                .filter(u -> u.getId().equals(id))
                .findAny();
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public void addAnnouncementToOwner(Owner owner, Announcemnt announcemnt) {
        Owner ownerInMemory = users.stream()
                .filter(u -> u.getId().equals(owner.getId()))
                .map(Owner.class::cast)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Owner with id = %s not found".formatted(owner.getId())));

        ownerInMemory.getAnnouncements().add(announcemnt);
    }

    @Override
    public void addAnnouncementToRentee(Rentee rentee, Announcemnt announcemnt) {
        Rentee renteeInMemory = users.stream()
                .filter(u -> u.getId().equals(rentee.getId()))
                .map(Rentee.class::cast)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Rentee with id = %s not found".formatted(rentee.getId())));

        renteeInMemory.getRentedFlats().add(announcemnt);
    }
}
