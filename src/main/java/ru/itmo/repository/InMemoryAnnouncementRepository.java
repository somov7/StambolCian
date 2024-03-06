package ru.itmo.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import ru.itmo.model.Announcemnt;
import ru.itmo.model.AnnouncemntStatus;
import ru.itmo.model.Rentee;

public class InMemoryAnnouncementRepository implements AnnouncementRepository {

    private List<Announcemnt> announcemnts;

    public InMemoryAnnouncementRepository() {
        this.announcemnts = new ArrayList<>();
    }

    @Override
    public Announcemnt publishAnnouncement(Announcemnt announcemnt) {
        announcemnt.setId(UUID.randomUUID());
        announcemnts.add(announcemnt);
        return announcemnt;
    }

    @Override
    public Announcemnt updateStatus(Announcemnt announcemnt, AnnouncemntStatus status) {
        Announcemnt announcemntInMemory = announcemnts.stream()
                .filter(a -> a.getId().equals(announcemnt.getId()))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("No announcement with id = %s in memory".formatted()));

        announcemntInMemory.setStatus(status);
        return announcemntInMemory;
    }

    @Override
    public Announcemnt updateNameAndDescription(Announcemnt announcemnt, String name, String description) {
        Announcemnt announcemntInMemory = announcemnts.stream()
                .filter(a -> a.getId().equals(announcemnt.getId()))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("No announcement with id = %s in memory".formatted()));

        announcemntInMemory.setName(name);
        announcemntInMemory.setDescription(description);
        return announcemntInMemory;
    }

    @Override
    public Announcemnt updatePrice(Announcemnt announcemnt, BigDecimal price) {
        Announcemnt announcemntInMemory = announcemnts.stream()
                .filter(a -> a.getId().equals(announcemnt.getId()))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("No announcement with id = %s in memory".formatted()));

        announcemntInMemory.setPrice(price);
        return announcemntInMemory;
    }

    @Override
    public Announcemnt updateRentee(Announcemnt announcemnt, Rentee rentee) {
        Announcemnt announcemntInMemory = announcemnts.stream()
                .filter(a -> a.getId().equals(announcemnt.getId()))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("No announcement with id = %s in memory".formatted()));

        announcemntInMemory.setRentee(rentee);
        return announcemntInMemory;
    }

    @Override
    public List<Announcemnt> findAllByStatus(AnnouncemntStatus status) {
        return announcemnts.stream().filter(a -> a.getStatus().equals(status)).toList();
    }
}
