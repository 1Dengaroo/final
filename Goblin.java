public class Goblin implements MonsterObject {
    private String name;
    private int health;
    private String description;
    private ItemObject item;

    public Goblin(int health, ItemObject item) {
        this.name = "Goblin";
        this.description = "A small, green creature that is quick and deadly. Stay alert!";
        this.item = item;
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public ItemObject getItem() {
        return item;
    }

    public String getDescription() {
        return description;
    }

    public boolean isDead() {
        return health <= 0;
    }

    public void takeDamage(int damage) {
        health -= damage;
    }

    public int getDamage() {
        if (this.item.getType() == "potion") {
            return 15;
        }
        return this.item.getStrength();
    }


    @Override
    public String toString() {
        return this.name + "(" + this.health + ") holding a " + this.item.toString() + "" ;
    }

    @Override
    public MonsterObject clone() {
        return new Goblin(this.health, this.item);
    }
}

