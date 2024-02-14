import java.util.Scanner;

public class CombatState implements GameState {
    private MonsterObject monster;
    private LocationObject location;
    private Scanner scanner;

    public CombatState(MonsterObject monster, LocationObject location, Scanner scanner) {
        this.monster = monster;
        this.location = location;
        this.scanner = scanner;
    }

    public void aa() {
        System.out.println("Available actions: attack, heal, flee, quit");
    }

    public void monsterAttack() {
        System.out.println("The monster attacks you!");
        Player.takeDamage(this.monster.getDamage());
        System.out.println("You have " + Player.getHealth() + " health left.");
        if (Player.isDead()) {
            System.out.println("You died!");
            System.exit(0);
        }
        System.out.println("Your turn!");
        this.aa();
    }

    @Override
    public void enter(GameContext context) {
        System.out.println("Entering combat mode...");
        System.out.println("You are now fighting " + monster.getName() + ". " + monster.getDescription());
        this.aa();
    }

    @Override
    public void handleInput(GameContext context, String input) {
        if (input.equalsIgnoreCase("attack")) {
            System.out.println("You attack the monster with " + Player.getWeapon());
            monster.takeDamage(Player.getDamage());
            System.out.println("The monster has " + monster.getHealth() + " health left.");
            if (monster.isDead()) {
                System.out.println("You killed the " + monster + "!");
                
                ItemObject item = monster.getItem();
                System.out.println("The " + monster + " dropped a " + item + "!");

                if (item.getType() == "potion") { 
                    Player.addItem(item);
                    System.out.println("You picked up the " + item + "!"); 
                } 
                else {
                    System.out.println("Do you want to pick up the " + item + "? (y/n)");
                    String answer = scanner.nextLine();
                    if (answer.equalsIgnoreCase("y")) {
                        Player.setWeapon(item);
                        System.out.println("You picked up the " + item + "!");
                    } 
                    else {
                        System.out.println("You left the " + item + " behind.");
                    }
                }
                context.changeState(new ExplorationState(location, scanner));

            } 
            else { this.monsterAttack(); }

        } else if (input.equalsIgnoreCase("flee")) {
            System.out.println("You flee from the monster!");
            context.changeState(new ExplorationState(location, scanner));
        } else if (input.equalsIgnoreCase("quit")) {
            System.out.println("Quitting game.");
            System.exit(0);
        } else if (input.equalsIgnoreCase("heal")) {
            if (Player.getInventory().size() == 0) {
                System.out.println("You have no potions left!");
            } else {
                ItemObject potion = Player.popItem();
                System.out.println("You drink a potion and heal " + potion.getStrength() + " health.");
                Player.heal(potion.getStrength());
                System.out.println("You have " + Player.getHealth() + " health left.");
                this.monsterAttack();
            }
        }
    }

    @Override
    public void exit(GameContext context) {}

    @Override
    public void advance(GameContext context) {}
}