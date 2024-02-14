public class ItemDecorator implements ItemObject {
    
    private ItemObject decoratedItem;
    
    public ItemDecorator(ItemObject decoratedItem) {
        this.decoratedItem = decoratedItem;
    }

    @Override
    public String getDescription() {
        return decoratedItem.getDescription();
    }

    @Override
    public String getName() {
        return decoratedItem.getName();
    }

    @Override
    public int getStrength() {
        return decoratedItem.getStrength();
    }

    @Override
    public String getType() {
        return decoratedItem.getType();
    }

    @Override
    public String toString() {
        return decoratedItem.toString();
    }

    @Override
    public ItemObject clone() {
        return decoratedItem.clone();
    }
}

