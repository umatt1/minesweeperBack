package com.minesweeper.model;

import com.minesweeper.model.Player;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {

    @Test
    void playerConstructorAndGetterSetter() {
        // Given
        String username = "testUser";
        String password = "testPassword";

        // When
        Player player = new Player();

        player.setUsername("newUsername");
        player.setPassword("newPassword");

        // Then
        assertThat(player.getUsername()).isEqualTo("newUsername");
        assertThat(player.getPassword()).isEqualTo("newPassword");
    }

    /*@Test
    void playerEquality() {
        // Given
        Player player1 = new Player("user1", "pass1");
        Player player2 = new Player("user1", "pass1");
        Player player3 = new Player("user2", "pass2");

        // Then
        assertThat(player1).isEqualTo(player2);
        assertThat(player1).isNotEqualTo(player3);
    }*/
}
