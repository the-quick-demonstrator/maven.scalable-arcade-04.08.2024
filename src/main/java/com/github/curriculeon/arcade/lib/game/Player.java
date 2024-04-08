package com.github.curriculeon.arcade.lib.game;


import com.github.curriculeon.arcade.lib.profile.ProfileInterface;

/**
 * Created by leon on 6/25/2020.
 * @ATTENTION_TO_STUDENTS - You are advised against modifying this class
 */
public class Player implements PlayerInterface {
    private final ProfileInterface profile;

    public Player(ProfileInterface profile) {
        this.profile = profile;
    }

    public ProfileInterface getProfile() {
        return profile;
    }

    public String getName() {
        return profile.getName();
    }
}
