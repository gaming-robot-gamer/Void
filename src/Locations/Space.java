package Locations;

public class Space extends Location{
    
    public Space() {
        super(Location.LocAlignment.NEUTRAL);
        this.name = "Space";
        locType = LocType.SPACE;
        locOptions.add("");
        locOptions.add("Status Report");
    }


}
