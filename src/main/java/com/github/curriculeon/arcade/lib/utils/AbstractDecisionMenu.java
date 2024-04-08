package com.github.curriculeon.arcade.lib.utils;

import java.util.Arrays;
import java.util.StringJoiner;

/**
 * Created by leon on 2/25/2018.
 * @ATTENTION_TO_STUDENTS - You are advised against modifying this class
 */
public abstract class AbstractDecisionMenu
        <SomeDecision extends Enum<SomeDecision> & DecisionInterface>
        implements MenuInterface<SomeDecision> {

    private final SomeDecision[] decisions;

    public AbstractDecisionMenu(SomeDecision[] decisions) {
        this.decisions = decisions;
    }

    @Override
    public SomeDecision[] getDecisions() {
        return decisions;
    }

    @Override
    public String toString() {
        return new StringJoiner("\n")
                .add(String.format("Welcome to the %s !", getClass().getSimpleName()))
                .add("From here you can select any of the following options:")
                .add(Arrays.toString(decisions))
                .toString();
    }
}
