package ch.cleanit.backend.api;

import ch.cleanit.backend.model.User;
import ch.cleanit.backend.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
