import java.util.*;

public class LocationFactory extends LocationObjectFactory {
    @Override
    public LocationObject createLocation(String name, String description, List<MonsterObject> monsters, List<ItemObject> items, LocationObject nextLocation) {
        return new Location(name, description, monsters, items, nextLocation);
    }
}