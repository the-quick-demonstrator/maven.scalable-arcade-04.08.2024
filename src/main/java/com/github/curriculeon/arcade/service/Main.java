package com.github.curriculeon.arcade.service;

import com.github.curriculeon.arcade.lib.ArcadeInterface;
import com.github.curriculeon.arcade.service.utils.Arcade;

/**
 * Created by leon on 1/29/2017.
 * @ATTENTION_TO_STUDENTS - You are advised against modifying this class
 */
public class Main {
    public static void main(String[] args) {
        ArcadeInterface arcade = new Arcade();
        arcade.run();
    }
}
