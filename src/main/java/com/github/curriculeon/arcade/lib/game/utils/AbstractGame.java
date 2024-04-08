package com.github.curriculeon.arcade.lib.game.utils;


import com.github.curriculeon.arcade.lib.game.PlayerInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * Created by leon on 2/25/18.
 * @ATTENTION_TO_STUDENTS - You are advised against modifying this class
 */
abstract public class AbstractGame<PlayerType extends PlayerInterface> implements GameInterface<PlayerType> {
    protected List<PlayerType> players;

    public AbstractGame(PlayerType... players) {
        this.players = new ArrayList<>(new LinkedHashSet<>(Arrays.asList(players)));
    }

    @Override
    public List<PlayerType> getPlayers() {
        return players;
    }
}
