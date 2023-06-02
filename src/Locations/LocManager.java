package Locations;

import java.util.ArrayList;

public class LocManager {
    public static ArrayList<Location> allLocs = new ArrayList<Location>(){{
        add(new Asteroid(10, Location.LocAlignment.NEUTRAL));
    }};

    public static Location currentLocation;

    public LocManager() {
        currentLocation = allLocs.get(0); // ON GAME START, CURRENT LOCATION IS AN ASTEROID
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

    public static void generateLocation() {
        int rand = (int) (Math.random() * 9);
        switch (rand) {
            case 0:
                createLocation(Location.LocType.ASTEROID, Location.LocAlignment.NEUTRAL);
                break;
            case 1:
                createLocation(Location.LocType.MOON, Location.LocAlignment.NEUTRAL);
                break;
            case 2:
                createLocation(Location.LocType.SPACE_STATION, Location.LocAlignment.NEUTRAL);
                break;
            case 3:
                createLocation(Location.LocType.ASTEROID, Location.LocAlignment.HOSTILE);
                break;
            case 4:
                createLocation(Location.LocType.MOON, Location.LocAlignment.HOSTILE);
                break;
            case 5:
                createLocation(Location.LocType.SPACE_STATION, Location.LocAlignment.HOSTILE);
                break;
            case 6:
                createLocation(Location.LocType.ASTEROID, Location.LocAlignment.FRIENDLY);
                break;
            case 7:
                createLocation(Location.LocType.MOON, Location.LocAlignment.FRIENDLY);
                break;
            case 8:
                createLocation(Location.LocType.SPACE_STATION, Location.LocAlignment.FRIENDLY);
                break;
            default:
                break;
        }
    }

    public static Location getCurrentLocation() {
        return currentLocation;
    }
}