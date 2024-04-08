package com.github.curriculeon.arcade.lib.game;

import com.github.curriculeon.arcade.lib.profile.ProfileInterface;

/**
 * Created by leon on 2/25/18.
 * @ATTENTION_TO_STUDENTS - You are advised against modifying this class
 */
public interface PlayerInterface {
    ProfileInterface getProfile();

    default String getName() {
        return getProfile().getName();
    }
}