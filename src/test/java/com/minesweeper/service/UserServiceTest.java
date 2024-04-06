package com.minesweeper.service;

import com.minesweeper.model.User;
import com.minesweeper.repo.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;

@SpringBootTest
class UserServiceTest {

//    @Mock
//    private UserRepository userRepository;
//
//    @InjectMocks
//    private UserService userService;

//    @Test
//    void getAllPlayers() {
//        // Mock the behavior of the repository
//        List<User> users = Arrays.asList(new User(), new User());
//        Mockito.when(userRepository.findAll()).thenReturn(users);
//
//        // Call the service method
////        List<User> result = userService.getAllUsers();
//
//        // Verify the result
////        assertEquals(users, result);
//    }

//    @Test
//    void getPlayerById() {
//        // Mock the behavior of the repository
//        User user = new User();
//        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(user));
//
//        // Call the service method
////        Optional<User> result = userService.getPlayerById(1L);
//
//        // Verify the result
////        assertEquals(Optional.of(user), result);
//    }

//    @Test
//    void createPlayer() {
//        // Mock the behavior of the repository
//        User user = new User();
//        Mockito.when(userRepository.save(any(User.class))).thenReturn(user);
//
//        // Call the service method
////        User result = userService.createPlayer(user);
//
//        // Verify the result
////        assertEquals(user, result);
//    }

//    @Test
//    void deletePlayer() {
//        // Call the service method
////        userService.deletePlayer(1L);
//
//        // Verify that the repository method was called once with the correct argument
////        Mockito.verify(userRepository, times(1)).deleteById(1L);
//    }

//    @Test
//    void deleteNonexistentPlayer() {
//        // Mock the behavior of the repository to throw an exception
////        Mockito.doThrow(new IllegalArgumentException("Player not found")).when(userRepository).deleteById(1L);
//
//        // Call the service method and expect an exception
////        assertThrows(IllegalArgumentException.class, () -> userService.deletePlayer(1L));
//    }
}
