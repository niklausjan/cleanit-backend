package ch.cleanit.backend.service;

import ch.cleanit.backend.model.Role;
import ch.cleanit.backend.model.User;
import ch.cleanit.backend.repository.UserRepository;
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
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private User user;

    @BeforeEach
    void setUp() {
        user = User.builder()
                .firstName("Max")
                .lastName("Mustermann")
                .mail("max@example.com")
                .roles(List.of(Role.CUSTOMER))
                .build();
    }

    @Test
    void testGetAllCustomers() {
        when(userRepository.findAllCustomers()).thenReturn(List.of(user));

        List<User> result = userService.getAllCustomers();

        assertEquals(1, result.size());
        assertEquals(user, result.get(0));

        verify(userRepository).findAllCustomers();
    }

    @Test
    void testCreateCustomer() {
        when(userRepository.save(any(User.class))).thenReturn(user);

        User result = userService.createCustomer("Max", "Mustermann", "max@example.com");

        assertNotNull(result);
        assertEquals("Max", result.getFirstName());
        assertEquals("Mustermann", result.getLastName());
        assertEquals("max@example.com", result.getMail());
        assertTrue(result.getRoles().contains(Role.CUSTOMER));

        verify(userRepository).save(any(User.class));
    }

    @Test
    void testCreateCustomer_NullMail() {
        assertThrows(IllegalArgumentException.class, () -> userService.createCustomer("Max", "Mustermann", null));
        verify(userRepository, never()).save(any());
    }

    @Test
    void testCreateCustomer_EmptyFirstName() {
        assertThrows(IllegalArgumentException.class, () -> userService.createCustomer("", "Mustermann", "max@example.com"));
        verify(userRepository, never()).save(any());
    }
}
