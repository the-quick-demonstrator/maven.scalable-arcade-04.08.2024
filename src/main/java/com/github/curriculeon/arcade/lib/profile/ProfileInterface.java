package com.github.curriculeon.arcade.lib.profile;

import com.github.curriculeon.arcade.lib.utils.InputOutputSocketInterface;

/**
 * Created by leon on 6/25/2020.
 * @ATTENTION_TO_STUDENTS - You are advised against modifying this class
 */
public interface ProfileInterface extends InputOutputSocketInterface {

    default void printInformation() {
        getConsole().println("Printing profile details");
        getConsole().println("\tName:\t\t %s", getName());
        getConsole().println("\tBalance:\t %s", getBalance());
        getConsole().println("\tId:\t\t\t %s", getId());
    }

    default void decreaseBalance(double amount) {
        increaseBalance(amount * -1);
    }

    default void increaseBalance(double amount) {
        double oldBalance = getBalance();
        double newBalance = oldBalance + amount;
        String deltaStr = newBalance > oldBalance ? "increased" : "decreased";

        setBalance(newBalance);
        getConsole().println("[ %s ]'s balance has %s from [ %s ] to [ %s ]", getName(), deltaStr, oldBalance, newBalance);
    }

    default Double createBetAmount() {
        double playerBalance = getBalance();
        double playerBet = getConsole().getLongInput("How much money would you like to bet this game, [ %s ] ?", getName());
        if (playerBet <= playerBalance) {
            return playerBet;
        } else {
            getConsole().println("You cannot bet more money than what is credited to your player-profile.");
            getConsole().println("Try inputting a valid less than [ %s ]", playerBalance);
            printInformation();
            return createBetAmount();
        }
    }

    void setBalance(Double newBalance);

    double getBalance();

    String getName();

    Long getId();
}
