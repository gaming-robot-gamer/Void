package Locations;

import java.util.ArrayList;

public class LocManager {
    public ArrayList<Location> allLocs = new ArrayList<Location>(); // TODO: Add all locations to this list
    
    public LocManager() {
        
    }

    public static LocManager instance = new LocManager();


    public static void createLocation(Location.LocType type, Location.LocAlignment alignment) {
        switch (type) {
            case ASTEROID:
                new Asteroid(10, alignment);
                break;
            case MOON:
                new Moon(100, alignment);
                break;
            case SPACE_STATION:
                new SpaceStation(50, alignment);
                break;
            default:
                break;
        }
    }
        
    
}
