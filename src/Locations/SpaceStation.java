package Locations;

import java.util.ArrayList;

public class SpaceStation extends Location{
    int resources;

    public static ArrayList<String> SS_NAMES = new ArrayList<String>() {{
        add("London Station");
        add("New York Station");
        add("Tokyo Station");
        add("Paris Station");
        add("Berlin Station");
        add("Moscow Station");
        add("Beijing Station");
        add("Sydney Station");
        add("Rio Station");
        add("Cairo Station");
    }};

    public ArrayList<String> locOptions = new ArrayList<String>(super.locOptions) {{
        add("Refuel");
        add("Repair");
        add("Buy Cargo");
        add("Buy Fuel");
        add("Buy Ammo");
        add("Sell Cargo");
    }};
    
    public SpaceStation(int resources, LocAlignment alignment) {
        super(alignment);
        this.resources = resources;
        locType = LocType.SPACE_STATION;
    }

    public String getRandomSSName() {
        int randomIndex = (int) (Math.random() * SS_NAMES.size());
        String name = SS_NAMES.get(randomIndex);
        SS_NAMES.remove(randomIndex);
        return name;
    }

    public String getLocActions() {
        String locActions = "";
        for (String action : locOptions) {
            locActions += action + ",\n ";
        }
        return locActions;
    }

}
