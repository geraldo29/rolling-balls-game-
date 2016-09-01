import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Creates a new frame for the rules
 * @author geraldo
 *
 */

public class rulesFrame extends JFrame  {

	JFrame frame;
	
	/**
	 * constructs the new frame
	 */
	public rulesFrame(){
		frame = new JFrame("Rules of the Game");

		JLabel label = new JLabel("When a game starts, the system allows the user to select the number of balls");
		JLabel label1 = new JLabel("that each player will have available. That number can be selected as a");
		JLabel label2 = new JLabel("number in range from 1 to 10. The game panel will appear and Player 1 ");
		JLabel label3 = new JLabel("will be of color green and Player 2 will be of color blue. They are placed");
		JLabel label4 = new JLabel("in random places across the panel. There will also be happyfaces (yellow)");
		JLabel label5 = new JLabel("fixed obstacles (black) and red mines. The initial score is 0 and distance is");
		JLabel label6 = new JLabel("1500. The objective is to destroy all the oppenent balls and remain alive at");
		JLabel label7 = new JLabel("the end of the game.  If both player happen to lose all their balls at the");
		JLabel label8 = new JLabel("same moment while the game is played, the one having a greater distance left");
		JLabel label9 = new JLabel("wins. In that case, if both players end with the equal distance left, then the");
		JLabel label10 = new JLabel("game is declared a tie. A game also ends when one of the players consumes all");
		JLabel label11 = new JLabel("of the players consumes all his/her accumulated distance while the other still");
		JLabel label12 = new JLabel("has balls available. In that case, the player still alive adds, to his/her");
		JLabel label13 = new JLabel("accumulated distance left, an amount equal to the accumulated distance left");
		JLabel label14 = new JLabel("left to the player that vanished. At the end of a game, the score that each");
		JLabel label15 = new JLabel("player gets is the corresponding accumulated distance left. Players will alternate");
		JLabel label16 = new JLabel("playing. The will alternate playing. The first player to play will be Player 1.");
		JLabel label17 = new JLabel(" At any moment, the current player’s button to shoot will be surrounded by a black");
		JLabel label18 = new JLabel("border. At his/her turn, the player will select a ball to roll. This is done by a");
		JLabel label19 = new JLabel("mouse click on the selected ball. At this moment, mouse clicks will have effect only");
		JLabel label20 = new JLabel("on balls belonging to the current player. Then the selected ball will be surrounded");
		JLabel label21 = new JLabel(" by a black ring along its circumference. At that moment, the system will show a small");
		JLabel label22 = new JLabel("window with two drop-down lists, one having label 'Distance' and the other with label");
		JLabel label23 = new JLabel("'Distance'. If the user clicks the one labeled 'Direction', then the system will");
		JLabel label24 = new JLabel("allow the user to pick a value from a list of values in the range 0..359. The other");
		JLabel label25 = new JLabel("will allow to select an integer value in the range  [1, m), where m is the total");
		JLabel label26 = new JLabel("remaining distance for the player. After the selection process is completed, ");
		JLabel label27 = new JLabel("the program will allow the player to shoot. For this, the player will click on the");
		JLabel label28 = new JLabel("corresponding button, which should be the only shooting button active at the moment.");
		JLabel label29 = new JLabel("After this, the selected ball will then start rolling in the selected direction");
		JLabel label30 = new JLabel("The rolling will continue until the selected distance (in an accumulated fashion, as");
		JLabel label31 = new JLabel("will be discussed later), is exhausted. As a ball rolls, different things happen");
		JLabel label32 = new JLabel(" when it collides with other balls, with obstacles, with mines, with happy faces");
		JLabel label33 = new JLabel("or with the boundaries of the game area.");




		
		
		
		
		
		frame.add(label);
		frame.add(label1);
		frame.add(label2);
		frame.add(label3);
		frame.add(label4);
		frame.add(label5);
		frame.add(label6);
		frame.add(label7);
		frame.add(label8);
		frame.add(label9);
		frame.add(label10);
		frame.add(label11);
		frame.add(label12);
		frame.add(label13);
		frame.add(label14);
		frame.add(label15);
		frame.add(label16);
		frame.add(label17);
		frame.add(label18);
		frame.add(label19);
		frame.add(label20);
		frame.add(label21);
		frame.add(label22);
		frame.add(label23);
		frame.add(label24);
		frame.add(label25);
		frame.add(label26);
		frame.add(label27);
		frame.add(label28);
		frame.add(label29);
		frame.add(label30);
		frame.add(label31);
		frame.add(label32);
		frame.add(label33);
	
		frame.setLayout(new FlowLayout());
        frame.setResizable(false);
        frame.setSize(1000, 400);
        frame.setBackground(Color.WHITE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
	}
}