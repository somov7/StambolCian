package ru.itmo.service;

import java.math.BigDecimal;
import java.util.List;

import ru.itmo.model.Address;
import ru.itmo.model.Announcemnt;
import ru.itmo.model.AnnouncemntStatus;
import ru.itmo.model.Owner;
import ru.itmo.model.Rentee;

public interface AnnouncemntService {

    Announcemnt publishAnnouncemnt(Owner owner, Address address, String name, String description, BigDecimal price);

    Announcemnt updateStatus(Announcemnt announcemnt, AnnouncemntStatus status);

    Announcemnt updateNameAndDescription(Announcemnt announcemnt, String name, String description);

    Announcemnt updatePrice(Announcemnt announcemnt, BigDecimal price);

    Announcemnt rentFlatToRentee(Announcemnt announcemnt, Rentee rentee);

    Announcemnt closeAnnouncement(Announcemnt announcemnt);

    List<Announcemnt> getAllOpenAnnouncments();

}
