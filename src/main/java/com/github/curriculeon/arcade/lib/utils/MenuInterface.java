package com.github.curriculeon.arcade.lib.utils;

import com.github.curriculeon.arcade.lib.utils.InputOutputSocketInterface;
import com.github.curriculeon.arcade.lib.utils.StringUtils;

/**
 * Created by leon on 6/25/2020.
 * @ATTENTION_TO_STUDENTS - You are advised against modifying this class
 */
public interface MenuInterface
        <SomeDecision extends Enum<SomeDecision> & DecisionInterface> extends InputOutputSocketInterface {

    SomeDecision[] getDecisions();

    default SomeDecision getInput() {
        String userInput = null;
        try {
            userInput = getInputFromUser();
            return getValueOf(userInput);
        } catch(IllegalArgumentException iae) {
            getConsole().println("[ %s ] is not a valid user-input.\nPlease try again.", userInput);
            return getInput();
        }
    }

    default void display() {
        getConsole().println(toString());
    }

    default String getInputFromUser() {
        String border = StringUtils.repeatString("-", 50);
        getConsole().println(border);
        display();
        return getConsole()
                .getStringInput("Select an option.")
                .toUpperCase();
    }

    @SuppressWarnings("all")
    default SomeDecision getValueOf(String userInput) {
        return (SomeDecision) SomeDecision.valueOf(getDecisions()[0].getClass(), userInput
                .replace(" ", "_")
                .toUpperCase());
    }

    default void handleIllegalInput(String input) {
        getConsole().println("Invalid input! %s is not valid input!", input);
        display();
    }
}
