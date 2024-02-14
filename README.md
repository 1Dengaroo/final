# Dungeon Escape - A Text-Based Adventure Game

## Introduction

Dungeon Escape is a simple text-based adventure game where the player embodies a hero trapped in a dungeon. The objective is to battle monsters, collect items, and defeat the boss monster to escape. This engaging game combines strategy, combat, and exploration, providing a unique experience for each player.

## Getting Started

To embark on your adventure, execute the `Game.java` file. The game will unfold in the console with text-based prompts guiding you through various challenges and encounters.

## Game Mechanics

### Hero

- **Name:** The hero's name is preset.
- **Attributes:** Heroes possess strength and health.
- **Actions:** Heroes can attack monsters, use items (weapons and potions), and enchant items to boost their strength.
- **Inventory:** Players can carry one weapon and an unlimited number of potions.

### Story

Your journey spans six distinct locations: the entrance, chamber, room, hallway, stairs, and boss room. Progression requires defeating all monsters in the current location. Items found can be utilized or left behind, and areas cannot be explored if overrun by monsters.

### Monsters

Encounter three monster types: Goblin, Ghost, and Zombie. Each type has unique health and damage attributes. Defeating monsters may yield weapons or potions.

## Design Patterns

### Decorator Pattern

Used to add enchantments to items without altering the base class. The `ItemDecorator` wraps around the base `Item` class, enabling enchantment additions.

### State Pattern

Manages game states such as exploration and combat. This pattern facilitates smooth transitions between states and simplifies user input handling.

### Factory Pattern

Facilitates the creation of monsters and items. `MonsterFactory` and `ItemFactory` create objects of their respective types, simplifying game extensions with new monsters and items.

## UML Diagram Overview

The UML diagram illustrates the class structure and relationships within Dungeon Escape. It includes hero, monster, and item classes, along with classes for game state management and design pattern implementation. Key components:

- **AbilityDecorator:** Enhances abilities with methods for strength, description, and conversion to string.
- **CombatState and ExplorationState:** Inherits from GameState, handling respective game states.
- **Game:** The main class with the game's entry point.
- **GameContext:** Manages game state transitions.
- **MonsterObject and ItemObject:** Interfaces for monsters and items, with specific classes like Dragon, Ghost, Goblin, Zombie, Item, and ItemDecorator implementing these interfaces.
- **Player:** Manages inventory, health, and weapons.
- **LocationObject:** Abstract class for managing location-specific elements.

Factories are utilized for creating monsters, items, and locations, highlighting the application of the decorator, state, and factory patterns in game development.
