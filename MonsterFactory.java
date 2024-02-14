public class MonsterFactory extends MonsterObjectFactory {
    public MonsterObject createMonster(String type, int health, ItemObject item) {
        switch (type.toLowerCase()) {
            case "goblin":
                return new Goblin(health, item);
            case "zombie":
                return new Zombie(health, item);
            case "ghost":
                return new Ghost(health, item);
            case "dragon":
                return new Dragon(health, item);
            default:
                return null;
        }
    }
}
