import java.util.*;

public abstract class LocationObjectFactory {
    public abstract LocationObject createLocation(String name, String description, List<MonsterObject> monsters, List<ItemObject> items, LocationObject nextLocation);
}

