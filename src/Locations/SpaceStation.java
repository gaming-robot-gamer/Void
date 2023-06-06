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
    
    public SpaceStation(int resources, LocAlignment alignment) {
        super(alignment);
        this.resources = resources;
        this.name = getRandomSSName();
        locType = LocType.SPACE_STATION;
        locOptions.add("Leave");
        locOptions.add("Mine");
        locOptions.add("Refuel");
        locOptions.add("Repair");
        locOptions.add("Buy Cargo");
        locOptions.add("Buy Fuel");
        locOptions.add("Buy Ammo");
        locOptions.add("Sell Cargo");
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
            locActions += action + "\n";
        }
        return locActions;
    }

}
