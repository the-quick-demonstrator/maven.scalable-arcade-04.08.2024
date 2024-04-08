package com.github.curriculeon.arcade.lib.profile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leon on 6/25/2020.
 * @ATTENTION_TO_STUDENTS - You are advised against modifying this class
 */
public enum ProfileManager implements ProfileManagerInterface {
    INSTANCE;

    private List<ProfileInterface> profiles;

    ProfileManager(List<ProfileInterface> profiles) {
        this.profiles = profiles;
    }

    ProfileManager() {
        this(new ArrayList<>());
    }

    @Override
    public List<ProfileInterface> getProfiles() {
        return profiles;
    }

    @Override
    public void setProfiles(List<ProfileInterface> profileList) {
        this.profiles = profileList;
    }
}
