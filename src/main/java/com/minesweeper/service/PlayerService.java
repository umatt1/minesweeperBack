package com.minesweeper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;
import com.minesweeper.repo.PlayerRepository;
import com.minesweeper.model.Player;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Optional<Player> getPlayerById(Long playerId) {
        return playerRepository.findById(playerId);
    }

    public Player createPlayer(Player player) {
        // Hash and salt the password before saving
        // You should use a secure password hashing library (e.g., BCryptPasswordEncoder)
        if (player.getPassword() != null) {
            String hashedPassword = hashAndSaltPassword(player.getPassword());
            player.setPassword(hashedPassword);
        }


        return playerRepository.save(player);
    }

    public void deletePlayer(Long playerId) {
        playerRepository.deleteById(playerId);
    }

    private boolean usernameExists(String username) {
        return playerRepository.findByUsername(username).isPresent();
    }

    private boolean emailExists(String email) {
        return playerRepository.findByEmail(email).isPresent();
    }

    private String hashAndSaltPassword(String password) {
        // Implement a secure password hashing and salting mechanism
        // You should use a dedicated library like BCryptPasswordEncoder
        // For simplicity, this example uses a placeholder method.
        int strength = 10;
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(strength, new SecureRandom());
        return bCryptPasswordEncoder.encode(password);
    }
}
