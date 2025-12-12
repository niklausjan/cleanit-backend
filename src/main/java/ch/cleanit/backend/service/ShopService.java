package ch.cleanit.backend.service;

import ch.cleanit.backend.model.Shop;
import ch.cleanit.backend.model.User;
import ch.cleanit.backend.repository.ShopRepository;
import ch.cleanit.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService {
    private final ShopRepository shopRepository;

    public ShopService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public List<Shop> getAll() {
        return shopRepository.findAll();
    }
}
