
// about the game
// author: Andy Deng
/*
* The game is a simple text-based game where the player is a hero who has to
* fight monsters and collect items. The hero has a name, strength, and
* health. The hero can attack monsters and use items. The hero can also
* enchant items to increase his strength. The player can only carry 1 weapon but
* an unlimited amount of potions (heals). 
*/

/*
* Story: the hero is stuck in a dungeon and has to fight his way out. Once he 
* gets out, he has to fight the boss monster. Once he defeats the boss monster,
* he wins the game. There are 6 locations in the game: the entrance, the chamber, 
* the room, the hallway, the stairs, and the boss room. The hero starts at the
* entrance and has to fight his way to the boss room. The hero can only move
* forward. The hero can only move to the next location if he defeats all monsters
* in the current location. The hero can pick up items in each location.

* There are three different monster types: Goblin, Ghost, Zombie. The monsters have custom
* health and damage. The monsters drop items when they die. The items are either
* weapons or potions. The hero has the choice to pick up the item or leave it. 

* to run the program, simply run the Game.java file.
*/



import java.util.*;

public class Game {

    // wait time to add dramatic effect
    public static void w() throws InterruptedException {
        Thread.sleep(4000);
    }

    public static void main(String[] args) throws InterruptedException {

        // create items
        ItemObjectFactory itemFactory = new ItemFactory();
        ItemObject swordOne = itemFactory.createObject("swordOne");
        ItemObject swordTwo = itemFactory.createObject("swordTwo");
        ItemObject swordThree = itemFactory.createObject("swordThree");
        ItemObject potionOne = itemFactory.createObject("potionOne");
        ItemObject potionTwo = itemFactory.createObject("potionTwo");
        ItemObject potionThree = itemFactory.createObject("potionThree");
        
        ItemObject enchantedSword = new AbilityDecorator(new StrengthDecorator(itemFactory.createObject("swordThree"), 10), "ice", 3);
        ItemObject goodSword = new AbilityDecorator(new StrengthDecorator(itemFactory.createObject("swordTwo"), 5), "fire", 2);

        List<ItemObject> potionList1 = new ArrayList<ItemObject>();
        potionList1.add(potionOne.clone());
        potionList1.add(potionTwo.clone());

        List<ItemObject> potionList2 = new ArrayList<ItemObject>();
        potionList2.add(potionTwo.clone());
        potionList2.add(potionThree.clone());

        List<ItemObject> potionList3 = new ArrayList<ItemObject>();
        potionList3.add(potionThree.clone());
        potionList3.add(potionOne.clone());

        List<ItemObject> potionList0 = new ArrayList<ItemObject>();
        potionList0.add(potionOne.clone());
        potionList0.add(potionOne.clone());
        potionList0.add(potionOne.clone());



        // create monsters
        MonsterObjectFactory monsterFactory = new MonsterFactory();
        MonsterObject goblinOne = monsterFactory.createMonster("goblin", 15, swordOne);
        MonsterObject zombieOne = monsterFactory.createMonster("zombie", 15, potionTwo);
        MonsterObject ghostOne = monsterFactory.createMonster("ghost", 15, swordOne);

        MonsterObject goblinTwo = monsterFactory.createMonster("goblin", 50, swordTwo);
        MonsterObject zombieTwo = monsterFactory.createMonster("zombie", 50, potionThree);
        MonsterObject ghostTwo = monsterFactory.createMonster("ghost", 50, swordTwo);

        MonsterObject goblinThree = monsterFactory.createMonster("goblin", 80, swordThree);
        MonsterObject zombieThree = monsterFactory.createMonster("zombie", 80, potionThree);
        MonsterObject ghostThree = monsterFactory.createMonster("ghost", 80, goodSword);


        MonsterObject dragon = monsterFactory.createMonster("dragon", 120, enchantedSword);

        List<MonsterObject> monsterList1 = new ArrayList<MonsterObject>();
        monsterList1.add(goblinOne.clone());

        List<MonsterObject> monsterList2 = new ArrayList<MonsterObject>();
        monsterList2.add(goblinTwo.clone());
        monsterList2.add(zombieOne.clone());

        List<MonsterObject> monsterList3 = new ArrayList<MonsterObject>();
        monsterList3.add(ghostTwo.clone());

        List<MonsterObject> monsterList4 = new ArrayList<MonsterObject>();
        monsterList4.add(goblinOne.clone());
        monsterList4.add(zombieOne.clone());
        monsterList4.add(ghostTwo.clone());

        List<MonsterObject> monsterList5 = new ArrayList<MonsterObject>();
        monsterList5.add(goblinTwo.clone());
        monsterList5.add(zombieTwo.clone());
        monsterList5.add(ghostThree.clone());

        List<MonsterObject> monsterList6 = new ArrayList<MonsterObject>();
        monsterList6.add(goblinThree.clone());
        monsterList6.add(zombieThree.clone());
        monsterList6.add(ghostThree.clone());

        List<MonsterObject> dragonList = new ArrayList<MonsterObject>();
        dragonList.add(dragon.clone());

        List<MonsterObject> emptyList = new ArrayList<MonsterObject>();



        // create locations
        
        LocationObjectFactory locationFactory = new LocationFactory();
        
        LocationObject bossRoom = locationFactory.createLocation("boss room", "You are in the boss room. There is a dragon in the room.", dragonList, potionList1, null);

        LocationObject stairwell = locationFactory.createLocation("stairwell", "You are in a stairwell. There you see an ominous room at the top. However, there are many strong-looking monsters in the area.", monsterList5, potionList3, bossRoom);

        LocationObject hallway = locationFactory.createLocation("hallway", "You are in a hallway. There is a room to the north. There are no monsters. Maybe do some exploring!", emptyList, potionList0, stairwell);


        LocationObject room = locationFactory.createLocation("room", "You are in a room. There is a chamber to the north. There are enemies in the room.", monsterList4, potionList3, hallway);

        LocationObject chamber = locationFactory.createLocation("chamber", "You are in a chamber. There is a room to the north. There is a monsters with you in the chamber.", monsterList3, potionList3, room);
        

        LocationObject entrance = locationFactory.createLocation("entrance", "You are at the entrance of the dungeon. There is a hallway to the north. But a goblin is blocking the way.", monsterList1, potionList0, chamber);

        // create player
        Player.setName("Naomi Boloton");
        Player.setHealth(100);
        Player.setWeapon(swordOne.clone());
        Player.addItem(potionOne.clone());
        w();

        
        // print introduction
        System.out.println("Once upon a time, in a land far away, a brave hero named Naomi Boloton emerged.");
        w();
        System.out.println("One day, Naomi was captured by an evil dragon and thrown into a treacherous dungeon.");
        w();
        System.out.println("To escape and defeat the dragon, Naomi must battle various monsters and overcome numerous challenges.");
        w();
        System.out.println("Join Naomi in their quest for freedom and glory!");
        w();
        System.out.println();
        w();
        System.out.println("You find a rusted sword and a potion in your cell. You pick them up.");
        w();
        System.out.println();



        // initialize game states & scanner
        Scanner scanner = new Scanner(System.in);
        GameState initialState = new ExplorationState(entrance, scanner);
        GameContext gameContext = new GameContext(initialState);

        // game loop
        while (true) {
            System.out.print("Enter a command: ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("quit") || input.equalsIgnoreCase("q")) {
                break;
            }
            System.out.println();
            gameContext.handleInput(input);
            System.out.println();
        }
        scanner.close();
    }
}