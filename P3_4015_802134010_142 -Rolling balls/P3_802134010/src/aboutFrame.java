import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * creates a new frame for about menu
 * @author geraldo
 *
 */

public class aboutFrame extends JFrame  {

	JFrame frame;
	/**
	 * constructor for frame
	 */
	public aboutFrame(){
		frame = new JFrame("ABOUT");

		JLabel label = new JLabel("This game was created for a ICOM4075 Final Project.");
	    label.setFont(new Font("Serif", Font.PLAIN, 16));
		
		frame.add(label);
		frame.setLayout(new FlowLayout());
        frame.setResizable(false);
        frame.setSize(500, 500);
        frame.setBackground(Color.WHITE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
	}
}
