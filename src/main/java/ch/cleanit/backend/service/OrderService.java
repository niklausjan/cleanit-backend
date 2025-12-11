package ch.cleanit.backend.service;

import ch.cleanit.backend.model.Order;
import ch.cleanit.backend.model.Shop;
import ch.cleanit.backend.model.User;
import ch.cleanit.backend.repository.OrderRepository;
import ch.cleanit.backend.repository.ShopRepository;
import ch.cleanit.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ShopRepository shopRepository;

    public OrderService(OrderRepository orderRepository, UserRepository userRepository, ShopRepository shopRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.shopRepository = shopRepository;
    }

    public Order createOrder(UUID customerId, UUID shopId) {
        User customer = userRepository.findById(customerId);
        Shop shop = shopRepository.findById(shopId);

        Order order = Order.builder()
                .customer(customer)
                .shop(shop)
                .build();

        return orderRepository.save(order);
    }

    public List<Order> getAll() {
        return orderRepository.findAll();
    }
}
