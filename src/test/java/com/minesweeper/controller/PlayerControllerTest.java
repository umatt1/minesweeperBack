package com.minesweeper.controller;

import com.minesweeper.controller.PlayerController;
import com.minesweeper.model.Player;
import com.minesweeper.service.PlayerService;
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
class PlayerControllerTest {

    @Mock
    private PlayerService playerService;

    @InjectMocks
    private PlayerController playerController;

    @Test
    void getAllPlayers() {
        // Mock the behavior of the service
        List<Player> players = Arrays.asList(new Player("1L", "John"), new Player("2L", "Jane"));
        Mockito.when(playerService.getAllPlayers()).thenReturn(players);

        // Call the controller method
        List<Player> result = playerController.getAllPlayers();

        // Verify the result
        assertEquals(players, result);
    }

    @Test
    void getPlayerById() {
        // Mock the behavior of the service
        Player player = new Player("1L", "John");
        Mockito.when(playerService.getPlayerById(1L)).thenReturn(Optional.of(player));

        // Call the controller method
        Optional<Player> result = playerController.getPlayerById(1L);

        // Verify the result
        assertEquals(Optional.of(player), result);
    }

    @Test
    void createPlayer() {
        // Mock the behavior of the service
        Player player = new Player("1L", "John");
        Mockito.when(playerService.createPlayer(any(Player.class))).thenReturn(player);

        // Call the controller method
        Player result = playerController.createPlayer(player);

        // Verify the result
        assertEquals(player, result);
    }

    @Test
    void deletePlayer() {
        // Call the controller method
        playerController.deletePlayer(1L);

        // Verify that the service method was called once with the correct argument
        Mockito.verify(playerService, times(1)).deletePlayer(1L);
    }

    @Test
    void deleteNonexistentPlayer() {
        // Mock the behavior of the service to throw an exception
        Mockito.doThrow(new IllegalArgumentException("Player not found")).when(playerService).deletePlayer(1L);

        // Call the controller method and expect an exception
        assertThrows(IllegalArgumentException.class, () -> playerController.deletePlayer(1L));
    }
}
