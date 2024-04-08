package com.github.curriculeon.arcade.lib.profile;

import com.github.curriculeon.arcade.lib.utils.InputOutputSocketInterface;

import java.util.List;
import java.util.function.Predicate;

/**
 * Created by leon on 6/25/2020.
 * @ATTENTION_TO_STUDENTS - You are advised against modifying this class
 */
public interface ProfileManagerInterface extends InputOutputSocketInterface {
    List<ProfileInterface> getProfiles();

    void setProfiles(List<ProfileInterface> profileList);

    /**
     * @return array of respective profile objects
     */

    default ProfileInterface createProfile() {
        getConsole().println("Creating new player profile...");
        String name = getConsole().getStringInput("Enter player's name");
        double startingBalance = getConsole().getDoubleInput("Enter balance");
        ProfileInterface newPlayer = new Profile(name, startingBalance, (long) getProfiles().size());
        return newPlayer;
    }

    /**
     * @param numberOfPlayers - number of profiles to create
     * @return array of respective profile objects
     */

    default ProfileInterface[] createProfiles(int numberOfPlayers) {
        ProfileInterface[] players = new ProfileInterface[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++) {
            ProfileInterface someNewGuy = createProfile();
            players[i] = someNewGuy;
        }
        return players;
    }

    /**
     * Select profile from memory, create profile if none exists
     *
     * @return selected profile
     */

    default ProfileInterface selectProfile() {
        if (!getProfiles().isEmpty()) {
            printProfilesInformation();
            long playerId = getConsole().getLongInput("Please enter the desired player-profile's id number: ");
            for (ProfileInterface player : getProfiles()) {
                if (player.getId() == playerId) {
                    return player;
                }
            }
            getConsole().println("[ %s ] is not a profile-id that our records recognize.", playerId);
        } else {
            getConsole().println("There are currently no profiles in our records.");
            getConsole().println("Try creating a profile first.");
        }
        return createProfile();
    }

    /**
     * Print information from each profile in memory
     */

    default void printProfilesInformation() {
        getConsole().println("Displaying a list of player-profiles registered at our Casino...");
        for (ProfileInterface profile : getProfiles()) {
            profile.printInformation();
        }
    }


    default void registerProfile(ProfileInterface profile) {
        String name = profile.getName();
        long profileId = profile.getId();
        getConsole().println("Checking database for user [ %s ].", name);
        if (getProfiles().contains(profile)) {
            getConsole().println("Welcome back, %s!", name);
            profile.printInformation();
        } else {
            getConsole().println("The Casino has registered a new profile!");
            getConsole().println("Profile-name is [ %s ]", name);
            getConsole().println("Profile-id is [ %s ]", profileId);
            getProfiles().add(profile);
        }
    }


    default boolean contains(ProfileInterface someDude) {
        return getProfiles().contains(someDude);
    }

    default ProfileInterface getProfileById(Long id) {
        return getProfileWhere(profile -> profile.getId().equals(id));
    }

    default ProfileInterface getProfileWhere(Predicate<ProfileInterface> profilePredicate) {
        return getProfiles()
                .stream()
                .filter(profilePredicate)
                .findFirst()
                .get();
    }
}
