package com.wruthless.persistentcollections;

import com.wruthless.persistentcollections.model.Orders;
import com.wruthless.persistentcollections.model.Users;
import com.wruthless.persistentcollections.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Users processUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Transactional
    public List<Orders> getUserOrders(Long userId) {
        Users user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("[!] User not found."));
        user.getOrders().size();
        return user.getOrders();
    }

}
