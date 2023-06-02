package Locations;

import java.util.ArrayList;

public class LocManager {
    public static ArrayList<Location> allLocs = new ArrayList<Location>(){{
        add(new Asteroid(10, Location.LocAlignment.NEUTRAL));
    }};
    
    public static Location currentLocation;

    public LocManager() {
        currentLocation = allLocs.get(0); //ON GAME START, CURRENT LOCATION IS AN ASTRERIOD
    }

    public static LocManager instance = new LocManager();


    public static void createLocation(Location.LocType type, Location.LocAlignment alignment) {
        switch (type) {
            case ASTEROID:
                allLocs.add(new Asteroid(10, alignment));
                break;
            case MOON:
                allLocs.add(new Moon(100, alignment));
                break;
            case SPACE_STATION:
                allLocs.add(new SpaceStation(50, alignment));
                break;
            default:
                break;
        }

        if (alignment == Location.LocAlignment.HOSTILE) {
            allLocs.get(allLocs.size() - 1).locOptions.add("Attack");
            
        }
    }
    
}
