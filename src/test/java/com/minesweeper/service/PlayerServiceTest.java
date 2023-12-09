package com.minesweeper.service;

import com.minesweeper.model.Player;
import com.minesweeper.repo.PlayerRepository;
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
class PlayerServiceTest {

    @Mock
    private PlayerRepository playerRepository;

    @InjectMocks
    private PlayerService playerService;

    @Test
    void getAllPlayers() {
        // Mock the behavior of the repository
        List<Player> players = Arrays.asList(new Player(), new Player());
        Mockito.when(playerRepository.findAll()).thenReturn(players);

        // Call the service method
        List<Player> result = playerService.getAllPlayers();

        // Verify the result
        assertEquals(players, result);
    }

    @Test
    void getPlayerById() {
        // Mock the behavior of the repository
        Player player = new Player();
        Mockito.when(playerRepository.findById(1L)).thenReturn(Optional.of(player));

        // Call the service method
        Optional<Player> result = playerService.getPlayerById(1L);

        // Verify the result
        assertEquals(Optional.of(player), result);
    }

    @Test
    void createPlayer() {
        // Mock the behavior of the repository
        Player player = new Player();
        Mockito.when(playerRepository.save(any(Player.class))).thenReturn(player);

        // Call the service method
        Player result = playerService.createPlayer(player);

        // Verify the result
        assertEquals(player, result);
    }

    @Test
    void deletePlayer() {
        // Call the service method
        playerService.deletePlayer(1L);

        // Verify that the repository method was called once with the correct argument
        Mockito.verify(playerRepository, times(1)).deleteById(1L);
    }

    @Test
    void deleteNonexistentPlayer() {
        // Mock the behavior of the repository to throw an exception
        Mockito.doThrow(new IllegalArgumentException("Player not found")).when(playerRepository).deleteById(1L);

        // Call the service method and expect an exception
        assertThrows(IllegalArgumentException.class, () -> playerService.deletePlayer(1L));
    }
}
