package ch.cleanit.backend.repository;

import ch.cleanit.backend.model.Role;
import ch.cleanit.backend.model.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
@Component
public class UserRepository {

    private final List<User> users = new ArrayList<>();

    public User save(User user) {
        users.add(user);
        return user;
    }

    public User findById(UUID id) {
        return users.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public User findByEmail(String email) {
        return users.stream()
                .filter(u -> u.getMail().equals(email))
                .findFirst()
                .orElse(null);
    }

    public List<User> findAllCustomers() {
        return users.stream()
                .filter(u -> u.getRoles().contains(Role.CUSTOMER))
                .toList();
    }
}
