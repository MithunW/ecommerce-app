package com.ecommerce.ecom;

import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Getter
    private List<User> users =new ArrayList<>();
    private Long nextId =  1L;

    public List<User> createUsers(User user) {
        user.setId(nextId++);
        users.add(user);
        return users;
    }

    public Optional<User> getUserById(Long id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst();

    }

    public boolean updateUsers(Long id, User updatedUser) {
       return getUserById(id).map(user -> {user.setFirstName(updatedUser.getFirstName());user.setLastName(updatedUser.getLastName());return true;}).orElse(false);

    }
}
