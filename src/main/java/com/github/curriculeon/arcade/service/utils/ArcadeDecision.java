package com.github.curriculeon.arcade.service.utils;

import com.github.curriculeon.arcade.lib.ArcadeInterface;
import com.github.curriculeon.arcade.lib.profile.ProfileManagerMenu;
import com.github.curriculeon.arcade.lib.profile.ProfileManagerSelection;
import com.github.curriculeon.arcade.lib.utils.DecisionInterface;

import java.util.function.Consumer;

/**
 * Created by leon on 6/25/2020.
 * @ATTENTION_TO_STUDENTS - You are advised against modifying this class
 */
public enum ArcadeDecision implements DecisionInterface {
    MANAGE_PROFILE((casino) -> {
        ProfileManagerMenu profileManagerMenu = new ProfileManagerMenu();
        ProfileManagerSelection profileManagerSelection = profileManagerMenu.getInput();
        profileManagerSelection.perform(casino);
    }),

    SELECT_GAME((casino) -> {
        GameSelectionMenu gameSelectionMenu = new GameSelectionMenu();
        GameSelection gameSelection = gameSelectionMenu.getInput();
        gameSelection.perform();
    }),

    EXIT((casino) -> {
        casino.getProfileManager().printProfilesInformation();
    });


    private final Consumer<ArcadeInterface> casinoConsumer;

    ArcadeDecision(Consumer<ArcadeInterface> casinoConsumer) {
        this.casinoConsumer = casinoConsumer;
    }

    public void perform(ArcadeInterface casino) {
        casinoConsumer.accept(casino);
    }
}