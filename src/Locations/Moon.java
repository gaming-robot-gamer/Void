package Locations;

import java.util.ArrayList;

public class Moon extends Location{
    int resources;

    public ArrayList<String> MOON_NAMES = new ArrayList<String>() {{
        add("Ganymede");
        add("Callisto");
        add("Io");
        add("Europa");
        add("Amalthea");
        add("Himalia");
        add("Elara");
    }};
    public ArrayList<String> locOptions = new ArrayList<String>(super.locOptions) {{
        add("Mine");
        add("Refuel");
        add("Repair");
        add("Buy");
        add("Sell");
    }};

    public Moon(int resources, LocAlignment alignment) {
        super(alignment);
        this.resources = resources;
        locType = LocType.MOON;
    }

    public String getRandomMoonName() {
        int randomIndex = (int) (Math.random() * MOON_NAMES.size());
        String name = MOON_NAMES.get(randomIndex);
        MOON_NAMES.remove(randomIndex);
        return name;
    }
}
