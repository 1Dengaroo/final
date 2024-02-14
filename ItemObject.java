public interface ItemObject {
    String getDescription();
    String getName();
    int getStrength();
    String getType();
    ItemObject clone();
}
