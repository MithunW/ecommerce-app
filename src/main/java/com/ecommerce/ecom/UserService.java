package com.ecommerce.ecom;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void createUsers(User user) {

        userRepository.save(user);
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);

    }

    public boolean updateUsers(Long id, User updatedUser) {
       return userRepository.findById(id).map(user -> {user.setFirstName(updatedUser.getFirstName()); user.setLastName(updatedUser.getLastName());userRepository.save(user); return true;}).orElse(false);

    }
}
