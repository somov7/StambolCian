package ru.itmo;

import java.math.BigDecimal;

import ru.itmo.model.Address;
import ru.itmo.model.Announcemnt;
import ru.itmo.model.Owner;
import ru.itmo.model.Rentee;
import ru.itmo.repository.AnnouncementRepository;
import ru.itmo.repository.InMemoryAnnouncementRepository;
import ru.itmo.repository.InMemoryUserRepository;
import ru.itmo.repository.UserRepository;
import ru.itmo.service.AnnouncemntService;
import ru.itmo.service.AnnouncemntServiceImpl;
import ru.itmo.service.UserService;
import ru.itmo.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserRepository userRepository = new InMemoryUserRepository();
        AnnouncementRepository announcementRepository = new InMemoryAnnouncementRepository();

        AnnouncemntService announcemntService = new AnnouncemntServiceImpl(userRepository, announcementRepository);
        UserService userService = new UserServiceImpl(userRepository);

        Owner sveta = userService.registerOwner("Sveta", "Keypop");
        Owner vanya = userService.registerOwner("Vanya", "Devyat");

        Announcemnt announcemnt1 = announcemntService.publishAnnouncemnt(
                sveta,
                new Address("Улица Пушкина, дом Колотушкина", 60.0, 30.0),
                "Классный домик",
                "Правда классный домик",
                new BigDecimal("40000.00")
        );
        Announcemnt announcemnt2 = announcemntService.publishAnnouncemnt(
                sveta,
                new Address("Коробка из-под холодильника", 60.0, 30.0),
                "Прохладный домик",
                "Купил холодильник, не знаю, что делать с коробкой",
                new BigDecimal("100.00")
        );
        Announcemnt announcemnt3 = announcemntService.publishAnnouncemnt(
                vanya,
                new Address("Улица Пушкина, дом Колотушкина", 60.0, 30.0),
                "Вагончик в Купчино",
                "Просто вагончик, синего цвета",
                new BigDecimal("1000.00")
        );

        System.out.println("Announcements: ");
        announcemntService.getAllOpenAnnouncments()
                .forEach(System.out::println);

        Rentee me = userService.registerRentee("Soma", "Tyomov");

        Announcemnt flat = announcemntService.getAllOpenAnnouncments()
                .stream()
                .filter(a -> a.getName().contains("Вагончик"))
                .findAny()
                .orElseThrow();

        announcemntService.rentFlatToRentee(flat, me);

        System.out.println("After I rented vagonchik: ");
        System.out.println("Announcements: ");
        announcemntService.getAllOpenAnnouncments()
                .forEach(System.out::println);

        System.out.println("My rented flats: ");
        me.getRentedFlats().forEach(System.out::println);
    }
}
