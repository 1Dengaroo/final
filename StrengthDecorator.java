public class StrengthDecorator extends ItemDecorator {
    
    private int strength;

    public StrengthDecorator(ItemObject decoratedItem, int strength) {
        super(decoratedItem);
        this.strength = strength;
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public int getStrength() {
        return super.getStrength() + strength;
    }

    @Override
    public String toString() {
        return super.toString() + ", Enchanted with strength " + strength + "";
    }
}


