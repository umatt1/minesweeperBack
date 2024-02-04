package com.minesweeper.model;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    @Test
    void playerConstructorAndGetterSetter() {
        // Given
        String username = "testUser";
        String password = "testPassword";

        // When
        User user = new User();

        user.setUsername("newUsername");
        user.setPassword("newPassword");

        // Then
        assertThat(user.getUsername()).isEqualTo("newUsername");
        assertThat(user.getPassword()).isEqualTo("newPassword");
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
