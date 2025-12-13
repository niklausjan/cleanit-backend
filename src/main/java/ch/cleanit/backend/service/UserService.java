package ch.cleanit.backend.service;

import ch.cleanit.backend.model.Role;
import ch.cleanit.backend.model.User;
import ch.cleanit.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllCustomers() {
        return userRepository.findAllCustomers();
    }

    public User createCustomer(String firstName, String lastName, String mail) {
        List<Role> roles = new ArrayList<>();
        roles.add(Role.CUSTOMER);
        User newUser = User.builder()
                .firstName(firstName)
                .lastName(lastName)
                .mail(mail)
                .roles(roles).build();

        return userRepository.save(newUser);
    }
}
