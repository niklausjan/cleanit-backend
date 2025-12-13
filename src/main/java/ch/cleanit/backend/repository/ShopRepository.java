package ch.cleanit.backend.repository;

import ch.cleanit.backend.model.Shop;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class ShopRepository {

    private final List<Shop> shops = new ArrayList<>();

    public List<Shop> findAll() {
        return shops;
    }

    public Shop findById(UUID id) {
        return shops.stream()
                .filter(shop -> shop.getId().equals(id)).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("the shop with the id=" + id + " was not found"));
    }

    public Shop save(Shop shop) {
        shops.add(shop);
        return shop;
    }
}
