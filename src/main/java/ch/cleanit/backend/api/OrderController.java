package ch.cleanit.backend.api;

import ch.cleanit.backend.api.dto.CreateOrderDTO;
import ch.cleanit.backend.model.Order;
import ch.cleanit.backend.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Order> create(@RequestBody CreateOrderDTO request) {
        try {
            Order order = orderService.createOrder(request.customerId(), request.shopId());
            return ResponseEntity.ok(order);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllByShop(@RequestParam String shopId) {
        try {
            UUID id = UUID.fromString(shopId);
            List<Order> orders = orderService.getAllByShop(id);
            return ResponseEntity.ok(orders);
        } catch (IllegalArgumentException e) {
            List<Order> orders = orderService.getAll();
            return ResponseEntity.ok(orders);
        }
    }
}