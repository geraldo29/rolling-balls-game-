README
Author : Geraldo Lopez Rosa
ID : 802134010
Email: geraldo.lopez1@upr.edu

My program can be compiled using a Java compiler. 
First you will need to unzip the folder where this is found. 
After you unzip the program, Open your Java Compiler. Here click, new java project and unclick "Use default location". After that, browse for the unzipped folder and click finish. Open all the classes in your compiler. To run it you will need to choose, run as java application.

Project 3: 
After running, a frame will appear. Here you will see a a main menu. (If you don't see the main menu, please just keep running the program until you do.Believe me it will show up.)This main menu will have the Game Title and a menu with different options. If it's your first time playing go to the First Time Player Menu, where you will be able to Register. Put in a username in the space provided using your keyboard and your 4 digit password in the space provided.  
You will see a message saying you registrated. Now, you will need to find another player since it's a two player mode game. Register a new player. Go to the Play new game menu and left click it and you will see another menu. Here Login and player and and then player 2. If you to play if you arent registrated you will be sent to the Register a new player. And if you try to play without logging in, 
you will be sent to login BOTH player. Now after logging in you can logout and select a new Player. The rules of the games are in the Help "how to play" menu. In the Help menu you will see an About. Here it specifies the reason for the project. In the history menu, you will see two options. One to show all games played, and the other to show the highscores of each player. If you hit exit, you will exit the Game. 



Rules of the game:***
When a game starts, the system allows the user to select the number of balls that each player will have available. That number can be selected as a number in range from 1 to 10. Let's assume that w is that number. The system will show then the game panel (See figure below.), with dimensions 700x700, randomly displaying w balls for each player. Balls are painted with the particular color that identifies the player. These colors are green and blue. Those balls are placed in random places across the panel. The system will also place a number of happy faces (painted in yellow), fixed obstacles (black filled circles),  and mines (the red circles with black-colored circumference). The number of each of these three types of objects to be displayed are randomly selected by the system as values in range 5..10. All the objects (balls, happy faces, mines, and obstacles) are represented as circles of equal diameter, which is a constant value of 20.  No two objects displayed will be closer to each other than 1.5 times their diameter. 

Each player will be assigned an initial score of 0, and an initial accumulated distance of 1500. The objective is for a player to be able to destroy all the balls corresponding to the opponent player and to remain alive at the end of the game. If both player happen to lose all their balls at the same moment while the game is played, the one having a greater distance left wins. In that case, if both players end with the equal distance left, then the game is declared a tie. A game also ends when one of the players consumes all his/her accumulated distance while the other still has balls available. In that case, the player still alive adds, to his/her accumulated distance left, an amount equal to the accumulated distance left to the player that vanished. At the end of a game, the score that each player gets is the corresponding accumulated distance left. 

Players will alternate playing. The first player to play will be Player 1. At any moment, the current player’s button to shoot will be surrounded by a black border. At his/her turn, the player will select a ball to roll. This is done by a mouse click on the selected ball. At this moment, mouse clicks will have effect only on balls belonging to the current player. Then the selected ball will be surrounded by a black ring along its circumference. At that moment, the system will show a small window with two drop-down lists, one having label "Direction" and the other  with label "Distance". If the user clicks the one labeled "Direction", then the system will allow the user to pick a value from a list of values in the range 0..359. The other will allow to select an integer value in the range  [1, m), where m is the total remaining distance for the player. 

After the selection process is completed, the program will allow the player to shoot. For this, the player will click on the corresponding button, which should be the only shooting button active at the moment. After this, the selected ball will then start rolling in the selected direction (the degree selected). The rolling will continue until the selected distance (in an accumulated fashion, as will be discussed later), is exhausted. As a ball rolls, different things happen when it collides with other balls, with obstacles, with mines, with happy faces or with the boundaries of the game area. 

***Important...Game is not up to specifications. The collions aren't perfect I don't Understand why they won't just always work haha. To show that The game Over is done properly, in the menu hit Help, About. There I have collocated the GameOver Frame, which will save the current game and take you to the main menu. Thank You.

That is the program, any questions Please contact the author. 

If the mouse clicks don't work please check with me. Or maybe the click is a little bit more up or down. If it doesnt please contact author. 
To generate the javadoc HTML: 
In eclipse: go to Project: Generate Javadoc. It is properly commented after the Javadoc Style. 