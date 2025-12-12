package ch.cleanit.backend.config;

import ch.cleanit.backend.model.*;
import ch.cleanit.backend.repository.OrderRepository;
import ch.cleanit.backend.repository.ShopRepository;
import ch.cleanit.backend.repository.UserRepository;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

import java.time.LocalDateTime;

@Component
public class DataInitializer {

    private final UserRepository userRepository;
    private final ShopRepository shopRepository;
    private final OrderRepository orderRepository;

    private User customer;
    private User employee;
    private User manager;
    private Shop shop2;

    public DataInitializer(UserRepository userRepository, ShopRepository shopRepository, OrderRepository orderRepository) {
        this.userRepository = userRepository;
        this.shopRepository = shopRepository;
        this.orderRepository = orderRepository;
    }

    @PostConstruct
    public void init() {
        addUsers();
        addShops();
        addOrders();

    }

    public void addUsers() {
        User customer1 = User.builder()
                .firstName("Lara")
                .lastName("Linda")
                .mail("laralinda@bluewin.ch")
                .build();
        customer1.getRoles().add(Role.CUSTOMER);

        User customer2 = User.builder()
                .firstName("Thomas")
                .lastName("Tur")
                .mail("turtho@gmail.com")
                .build();
        customer2.getRoles().add(Role.CUSTOMER);

        employee = User.builder()
                .firstName("Sebastian")
                .lastName("Sauber")
                .mail("sebasa@clean.ch")
                .build();
        employee.getRoles().add(Role.EMPLOYEE);

        manager = User.builder()
                .firstName("Mastro")
                .lastName("Lindo")
                .mail("mastrolindo@clean.ch")
                .build();
        manager.getRoles().add(Role.MANAGER);
        manager.getRoles().add(Role.CUSTOMER);

        System.out.println(customer1);
        System.out.println(customer2);
        System.out.println(employee);
        System.out.println(manager);

        customer = userRepository.save(customer1);
        userRepository.save(customer2);
        employee = userRepository.save(employee);
        manager = userRepository.save(manager);
    }

    private void addShops() {
        Shop shop1 = Shop.builder()
                .name("CleanIt Zürich")
                .location(new Address("Hauptstrasse 1", "8000", "Zürich"))
                .build();

        shop2 = Shop.builder()
                .name("CleanIt Basel")
                .location(new Address("Elisabethenanlage 1", "4000", "Basel"))
                .build();
        shop2.getManagers().add(manager);
        shop2.getEmployees().add(employee);

        System.out.println(shop1);
        System.out.println(shop2);

        shopRepository.save(shop1);
        shopRepository.save(shop2);
    }

    private void addOrders() {
        Order order1 = Order.builder()
                .orderState(OrderState.RETURNED)
                .shop(shop2)
                .customer(customer)
                .washed(LocalDateTime.of(2025, 12, 10, 10, 0))
                .finished(LocalDateTime.of(2025, 12, 10, 13, 0))
                .build();

        Order order2 = Order.builder()
                .shop(shop2)
                .customer(customer)
                .build();

        Order order3 = Order.builder()
                .orderState(OrderState.CLEANED)
                .shop(shop2)
                .customer(customer)
                .washed(LocalDateTime.of(2025, 12, 1, 15, 0))
                .build();

        orderRepository.save(order1);
        orderRepository.save(order2);
        orderRepository.save(order3);
    }
}
