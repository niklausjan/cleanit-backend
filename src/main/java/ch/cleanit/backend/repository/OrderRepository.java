package ch.cleanit.backend.repository;

import ch.cleanit.backend.model.Order;
import org.springframework.stereotype.Repository;

import java.sql.Array;
import java.util.*;

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

    public List<Order> findAllByShopId(UUID shopId) {
        return orders.stream()
                .filter(o -> o.getShop().getId().equals(shopId)).toList();
    }
}
