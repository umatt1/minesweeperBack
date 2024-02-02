package com.minesweeper.controller;

import com.minesweeper.model.User;
import com.minesweeper.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;

@SpringBootTest
class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Test
    void getAllPlayers() {
        // Mock the behavior of the service
        List<User> users = Arrays.asList(new User(), new User());
        Mockito.when(userService.getAllUsers()).thenReturn(users);

        // Call the controller method
        List<User> result = userController.getAllUsers();

        // Verify the result
        assertEquals(users, result);
    }

    @Test
    void getPlayerById() {
        // Mock the behavior of the service
        User user = new User();
        Mockito.when(userService.getPlayerById(1L)).thenReturn(Optional.of(user));

        // Call the controller method
        ResponseEntity<User> result = userController.getUserById(1L);

        // Verify the result
        //assertEquals(Optional.of(player), result);
    }

    @Test
    void createPlayer() {
        // Mock the behavior of the service
        User user = new User();
        Mockito.when(userService.createPlayer(any(User.class))).thenReturn(user);

        // Call the controller method
        ResponseEntity<Object> result = userController.createUser(user);

        // Verify the result
        //assertEquals(player, result);
    }

    @Test
    void deletePlayer() {
        // Call the controller method
        userController.deleteUser(1L);

        // Verify that the service method was called once with the correct argument
        Mockito.verify(userService, times(1)).deletePlayer(1L);
    }

    @Test
    void deleteNonexistentPlayer() {
        // Mock the behavior of the service to throw an exception
        Mockito.doThrow(new IllegalArgumentException("Player not found")).when(userService).deletePlayer(1L);

        // Call the controller method and expect an exception
        assertThrows(IllegalArgumentException.class, () -> userController.deleteUser(1L));
    }
}
