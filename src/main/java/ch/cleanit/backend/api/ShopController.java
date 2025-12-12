package ch.cleanit.backend.api;

import ch.cleanit.backend.model.Shop;
import ch.cleanit.backend.model.User;
import ch.cleanit.backend.service.ShopService;
import ch.cleanit.backend.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/shops")
public class ShopController {

    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping
    public ResponseEntity<List<Shop>> getAll() {
        List<Shop> orders = shopService.getAll();
        return ResponseEntity.ok(orders);
    }
}
