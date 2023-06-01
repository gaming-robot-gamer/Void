public class Ship {
    double durability, speed, fuel, maxFuel, maxDurability, ammo, maxAmmo, cargo, maxCargo;
    String name;
    ShipType type;

    public enum ShipType {
        LIGHT, MEDIUM, HEAVY
    }

    public Ship(String name, ShipType type, double durability, double speed, double fuel, double ammo, double cargo) {
        this.name = name;
        this.type = type;
        this.durability = durability;
        this.speed = speed;
        this.fuel = fuel;
        this.ammo = ammo;
        this.maxDurability = durability;
        this.maxFuel = fuel;
        this.maxAmmo = ammo;
    }

    public Ship(String name, ShipType type) {
        if (type == ShipType.LIGHT) {
            this.name = name;
            this.type = type;
            this.durability = 25;
            this.speed = 100;
            this.fuel = 25;
            this.ammo = 25;
            this.maxDurability = 25;
            this.maxFuel = 25;
            this.maxAmmo = 25;
            this.cargo = 10;
            this.maxCargo = 25;
        } else if (type == ShipType.MEDIUM) {
            this.name = name;
            this.type = type;
            this.durability = 50;
            this.speed = 50;
            this.fuel = 50;
            this.ammo = 50;
            this.maxDurability = 50;
            this.maxFuel = 50;
            this.maxAmmo = 50;
            this.cargo = 25;
            this.maxCargo = 50;
        } else if (type == ShipType.HEAVY) {
            this.name = name;
            this.type = type;
            this.durability = 100;
            this.speed = 25;
            this.fuel = 100;
            this.ammo = 100;
            this.maxDurability = 100;
            this.maxFuel = 100;
            this.maxAmmo = 100;
            this.cargo = 50;
            this.maxCargo = 100;
        } else {
            System.out.println("Invalid ship type!");
        }
    }

    public String getAllStats() {
        String stats;
        stats = "Name : " + name + "\n";
        stats += "Type : " + type + "\n";
        stats += "Durability : " + durability + "\n";
        stats += "Speed : " + speed + "\n";
        stats += "Fuel : " + fuel + "\n";
        stats += "Ammo : " + ammo + "\n";
        return stats;
    }

    public String getName() {
        return name;
    }

    public ShipType getType() {
        return type;
    }

    public double getDurability() {
        return durability;
    }

    public double getSpeed() {
        return speed;
    }

    public double getFuel() {
        return fuel;
    }

    public double getAmmo() {
        return ammo;
    }

    public void damage(double damage) {
        durability -= damage;
        if (durability < 0) {
            durability = 0;
        }
    }

    public void repair(double repair) {
        durability += repair;
        if (durability > maxDurability) {
            durability = maxDurability;
        }
    }

    public void shoot(double shots) {
        ammo -= shots;
        if (ammo < 0) {
            ammo = 0;
        }
    }

    public void reload(double reload) {
        ammo += reload;
        if (ammo > maxAmmo) {
            ammo = maxAmmo;
        }
    }

    public void move(double distance) {
        fuel -= distance;
        if (fuel < 0) {
            fuel = 0;
        }
    }

    public void refuel(double refuel) {
        fuel += refuel;
        if (fuel > maxFuel) {
            fuel = maxFuel;
        }
    }

}
