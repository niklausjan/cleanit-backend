package ch.cleanit.backend.service;

import ch.cleanit.backend.model.Order;
import ch.cleanit.backend.model.Shop;
import ch.cleanit.backend.model.User;
import ch.cleanit.backend.repository.OrderRepository;
import ch.cleanit.backend.repository.ShopRepository;
import ch.cleanit.backend.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private ShopRepository shopRepository;

    @InjectMocks
    private OrderService orderService;

    private UUID customerId;
    private UUID shopId;
    private User user;
    private Shop shop;
    private Order order;

    @BeforeEach
    void setUp() {
        customerId = UUID.randomUUID();
        shopId = UUID.randomUUID();
        user = new User(); // ggf. mit Builder oder Konstruktor initialisieren
        shop = new Shop();
        order = Order.builder()
                .customer(user)
                .shop(shop)
                .build();
    }

    @Test
    void testCreateOrder() {
        when(userRepository.findById(customerId)).thenReturn(user);
        when(shopRepository.findById(shopId)).thenReturn(shop);
        when(orderRepository.save(any(Order.class))).thenReturn(order);

        Order result = orderService.createOrder(customerId, shopId);

        assertNotNull(result);
        assertEquals(user, result.getCustomer());
        assertEquals(shop, result.getShop());

        verify(userRepository).findById(customerId);
        verify(shopRepository).findById(shopId);
        verify(orderRepository).save(any(Order.class));
    }

    @Test
    void testGetAll() {
        when(orderRepository.findAll()).thenReturn(List.of(order));

        List<Order> result = orderService.getAll();

        assertEquals(1, result.size());
        assertEquals(order, result.get(0));

        verify(orderRepository).findAll();
    }

    @Test
    void testGetAllByShop() {
        when(orderRepository.findAllByShopId(shopId)).thenReturn(List.of(order));

        List<Order> result = orderService.getAllByShop(shopId);

        assertEquals(1, result.size());
        assertEquals(order, result.get(0));

        verify(orderRepository).findAllByShopId(shopId);
    }

    @Test
    void testCreateOrder_UserNotFound() {
        when(userRepository.findById(customerId)).thenThrow(IllegalArgumentException.class);

        assertThrows(IllegalArgumentException.class, () -> orderService.createOrder(customerId, shopId));

        verify(userRepository).findById(customerId);
        verify(orderRepository, never()).save(any());
    }

    @Test
    void testCreateOrder_ShopNotFound() {
        when(userRepository.findById(customerId)).thenReturn(user);
        when(shopRepository.findById(shopId)).thenThrow(IllegalArgumentException.class);

        assertThrows(IllegalArgumentException.class, () -> orderService.createOrder(customerId, shopId));

        verify(userRepository).findById(customerId);
        verify(shopRepository).findById(shopId);
        verify(orderRepository, never()).save(any());
    }

}
