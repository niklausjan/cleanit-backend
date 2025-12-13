package ch.cleanit.backend.api;

import ch.cleanit.backend.api.dto.CreateCustomerDTO;
import ch.cleanit.backend.model.User;
import ch.cleanit.backend.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/customers")
    public ResponseEntity<List<User>> all() {
        List<User> orders = userService.getAllCustomers();
        return ResponseEntity.ok(orders);
    }

    @PostMapping("/customers")
    public ResponseEntity<User> createCustomer(@RequestBody CreateCustomerDTO request) {
        User customer = userService.createCustomer(request.firstName(), request.lastName(), request.mail());
        return ResponseEntity.ok(customer);
    }
}
