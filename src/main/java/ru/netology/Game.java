package ru.netology;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Game {

    //    List<Player> players = new ArrayList<>();
    HashMap<String, Integer> players = new HashMap<>();


    public void register(Player player) {
        if (players.get(player.getName()) != null) {
            throw new AlreadyExistsException("Player with name: " + player.getName() + " already exists");
        } else {
            players.put(player.getName(), player.getStrength());
        }
    }

    public int round(String playerName1, String playerName2) {
        if (!players.containsKey(playerName1) && !players.containsKey(playerName2)) {
            throw new NotRegisteredException("Players with name: " + playerName1 + ", " + playerName2 + "are not registered");
        } else if (!players.containsKey(playerName1)) {
            throw new NotRegisteredException("Player with name: " + playerName1 + "is not registered");
        } else if (!players.containsKey(playerName2)) {
            throw new NotRegisteredException("Player with name: " + playerName2 + "is not registered");

        } else if (players.get(playerName1) > players.get(playerName2)) {
            return 1;
        } else if (players.get(playerName1) < players.get(playerName2)) {
            return 2;
        } else {
            return 0;
        }
    }


}

