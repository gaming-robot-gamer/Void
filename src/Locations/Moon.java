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
        
    }};

    public Moon(int resources, LocAlignment alignment) {
        super(alignment);
        this.resources = resources;
        locType = LocType.MOON;
        locOptions.add("Mine");
        locOptions.add("Refuel");
        locOptions.add("Repair");
        locOptions.add("Buy Cargo");
        locOptions.add("Buy Fuel");
        locOptions.add("Buy Ammo");
        locOptions.add("Sell Cargo");
    }

    public String getRandomMoonName() {
        int randomIndex = (int) (Math.random() * MOON_NAMES.size());
        String name = MOON_NAMES.get(randomIndex);
        MOON_NAMES.remove(randomIndex);
        return name;
    }
}
