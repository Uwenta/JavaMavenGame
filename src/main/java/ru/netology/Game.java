package ru.netology;

import java.util.ArrayList;
import java.util.List;

public class Game {

    List<Player> players = new ArrayList<>();

    public Player findById(int id) {
        for (Player player : players) {
            if (player.getId() == id) {
                return player;
            }
        }
        return null;
    }

    public Player findByName(String name) {
        for (Player player : players) {
            if (player.getName().contains(name)) {
                return player;
            }
        }
        return null;
    }

    public void register(Player player) {
        if (findById(player.getId()) != null) {
            throw new AlreadyExistsException("Player with ID: " + player.getId() + " already exists");
        } else if (findByName(player.getName()) != null) {
            throw new AlreadyExistsException("Player with name: " + player.getName() + " already exists");
        } else {
            players.add(player);
        }
    }

    public int round(String playerName1, String playerName2) {
        if (findByName(playerName1) == null && findByName(playerName2) == null) {
            throw new NotRegisteredException("Players with name: " + playerName1 + ", " + playerName2 + "are not registered");
        } else if (findByName(playerName1) == null) {
            throw new NotRegisteredException("Player with name: " + playerName1 + "is not registered");
        } else if (findByName(playerName2) == null) {
            throw new NotRegisteredException("Player with name: " + playerName2 + "is not registered");

        } else if (findByName(playerName1).getStrength() > findByName(playerName2).getStrength()) {
            return 1;
        } else if (findByName(playerName1).getStrength() < findByName(playerName2).getStrength()) {
            return 2;
        } else {
            return 0;
        }
    }


}

