package ch.cleanit.backend.repository;

import ch.cleanit.backend.model.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class OrderRepository {

    private final List<Order> orders = new ArrayList<>();

    public List<Order> findAll() {
        return orders;
    }

    public Order save(Order order) {
        orders.add(order);
        return order;
    }

    public Order findById(UUID id) {
        return orders.stream()
                .filter(o -> o.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
