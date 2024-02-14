public class Zombie implements MonsterObject {
    private String name;
    private String description;
    private int health;
    private ItemObject item;

    public Zombie(int health, ItemObject item) {
        this.name = "Zombie";
        this.description = "An undead creature that is slow but deadly. Don't get too close!";
        this.item = item;
        this.health = health;
    }

    public String getName() {
        return this.name;
    }

    public int getHealth() {
        return this.health;
    }

    public ItemObject getItem() {
        return this.item;
    }

    public String getDescription() {
        return this.description;
    }

    public boolean isDead() {
        return this.health <= 0;
    }

    public void takeDamage(int damage) {
        this.health -= damage;
    }

    public int getDamage() {
        if (this.item.getType() == "potion") {
            return 15;
        }
        return this.item.getStrength();
    }

    @Override
    public String toString() {
        return this.name + "(" + this.health + ") holding a " + this.item + "" ;
    }

    @Override
    public MonsterObject clone() {
        return new Zombie(this.health, this.item);
    }
}
