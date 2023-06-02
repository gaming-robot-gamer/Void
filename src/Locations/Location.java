package Locations;

import java.util.ArrayList;

public class Location {
    public ArrayList<String> locOptions = new ArrayList<String>() {{
        add("Dock");
        add("Leave");
    }};
    
    public Location(LocAlignment alignment) {
        
    }

    public enum LocAlignment {
        FRIENDLY, NEUTRAL, HOSTILE
    }

    public enum LocType {
        ASTEROID, MOON, SPACE_STATION
    }

    public String getLocActions() {
        String locActions = "";
        for (String action : locOptions) {
            locActions += action + ",\n ";
        }
        return locActions;
    }



}
