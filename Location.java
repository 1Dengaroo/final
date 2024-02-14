import java.util.*;

public class Location implements LocationObject {
    private String description;
    private String name;
    private List<MonsterObject> monsters;
    private List<ItemObject> items;
    private LocationObject nextLocation;

    public Location(String name, String description, List<MonsterObject> monsters, List<ItemObject> items, LocationObject nextLocation) {
        this.name = name;
        this.description = description;
        this.monsters = monsters;
        this.items = items;
        this.nextLocation = nextLocation;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<MonsterObject> getMonsters() {
        return monsters;
    }

    public List<MonsterObject> getAliveMonsters() {
        List<MonsterObject> aliveMonsters = new ArrayList<MonsterObject>();
        for (MonsterObject monster : monsters) {
            if (!monster.isDead()) {
                aliveMonsters.add(monster);
            }
        }
        return aliveMonsters;
    }

    public List<ItemObject> getItems() {
        return items;
    }

    public void removeItem(ItemObject item) {
        items.remove(item);
    }

    public void clearItems() {
        items.clear();
    }

    public boolean canAdvance() {
        for (MonsterObject monster : monsters) {
            if (!monster.isDead()) {
                return false;
            }
        }
        return true;
    }

    public void printMonsters() {
        for (MonsterObject monster : monsters) {
            System.out.println(monster.toString());
        }
    }

    public void printItems() {
        for (ItemObject item : items) {
            System.out.println(item.toString());
        }
    }

    public int getAliveMonsterCount() {
        int count = 0;
        for (MonsterObject monster : monsters) {
            if (!monster.isDead()) {
                count++;
            }
        }
        return count;
    }

    public MonsterObject getNextMonster() {
        for (MonsterObject monster : monsters) {
            if (!monster.isDead()) {
                return monster;
            }
        }
        return null;
    }

    public LocationObject getNextLocation() {
        return nextLocation;
    }

    public void explore() {
        if (this.getAliveMonsterCount() > 2) {
            System.out.println("You try to explore, but monsters are blocking every path!");
        } else {
            List<ItemObject> items = this.getItems();
            if (items.size() == 0) {
                System.out.println("You explore the area, but find nothing.");
            } else {
                System.out.println("You explore the area and find the following items:\n" + items);
                for (ItemObject i : items) {
                    Player.addItem(i);
                }
                this.clearItems();
                System.out.println("You picked up the items!");
            }
            
        }
    }
}
