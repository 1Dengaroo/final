public interface MonsterObject {
    int getHealth();
    String getName();
    ItemObject getItem();
    String getDescription();
    boolean isDead();
    void takeDamage(int damage);
    int getDamage();
    MonsterObject clone();
}

