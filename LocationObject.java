import java.util.List;

public interface LocationObject {
    String getName();
    String getDescription();
    List<MonsterObject> getMonsters();
    List<MonsterObject> getAliveMonsters();
    List<ItemObject> getItems();
    void clearItems();
    void removeItem(ItemObject item);
    void printMonsters();
    void printItems();
    boolean canAdvance();
    int getAliveMonsterCount();
    MonsterObject getNextMonster();
    LocationObject getNextLocation();
    void explore();
}