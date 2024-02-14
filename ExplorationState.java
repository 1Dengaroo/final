import java.util.*;

public class ExplorationState implements GameState {
    private LocationObject location;
    private Scanner scanner;
    private boolean riddleSolved = false;

    public ExplorationState(LocationObject location, Scanner scanner) {
        this.location = location;
        this.scanner = scanner;
    }

    // to make it easier to print out the available actions
    public void aa() {
        System.out.println("Available actions: explore, heal, fight, advance, quit");
    }

    public boolean riddle() throws InterruptedException {
        if (riddleSolved) {
            System.out.println("You already solved the riddle!");
            return false;
        }
        System.out.println("You see a rune with a mysterious writing on it.");
        Thread.sleep(2500);
        System.out.println();
        System.out.println("I'm something that's frozen, but not quite ice,");
        Thread.sleep(2500);
        System.out.println("A flavor so strange, you might think twice,");
        Thread.sleep(2500);
        System.out.println("I'm made with a veggie that's brined in a jar,");
        Thread.sleep(2500);
        System.out.println("And when you try me, you might say 'bizarre'.");
        Thread.sleep(2500);
        System.out.println();
        System.out.println("What am I?");
        Thread.sleep(1000);
        System.out.println();
        System.out.print("Answer: ");
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("pickle ice cream") || answer.equalsIgnoreCase(answer = "pickle icecream")) {
            Thread.sleep(2000);
            System.out.println("*click* The rune glows and disappears...");
            Thread.sleep(4000);
            riddleSolved = true;
            return true;
        } else {
            System.out.println("Nothing happens...");
            return false;
        }
    }

    public void heal() {
        if (Player.getInventory().size() == 0) {
            System.out.println("You have no potions left!");
        } else {
            ItemObject potion = Player.popItem();
            System.out.println("You drink a potion and heal " + potion.getStrength() + " health.");
            Player.heal(potion.getStrength());
            System.out.println("You have " + Player.getHealth() + " health left.");
        }
    }

    @Override
    public void enter(GameContext context) {
        System.out.println("Entering exploration mode...");
        System.out.println("You are now at " + location.getName() + ". " + location.getDescription());
        // System.out.println("You see the following monsters:\n" + location.getAliveMonsters());
        this.aa();
    }

    @Override
    public void handleInput(GameContext context, String input) throws InterruptedException {
        if (input.equalsIgnoreCase("explore")) {
            if (location.getName().equalsIgnoreCase("hallway")) {
                if (riddle()) {
                    System.out.println("A door opens, revealing a staircase leading down. You find a glowing sword on the ground:");
                    ItemFactory sfac = new ItemFactory();
                    ItemObject sword = new AbilityDecorator(new StrengthDecorator(sfac.createObject("swordRiddle"), 12), "fire", 3);
                    System.out.println(sword);
                    System.out.println("Do you want to pick up the sword? (y/n)");
                    String answer = scanner.nextLine();
                    if (answer.equalsIgnoreCase("y")) {
                        Player.setWeapon(sword);
                        System.out.println("You picked up the " + sword + "!");
                    } 
                    else {
                        System.out.println("You leave the sword on the ground.");
                    }
                }
            }
            else {
                location.explore();
            }
        this.aa();
        } else if (input.equalsIgnoreCase("fight")) {
            MonsterObject nextFight = location.getNextMonster();
            if (nextFight == null) {
                System.out.println("You try to fight, but there are no monsters left! You can advance to the next location.");
                this.aa();
            } else {
                System.out.println("You fight the following monster:\n" + nextFight);
                context.changeState(new CombatState(nextFight, location, scanner));
            }
        } else if (input.equalsIgnoreCase("quit")) {
            System.out.println("Quitting game.");
            System.exit(0);
        } else if (input.equalsIgnoreCase("advance")) {
            if (location.getAliveMonsterCount() > 0) {
                System.out.println("You try to advance, but monsters are blocking the exit path!");
                System.out.println("Kill all remaining monsters first!");
                this.aa();
            } else {
                this.advance(context);
            }
        } else if (input.equalsIgnoreCase("heal")) {
            this.heal();
            this.aa();
        }
    }

    @Override
    public void exit(GameContext context) {}

    @Override
    public void advance(GameContext context) {
        System.out.println("Advancing to next location.");
        LocationObject next = location.getNextLocation();
        if (next == null) {
            System.out.println("You have escaped the dungeon!");
            System.exit(0);
        }
        context.changeState(new ExplorationState(next, scanner));
    }

}