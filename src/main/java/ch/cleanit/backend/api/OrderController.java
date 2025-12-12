package ch.cleanit.backend.api;

import ch.cleanit.backend.api.dto.CreateOrderDTO;
import ch.cleanit.backend.exception.NoSuchCustomerFoundException;
import ch.cleanit.backend.exception.NoSuchShopFoundException;
import ch.cleanit.backend.model.Order;
import ch.cleanit.backend.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        } catch (NoSuchShopFoundException | NoSuchCustomerFoundException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<Order>> all() {
        List<Order> orders = orderService.getAll();
        return ResponseEntity.ok(orders);
    }
}