Title: Dungeon Escape - A Text-Based Adventure Game Introduction
Dungeon Escape is a simple text-based adventure game where the player takes on the role of a hero who is trapped in a dungeon and must fight their way out. The player will battle monsters, collect items, and ultimately face the boss monster in order to win the game.


 

Getting Started:
To run the program, simply run the Game.java file. The game will run in the console, providing text-based prompts to guide the player through the game.
OOD Writeup 1
  Game Mechanics: Hero
The hero has a name (preset), strength, and health. The hero can attack monsters and use items such as weapons and potions. The hero can also enchant items to increase their strength. The player can only carry one weapon at a time but can carry an unlimited amount of potions for healing.
Story
The hero is stuck in a dungeon and must fight their way through six locations: the entrance, the chamber, the room, the hallway, the stairs, and the boss room. The hero starts at the entrance and can only move forward. The hero can only progress to the next location after defeating all monsters in the current location. Items can be picked up in each location, and the hero cannot explore an area if there are too many monsters nearby.
Monsters
There are three different monster types: Goblin, Ghost, and Zombie. Each monster has custom health and damage values. When a monster is defeated, it drops items such as weapons or potions. The hero can choose to pick up the item or leave it behind.
Design Patterns
We have used the following design patterns in the implementation of Dungeon Escape:
1. Decorator Pattern: The decorator pattern is used to add enchantments to items. ItemDecorator is implemented to wrap around the base Item class allowing for the addition of enchantments to any item without modifying the base class.
2. State Pattern: The state pattern is used to manage different game states, such as exploration and combat. This pattern allows the game to easily transition between states and handle user input accordingly, making it more maintainable and easier to extend with new states in the future.
3. Factory Pattern: I used the factory pattern for creating monsters and items. The MonsterFactory and ItemFactory classes are responsible for creating objects of their respective types, allowing for easy extension of the game with new monster types and items in the future.
OOD Writeup 2

  UML Diagram:
 About the UML Diagram
The UML diagram shows the classes and relationships used in the implementation of Dungeon Escape, a simple text-based adventure game. The diagram includes classes for the hero, monsters, and items, as well as classes for managing game states and implementing design patterns such as the decorator, state, and factory patterns. The diagram also includes classes for creating locations and managing player inventory. The diagram shows how the various parts of the game, including the hero, monsters, items, and game states, are linked together through classes that manage inventory, create locations, and implement design patterns such as the decorator, state, and factory patterns.
Here is a quick summary of each individual class:
1. AbilityDecorator: A decorator class for abilities with methods to get strength, description, name, and convert to string.
2. CombatState: Inherits from GameState, represents a combat state in the game with methods for entering, handling input, exiting, and advancing the state.
3. ExplorationState: Inherits from GameState, represents an exploration state in the game with methods for entering, handling input, exiting, and advancing the state.
4. Game: The main class representing the game with a main method.
5. GameContext: A class managing game states and their transitions.
OOD Writeup 3

6. GameState: An interface for game states with methods for entering, handling input, exiting, and advancing the state.
7. MonsterObject: An interface for monsters with methods for getting health, name, item, description, checking if the monster is dead, taking damage, getting damage, and cloning.
8. Dragon, Ghost, Goblin, and Zombie: Classes inheriting from MonsterObject, representing different types of monsters.
9. ItemObject: An interface for items with methods for getting description, name, strength, type, converting to string, and cloning.
10. Item, ItemDecorator, StrengthDecorator: Classes for managing items and their properties.
11. Player: A class representing the player with methods for managing inventory, health, weapon, and printing inventory.
12. LocationObject: An abstract class for locations with methods for managing monsters, items, advancing, and exploring.
13. Factories: Classes for creating instances of MonsterObject, ItemObject, and LocationObject.
