package com.wruthless.persistentcollections;

import com.wruthless.persistentcollections.model.Users;
import com.wruthless.persistentcollections.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    // The @InjectMocks annotation tells Mockito to create an instance of the class (UserService)
    // and inject the mocks marked with @Mock into it.
    @InjectMocks
    UserService userService;

    // The @Mock annotation tells Mockito to create a mock implementation of the class (UserRepository).
    @Mock
    UserRepository userRepository;

    // The @BeforeEach annotation tells JUnit to run this method before each test.
    // Here, we're initializing our mocks using MockitoAnnotations.openMocks(this).
    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testProcessUser() {
        Users user = new Users();
        user.setId(1L);
        user.setName("John");

        // We're telling Mockito that when userRepository.findById(1L) is called,
        // it should return an Optional containing the Users object we just created.
        // Optional is a container object that may or may not contain a non-null value.
        // It's used to represent the optional return type of a method which may not
        // always have a result.
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        Users result = userService.processUser(1L);

        assertEquals("John", result.getName());
    }
}
