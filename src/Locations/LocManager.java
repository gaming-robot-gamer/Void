package Locations;

import java.util.ArrayList;

import Locations.Location.LocAlignment;
import Locations.Location.LocType;

public class LocManager {
    public static ArrayList<Location> allLocs = new ArrayList<Location>(){{
        add(new Space());
        add(new Asteroid(10, Location.LocAlignment.NEUTRAL));
    }};

    public static Location currentLocation;
    public static LocType currentLocType;

    public LocManager() {
    }
    
    public static void createLocation(LocType type, LocAlignment alignment) {
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

    public static void setCurrentLocation(Location loc) {
        currentLocation = loc;
    }

    public static void generateAsteroid() {
        createLocation(LocType.ASTEROID, LocAlignment.NEUTRAL);
    }

    public static void generateMoon() {
        int rand = (int) (Math.random() * 3);
        switch (rand) {
            case 0:
                createLocation(LocType.MOON, LocAlignment.NEUTRAL);
                break;
            case 1:
                createLocation(LocType.MOON, LocAlignment.HOSTILE);
                break;
            case 2:
                createLocation(LocType.MOON, LocAlignment.FRIENDLY);
                break;
        }
    }

    public static void generateSS() {
        int rand = (int) (Math.random() * 3);
        switch (rand) {
            case 0:
                createLocation(LocType.SPACE_STATION, LocAlignment.NEUTRAL);
                break;
            case 1:
                createLocation(LocType.SPACE_STATION, LocAlignment.HOSTILE);
                break;
            case 2:
                createLocation(LocType.SPACE_STATION, LocAlignment.FRIENDLY);
                break;
        }
    }

    public static void generateLocation() {
        int rand = (int) (Math.random() * 9);
        switch (rand) {
            case 0:
                createLocation(LocType.ASTEROID, LocAlignment.NEUTRAL);
                break;
            case 1:
                createLocation(LocType.MOON, LocAlignment.NEUTRAL);
                break;
            case 2:
                createLocation(LocType.SPACE_STATION, LocAlignment.NEUTRAL);
                break;
            case 3:
                createLocation(LocType.ASTEROID, LocAlignment.HOSTILE);
                break;
            case 4:
                createLocation(LocType.MOON, LocAlignment.HOSTILE);
                break;
            case 5:
                createLocation(LocType.SPACE_STATION, LocAlignment.HOSTILE);
                break;
            case 6:
                createLocation(LocType.ASTEROID, LocAlignment.FRIENDLY);
                break;
            case 7:
                createLocation(LocType.MOON, LocAlignment.FRIENDLY);
                break;
            case 8:
                createLocation(LocType.SPACE_STATION, LocAlignment.FRIENDLY);
                break;
            default:
                break;
        }
    }

    public static Location getCurrentLocation() {
        return currentLocation;
    }

    public static Location getClosestLocation() {
        return allLocs.get(allLocs.size() - 1);
    }

}