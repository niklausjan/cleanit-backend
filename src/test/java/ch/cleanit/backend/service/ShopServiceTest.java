package ch.cleanit.backend.service;

import ch.cleanit.backend.model.Shop;
import ch.cleanit.backend.repository.ShopRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ShopServiceTest {

    @Mock
    private ShopRepository shopRepository;

    @InjectMocks
    private ShopService shopService;

    private Shop shop;

    @BeforeEach
    void setUp() {
        shop = new Shop(); // ggf. mit Werten initialisieren
    }

    @Test
    void testGetAll() {
        when(shopRepository.findAll()).thenReturn(List.of(shop));

        List<Shop> result = shopService.getAll();

        assertEquals(1, result.size());
        assertEquals(shop, result.get(0));

        verify(shopRepository).findAll();
    }

    @Test
    void testGetAll_EmptyList() {
        when(shopRepository.findAll()).thenReturn(List.of());

        List<Shop> result = shopService.getAll();

        assertTrue(result.isEmpty());
        verify(shopRepository).findAll();
    }
}
