package Locations;

import java.util.ArrayList;

public class Location {

    public LocType locType;
    public String name;
    
    public ArrayList<String> locOptions = new ArrayList<String>(){{add("Status Report");}};
    
    public Location(LocAlignment alignment) {
        
    }

    public enum LocAlignment {
        FRIENDLY, NEUTRAL, HOSTILE
    }

    public enum LocType {
        ASTEROID, MOON, SPACE_STATION, SPACE
    }

    public String getLocActions() {
        String locActions = "";
        for (String action : locOptions) {
            locActions += "\n" + action;
        }
        return locActions;
    }

    public LocType getLocType() {
        return locType;
    }

    public String getName() {
        return name;
    }

    public void updateOptions() { //only used for the Space location
        locOptions.set(0, "Dock at " + LocManager.getClosestLocation().getName());
        locOptions.set(1, "Travel");
    }

    


}
