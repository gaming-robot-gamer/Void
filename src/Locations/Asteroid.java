package Locations;

import java.util.ArrayList;

public class Asteroid extends Location{
    int resources;
    public ArrayList<String> ASTEROID_NAMES = new ArrayList<String>() {{
        add("Asteroid 1");
        add("Asteroid 2");
        add("Asteroid 3");
        add("Asteroid 4");
        add("Asteroid 5");
        add("Asteroid 6");
        add("Asteroid 7");
        add("Asteroid 8");
        add("Asteroid 9");
        add("Asteroid 10");
    }};


    public Asteroid(int resources, LocAlignment alignment) {
        super(alignment);
        this.name = getRandomAsteroidName();
        this.resources = resources;
        locType = LocType.ASTEROID;
        locOptions.add("Mine");
    }
        
    public String getRandomAsteroidName() {
        int randomIndex = (int) (Math.random() * ASTEROID_NAMES.size());
        String name = ASTEROID_NAMES.get(randomIndex);
        ASTEROID_NAMES.remove(randomIndex);
        return name;
    }
}
