# Project Description
A 2D action game where players control a main character navigating through a maze-like environment, collecting rewards, and avoiding enemies. The goal is to guide the character from the start point to the exit while collecting rewards and avoiding penalties or getting caught by enemies. 

This repository is a fork from the original developing repository. The commitment history and contribution details can be found in the original repository ([original repo](https://github.sfu.ca/saba/CMPT276F23_group23)).

# Key Features:

## Main Character Navigation:

1.Players control the main character using keyboard inputs, moving one cell per tick in any direction (up, down, left, right).

2.The character starts at a designated "start cell" and moves through the game board avoiding obstacles such as walls and barriers.

3.The goal is to reach the “exit cell” after collecting all regular rewards placed on the board.

## Enemies and AI:
1.The game includes two types of enemies: moving enemies and stationary penalties.

2.Moving enemies pursue the main character, attempting to intercept or block its movement.

3.Penalty enemies are stationary; if the character moves onto their cell, they reduce the player's score.

4.The game ends if the player is caught by a moving enemy or if the score drops below zero due to penalties.

## Rewards and Score System:

1.Players must collect regular rewards placed across the board to increase their score.

2.Bonus rewards may appear randomly during gameplay, offering higher scores but are optional for winning the game.

3.The current score and time elapsed are displayed on the screen throughout the game.

## Board Layout and Barriers:

1.The game board is a 2D grid enclosed by walls, with additional maze-like barriers placed throughout the map.

2.These walls and barriers restrict both the player and enemies from moving into certain cells, adding complexity to navigation and enemy evasion.

## Game Over and Winning Conditions:

1.The player wins by reaching the exit after collecting all regular rewards without being caught by enemies.

2.The game is lost if the player’s character is caught by a moving enemy or if the score falls below zero due to penalties.

# Development Process:

## Design & Implementation: 
The project was implemented in Java, utilizing object-oriented programming principles to structure the game logic, entities (such as the player, enemies, and rewards), and the game board. The user interface was built using JavaFX, providing real-time feedback on player progress and score.

## Testing & Debugging: 
I led the testing phase of the project, focusing on unit and integration tests. JUnit was used to write test cases that ensured the correctness of the game’s core features, such as player movement, enemy AI, reward collection, and game-over conditions. These tests helped ensure the game ran smoothly without bugs or unexpected behavior. The code was continuously refactored and improved based on findings from the testing phase.

## Automation & Coverage: 
The project was built and tested using Maven for easy compilation and test execution. Comprehensive test coverage reports were generated to ensure high-quality and reliable code. The testing process revealed and fixed various bugs, enhancing both the stability and playability of the game.

# Technologies Used:

- Languages: Java
- Frameworks: JUnit (for testing), Maven (for build automation)
- UI Library: JavaFX
- Version Control: Git


# Build
        
```bash
git clone https://github.sfu.ca/saba/CMPT276F23_group23.git  
``` 
        
Navigate Project Directory: ```CMPT276F23_GROUP23```. And build the Project using Maven: 
        
```bash
mvn clean install 
``` 
        
Notes: When install the app, it must pass all the test cases including a pop-up test case. Please click "Restart the Game" to pass. Otherwise, the jar file cannot be generated as expected. 

# Run
After building the project, you can run the game with the following command:
```bash
java -jar target/CMPT276F23_group23-1.0.jar
```

# Test
Run the Automated tests use Maven: 
```bash
mvn test
```

# Doc File 
Generate the doc by the comments: 
```bash
mvn javadoc:javadoc
```

After running the code, you can open the index page in the browser as: ```target/site/apidocs/index.html```
