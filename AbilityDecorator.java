public class AbilityDecorator extends ItemDecorator {
    
    private String name;
    private int strength;


    public AbilityDecorator(ItemObject decoratedItem, String name, int strength) {
        super(decoratedItem);
        this.name = name;
        this.strength = strength;
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }

    @Override
    public String getName() {
        return name + " " + super.getName();
    }

    public int getStrength() {
        return super.getStrength() + this.strength;
    }

    @Override
    public String toString() {
        return super.toString() + ", with ability " + name + "";
    }
}