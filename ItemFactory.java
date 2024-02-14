public class ItemFactory extends ItemObjectFactory {
    @Override
    public ItemObject createObject(String type) {
        switch (type) {
            case "swordOne":
                return new Item("A dull sword", "sword", 10, "weapon");
            case "swordTwo":
                return new Item("A sharp sword", "sword", 15, "weapon");
            case "swordThree":
                return new Item("A legendary sword", "sword", 20, "weapon");
            case "potionOne":
                return new Item("A weak potion", "potion", 15, "potion");
            case "potionTwo":
                return new Item("A strong potion", "potion", 40, "potion");
            case "potionThree":
                return new Item("A legendary potion", "potion", 100, "potion");
            case "swordRiddle":
                return new Item("A glowing sword", "Pickle Juice", 20, "weapon");
            default:
                return null;
        }
    }
}



