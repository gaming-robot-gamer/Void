package Locations;

import java.util.ArrayList;

public class Asteroid extends Location{
    int resources;
    public ArrayList<String> ASTEROID_NAMES = new ArrayList<String>() {{
        add("Asteroid RN-0091784");
        add("Asteroid PL-9918304");
        add("Asteroid WF-8827402");
        add("Asteroid AQ-0796954");
        add("Asteroid CC-8827421");
        add("Asteroid OH-1212687");
        add("Asteroid FN-0992263");
        add("Asteroid MX-3312765");
        add("Asteroid YD-5473800");
        add("Asteroid KE-7084832");
        add("Asteroid RQ-0091784");
        add("Asteroid PX-9918304");
        add("Asteroid WC-8827402");
        add("Asteroid AG-0796954");
        add("Asteroid NC-8827421");
        add("Asteroid OH-1212687");
        add("Asteroid FN-0952263");
        add("Asteroid MX-3312765");
        add("Asteroid YD-5473800");
        add("Asteroid KE-7994832");
        add("Asteroid RQ-0001784");
        add("Asteroid PL-9918304");
        add("Asteroid WU-8827402");
        add("Asteroid BQ-0796954");
        add("Asteroid CV-8227421");
        add("Asteroid OG-1212687");
        add("Asteroid FL-0192263");
        add("Asteroid MX-3512765");
        add("Asteroid YD-5473800");
        add("Asteroid KE-7444832");
    }};


    public Asteroid(int resources, LocAlignment alignment) {
        super(alignment);
        this.name = getRandomAsteroidName();
        this.resources = resources;
        locType = LocType.ASTEROID;
        locOptions.add("Leave");
        locOptions.add("Mine");
        locOptions.add("Repair");
    }
        
    public String getRandomAsteroidName() {
        int randomIndex = (int) (Math.random() * ASTEROID_NAMES.size());
        String name = ASTEROID_NAMES.get(randomIndex);
        ASTEROID_NAMES.remove(randomIndex);
        return name;
    }
}
