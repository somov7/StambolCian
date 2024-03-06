package ru.itmo.service;

import java.math.BigDecimal;
import java.util.List;

import ru.itmo.model.Address;
import ru.itmo.model.Announcemnt;
import ru.itmo.model.AnnouncemntStatus;
import ru.itmo.model.Owner;
import ru.itmo.model.Rentee;
import ru.itmo.model.User;
import ru.itmo.repository.AnnouncementRepository;
import ru.itmo.repository.UserRepository;

public class AnnouncemntServiceImpl implements AnnouncemntService {

    private final UserRepository userRepository;
    private final AnnouncementRepository announcementRepository;

    public AnnouncemntServiceImpl(UserRepository userRepository, AnnouncementRepository announcementRepository) {
        this.userRepository = userRepository;
        this.announcementRepository = announcementRepository;
    }

    @Override
    public Announcemnt publishAnnouncemnt(Owner owner, Address address, String name, String description,
                                          BigDecimal price) {
        Announcemnt announcemnt = new Announcemnt(owner, name, description, address, price);
        Announcemnt announcemntInMemory = announcementRepository.publishAnnouncement(announcemnt);
        userRepository.addAnnouncementToOwner(owner, announcemntInMemory);
        return announcemntInMemory;
    }

    @Override
    public Announcemnt updateStatus(Announcemnt announcemnt, AnnouncemntStatus status) {
        return announcementRepository.updateStatus(announcemnt, status);
    }

    @Override
    public Announcemnt updateNameAndDescription(Announcemnt announcemnt, String name, String description) {
        return announcementRepository.updateNameAndDescription(announcemnt, name, description);
    }

    @Override
    public Announcemnt updatePrice(Announcemnt announcemnt, BigDecimal price) {
        if (price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Flat rent cost cannot be negative");
        }
        return announcementRepository.updatePrice(announcemnt, price);
    }

    @Override
    public Announcemnt rentFlatToRentee(Announcemnt announcemnt, Rentee rentee) {
        Announcemnt announcemntInMemory = announcementRepository.updateStatus(announcemnt, AnnouncemntStatus.RENTED);
        userRepository.addAnnouncementToRentee(rentee, announcemntInMemory);
        return announcementRepository.updateRentee(announcemntInMemory, rentee);
    }

    @Override
    public Announcemnt closeAnnouncement(Announcemnt announcemnt) {
        return announcementRepository.updateStatus(announcemnt, AnnouncemntStatus.CLOSED);
    }

    @Override
    public List<Announcemnt> getAllOpenAnnouncments() {
        return announcementRepository.findAllByStatus(AnnouncemntStatus.OPEN);
    }
}
