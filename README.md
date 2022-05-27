# Chess Knights Game using JavaFX

This project represents a game made in JavaFX. The game was originally made in GitHub-Classroom,
as a project for Software Engineering and Technologies subject. The skeleton of the project was used from https://github.com/jeszy75/javafx-sliding-puzzle-game2.

The game is played with 3 black knight and 3 white knight chess pieces.
The Knight pieces move according to the rules of chess.
A piece is not allowed to be moved to a square that is under attack by any piece of the opposite color.
Only the white Knight can move first. Also, the knights can only move turn-wise after making a valid move.

When the game starts, the 1st Scene pops-up and the player must enter their name, it is not allowed to start then game, if the player field is empty.
When the player has successfully entered their name, the 2nd scene is initialized, which contains the actual game.

Initially, the 3 black knights are placed in the top row, while the 3 white knights are placed in the bottom row.
The goal of the game is to swap the pieces on the board, i.e., to get the white knights in the top row, and to get the black knights in the bottom row, respectively.
There is a moves counter, which counts how many moves the player has made during the game.


