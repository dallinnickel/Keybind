package model.profiles.commands;

import model.profiles.database.profileDatabase;
import model.profiles.entities.profile;

/**
 * Remove a hotkey from a profile
 */
public class removeHotkey extends CommandStatus{
    /**
     * Remove a hot key from the given profiles hotkey treemap
     * @param name name of the profile to remove from
     * @param id id of the hotkey to be removed
     */
    public void RemoveHotkey(String name, int id){
        if(!profileDatabase.database().containsKey(name)){
            successful = false;
            errorMessage = "No profile with name: " + name;
        }
        profile p = profileDatabase.database().get(name);
        p.removeHotKey(id);
    }
}
