public class Dragon implements MonsterObject {
    private String name;
    private int health;
    private String description;
    private ItemObject item;

    public Dragon(int health, ItemObject item) {
        this.name = "Dragon";
        this.description = "A large, fire-breathing creature that is very dangerous. Don't get too close!";
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
        if (health < 0) {
            health = 0;
        }
    }

    public int getDamage() {
        return this.item.getStrength();
    }


    @Override
    public String toString() {
        return this.name + "(" + this.health + ") holding a " + this.item.toString() + "" ;
    }

    @Override
    public MonsterObject clone() {
        return new Dragon(this.health, this.item);
    }
}