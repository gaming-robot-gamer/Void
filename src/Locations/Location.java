package Locations;

import java.util.ArrayList;

public class Location {

    public LocType locType;
    public String name;
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
        ASTEROID, MOON, SPACE_STATION, VOID
    }

    public String getLocActions() {
        String locActions = "";
        int i = 1;
        for (String action : locOptions) {
            locActions += i + ". " + action + "\n";
            i++;
        }
        return locActions;
    }

    public LocType getLocType() {
        return locType;
    }

    public String getName() {
        return name;
    }


}
