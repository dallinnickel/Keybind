package model.profiles.commands;

import Controller.Action;
import model.Hotkey;
import model.Modifier;
import model.profiles.database.profileDatabase;
import model.profiles.entities.profile;

/**
 * Add a hot key to an existing profile
 */
public class addHotkey extends CommandStatus {
    /**
     * Adds a hotkey to the given profile
     * @param name Name of the profile to add a hotkey to
     * @param add the hotkey to add to the profile
     */
    public void AddHotkey(String name, int keyCode, Action add){
        if(!profileDatabase.database().containsKey(name)){
            successful = false;
            errorMessage = "Profile with name " + name + " does not exist";
        }
        else{
            profile p = profileDatabase.database().get(name);
            p.addHotkey(keyCode, add);
        }
    }
}
