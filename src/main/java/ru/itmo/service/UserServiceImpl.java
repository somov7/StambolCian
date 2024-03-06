package ru.itmo.service;

import ru.itmo.model.Owner;
import ru.itmo.model.Rentee;
import ru.itmo.repository.UserRepository;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Owner registerOwner(String firstName, String lastName) {
        Owner owner = new Owner(null, firstName, lastName);
        return (Owner) userRepository.registerUser(owner);
    }

    @Override
    public Rentee registerRentee(String firstName, String lastName) {
        Rentee rentee = new Rentee(firstName, lastName);
        return (Rentee) userRepository.registerUser(rentee);
    }
}
