public class Item implements ItemObject {
    private String description;
    private String name;
    private int strength;
    private String type;

    public Item(String description, String name, int strength, String type) {
        this.description = description;
        this.name = name;
        this.strength = strength;
        this.type = type;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getStrength() {
        return strength;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public ItemObject clone() {
        return new Item(description, name, strength, type);
    }
}


