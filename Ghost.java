public class Ghost implements MonsterObject {
    private int health;
    private String name;
    private ItemObject item;
    private String description;

    public Ghost(int health, ItemObject item) {
        this.health = health;
        this.name = "Ghost";
        this.item = item;
        this.description = "A spooky, translucent creature that is hard to hit. Don't let it 'touch' you!";
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
        return this.name + "(" + this.health + ") holding a " + this.item.toString() + "" ;
    }

    @Override
    public MonsterObject clone() {
        return new Ghost(this.health, this.item);
    }
}

