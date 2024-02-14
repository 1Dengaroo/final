import java.util.*;

public class Player {
    private static String name;
    private static List<ItemObject> inventory = new ArrayList<ItemObject>(); // only potions
    private static int health;
    private static ItemObject weapon;

    public static String getName() {
        return name;
    }

    public static void setName(String n) {
        name = n;
    }

    public static List<ItemObject> getInventory() {
        return inventory;
    }

    public static ItemObject popItem() {
        return inventory.remove(0);
    }

    public static int getHealth() {
        return health;
    }

    public static void addItem(ItemObject item) {
        inventory.add(item);
    }

    public static void removeItem(ItemObject item) {
        inventory.remove(item);
    }

    public static void setHealth(int h) {
        health = h;
    }

    public static void heal(int amount) {
        health += amount;
        if (health > 100) {
            health = 100;
        }
    }

    public static void takeDamage(int damage) {
        health -= damage;
    }

    public static boolean isDead() {
        return health <= 0;
    }

    public static int getDamage() {
        return weapon.getStrength();
    }

    public static void setWeapon(ItemObject item) {
        weapon = item;
    }

    public static ItemObject getWeapon() {
        return weapon;
    }

    public static void printInventory() {
        System.out.println(getName() + "'s " + "Inventory:");
        System.out.println("Weapon: " + weapon);
        System.out.println("Potions:");
        for (ItemObject item : inventory) {
            System.out.println(item);
        }
    }
}