public class Ship {
    double durability, speed, fuel, maxFuel, maxDurability, ammo, maxAmmo;
    String name;
    ShipType type;

    public enum ShipType {
        LIGHT, MEDIUM, HEAVY
    }

    public Ship(String name, ShipType type, double durability, double speed, double fuel, double ammo) {
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
        } else {
            System.out.println("Invalid ship type!");
        }
    }

    public void printStats() {
        Game.print("Name: " + name + "\n", 2);
        Game.print("Type: " + type + "\n", 2);
        Game.print("Durability: " + durability + "\n", 2);
        Game.print("Speed: " + speed + "\n", 2);
        Game.print("Fuel: " + fuel + "\n", 2);
        Game.print("Ammo: " + ammo + "\n", 2);
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
