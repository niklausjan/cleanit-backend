package ch.cleanit.backend.service;

import ch.cleanit.backend.model.User;
import ch.cleanit.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

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
}
