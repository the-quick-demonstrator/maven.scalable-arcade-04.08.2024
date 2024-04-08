package com.github.curriculeon.arcade.lib.profile;

import com.github.curriculeon.arcade.lib.ArcadeInterface;
import com.github.curriculeon.arcade.lib.utils.DecisionInterface;
import com.github.curriculeon.arcade.lib.utils.InputOutputConsole;

import java.util.function.Consumer;

/**
 * Created by leon on 2/25/2018.
 * @ATTENTION_TO_STUDENTS - You are advised against modifying this class
 */
public enum ProfileManagerSelection implements DecisionInterface {
    SELECT((casino) -> {
        InputOutputConsole console = new InputOutputConsole();
        int numberOfProfiles = console.getIntegerInput("How many player profiles would you like to create?");
        casino.getProfileManager().createProfiles(numberOfProfiles);
    }),

    CREATE((casino) -> {
        casino
                .getProfileManager()
                .registerProfile(casino
                        .getProfileManager()
                        .createProfile());

    });

    private final Consumer<ArcadeInterface> profileConsumer;

    ProfileManagerSelection(Consumer<ArcadeInterface> casinoConsumer) {
        this.profileConsumer = casinoConsumer;
    }

    public void perform(ArcadeInterface casino) {
        profileConsumer.accept(casino);
    }
}
