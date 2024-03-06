package ru.itmo.repository;

import java.math.BigDecimal;
import java.util.List;

import ru.itmo.model.Announcemnt;
import ru.itmo.model.AnnouncemntStatus;
import ru.itmo.model.Rentee;
import ru.itmo.service.AnnouncemntService;

public interface AnnouncementRepository {

    Announcemnt publishAnnouncement(Announcemnt announcemnt);

    Announcemnt updateStatus(Announcemnt announcemnt, AnnouncemntStatus status);

    Announcemnt updateNameAndDescription(Announcemnt announcemnt, String name, String description);

    Announcemnt updatePrice(Announcemnt announcemnt, BigDecimal price);

    Announcemnt updateRentee(Announcemnt announcemnt, Rentee rentee);

    List<Announcemnt> findAllByStatus(AnnouncemntStatus status);

}
