package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class GameTest {

    Game game = new Game();

    public Player player1 = new Player(1, "Alex", 158);
    public Player player2 = new Player(2, "Alex", 51);
    public Player player3 = new Player(3, "Alena", 50);
    public Player player4 = new Player(4, "Sveta", 50);
    public Player player5 = new Player(5, "Pumm", 80);
    public Player player6 = new Player(5, "Pink", 54);
    public Player player7 = new Player(7, "Ula", 125);
    public Player player8 = new Player(8, "Rams", 31);


    @Test
    public void shouldRegisteredPlayers() {
        game.register(player1);
        game.register(player3);
        game.register(player4);
        game.register(player5);


        Player[] expected = {player1, player3, player4, player5};
        Player[] actual = new Player[4];

        Assertions.assertArrayEquals(expected, game.players.toArray(actual));
    }

    @Test
    public void registeredPlayersWithIdenticalId() {
        game.register(player4);
        game.register(player6);
        game.register(player7);
        game.register(player8);

        Assertions.assertThrows(AlreadyExistsException.class, () -> game.register(player5));

    }

    @Test
    public void registeredPlayersWithIdenticalName() {
        game.register(player1);
        game.register(player6);
        game.register(player7);
        game.register(player8);

        Assertions.assertThrows(AlreadyExistsException.class, () -> game.register(player2));

    }

    @Test
    public void shouldWonPlayer1() {
        game.register(player4);
        game.register(player6);
        game.register(player7);
        game.register(player8);

        int expected = 1;
        int actual = game.round("Ula", "Rams");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldWonPlayer2() {
        game.register(player4);
        game.register(player6);
        game.register(player7);
        game.register(player8);

        int expected = 2;
        int actual = game.round("Sveta", "Pink");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldDrawnGame() {
        game.register(player4);
        game.register(player3);
        game.register(player7);
        game.register(player8);

        int expected = 0;
        int actual = game.round("Sveta", "Alena");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldGameNotRegisteredPlayer1() {
        game.register(player4);
        game.register(player3);
        game.register(player7);


        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Sveta", "Rams"));
    }

    @Test
    public void shouldGameNotRegisteredPlayer2() {
        game.register(player8);
        game.register(player3);
        game.register(player7);


        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Sveta", "Rams"));
    }

    @Test
    public void shouldGameNotRegisteredAllPlayers() {
        game.register(player8);
        game.register(player3);
        game.register(player7);
        game.register(player1);


        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Sveta", "Pink"));
    }


}
