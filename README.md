# CSC1109 Object Oriented Programming Project

**CLI SIMS GAME**

# Overview

A turn-based life simulation game where players control a Sim and manage their everyday life by managing their needs, skills, careers and relationships.
> Player choices directly affect available activities and triggered events of the Sim.

**Key Features**
- **Needs system** — six needs (Hunger, Energy, Hygiene, Bladder, Fun, Social) decay over time and must be managed
- **Skills** — each need has a linked skill that levels up through use, making activities more effective over time
- **Careers** — Sims earn a salary and career XP by working; salary and bonuses increase as they level up
- **Homes & upgrades** — each Sim owns a home with rooms and purchasable upgrades that unlock new activities
- **Relationships** — Sims build friendship levels with other Sims through social interactions

**How the Game Loop Works**

Each tick of the simulation, the game:
1. Decays all Sim needs by their individual decay rates, both active and inactive Sim
2. Checks if any need has fallen below the critical threshold (30)
3. If a need is critical and the Sim is free, they automatically perform a matching activity at home (for inactive Sim)
4. If the player is in control, they are prompted to choose an action for their Sim (for currently active Sim)
5. Activities update the relevant need, earn skill XP, and advance world time by the activity's duration

---

# Getting Started

**Requirements:** Java 17+, IntelliJ IDEA or VS Code with the Java extension pack.

1. Extract the zip
2. Open the root folder in your IDE
3. Run `sims/gameEngine/Main.java`

Output is printed to the console — you will see each Sim's activities, bank balance updates, and need changes as the simulation ticks forward.

---

# Project Structure

```
src/
└── sims/
    ├── actions/       # Activity, SkillManager, ProgressionInterface
    ├── career/        # Career
    ├── entity/        # Sim, Relationship
    ├── needs/         # Need
    ├── world/         # Loc, Location, Home, HomeLocation, HomeUpgrade, OutsideLocation
    └── gameEngine/    # Main, GameState, SimFactory
    └── tests/         # Junit 5 Tests
    
```

---

# Class Breakdown

| Package | Class | Description |
| --- | --- | --- |
| **Actions** | `Activity` | An action a Sim performs at a location; affects a specific need scaled to skill level, or pays out salary if work-type |
| **Actions** | `SkillManager` | Tracks skill level per need category; gains 25 XP per use, levels up at 100 XP |
| **Actions** | `ProgressionInterface` | Shared contract for anything that levels up via XP (`getLevel()`, `earnXP()`) |
| **Career** | `Career` | Tracks job sector, salary, level, and XP; salary increases on level-up; provides a bonus based on level |
| **Entity** | `Sim` | Central character; holds needs, skills, career, home, relationships, bank balance, and location |
| **Entity** | `Relationship` | Tracks friendship level and XP between two Sims; levels up at 100 XP |
| **Needs** | `Need` | Six needs (Hunger, Energy, Hygiene, Bladder, Fun, Social) each with their own decay rate; Sims auto-act when a need drops below threshold 30 |
| **Game Engine** | `Main` | Entry point; initialises `GameState` and runs the update loop |
| **Game Engine** | `GameState` | Drives the game loop, ticks time forward, and triggers need decay and Sim behaviour each update |
| **Game Engine** | `SimFactory` | Factory class that builds default Sims, homes, careers, skills, and needs for a new game |
| **World** | `Location` | Interface defining the contract for any place a Sim can occupy (`moveTo`, `removeSim`, `getActivity`, etc.) |
| **World** | `Loc` | Abstract base class for all locations; holds a name, activity list, and list of Sims present |
| **World** | `OutsideLocation` | An outdoor location with an optional requirement condition |
| **World** | `Home` | A Sim's residence; contains multiple `HomeLocation` rooms and manages which Sims are present |
| **World** | `HomeLocation` | A room within a home (e.g. Kitchen, Bedroom); holds activities and purchasable upgrades |
| **World** | `HomeUpgrade` | A purchasable item that unlocks an additional activity in a room (e.g. Oven → Pizza, Sofa → Nap) |

For the JUnit tests, 12 test files are created in accordance to the key functions contribute to the gameplay. The test cases include checking for the correct output, retrieval of data, updating of values as well as the creation of different class objects.

---

## Contributors

| Name | SIT ID | UoG ID |
| --- | --- | --- |
| Dave | 2502730 | 3178249T |
| Darius | 2500787 | 3178195K |
| Timothy | 2500815 | 3178196S |
| Rance | 2501107 | 3178211S |
| Thou Yong | 2500027 | 3178145L |
| Reggie | 2501820 | 3178233S |
| Putra Eliyaz | 2500133 | 3178148E |
