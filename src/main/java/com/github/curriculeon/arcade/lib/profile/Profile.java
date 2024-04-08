package com.github.curriculeon.arcade.lib.profile;

/**
 * Created by leon on 6/25/2020.
 * @ATTENTION_TO_STUDENTS - You are advised against modifying this class
 */
public class Profile implements ProfileInterface {
    private final Long profileId;
    private final String name;
    private Double balance;

    public Profile(String name, Double balance, Long profileId) {
        this.name = name;
        this.balance = balance;
        this.profileId = profileId;
    }


    @Override
    public void setBalance(Double newBalance) {
        this.balance = newBalance;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Long getId() {
        return this.profileId;
    }
}
