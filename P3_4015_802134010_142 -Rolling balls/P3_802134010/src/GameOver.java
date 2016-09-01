import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 * creates a frame when the game is over 
 * @author geraldo
 *
 */

public class GameOver {
	
	
    DateTime date = new DateTime();
    static boolean overGame = false;
    String dateR;

    /**
     * contructs the frame with a button 
     */
	public GameOver(){
	 dateR = DateTime.getDateTime();

	 String title = "GAMEOVER";
     final JFrame frame = new JFrame(title);
     Container content = frame.getContentPane();
   
     

     JPanel userPanel = new JPanel(new BorderLayout());
     JLabel userLabel = new JLabel("Score for Player1:       " + tester.currentPlayer[0] + "            is:            " + DrawShapes.score);
     userLabel.setDisplayedMnemonic(KeyEvent.VK_U);
     
     JButton OK = new JButton();
     
     
     userPanel.add(userLabel, BorderLayout.CENTER);
     

     
     
     OK.addActionListener(new ActionListener(){
    	 public void actionPerformed(ActionEvent event) {
    		 	
    		 
    		 
         }     
     });

     JPanel passPanel = new JPanel(new BorderLayout());
     JLabel passLabel = new JLabel("Score for Player2:       " + tester.currentPlayer[1] + "            is:            " + DrawShapes.score2);
     passLabel.setDisplayedMnemonic(KeyEvent.VK_P);
     passPanel.add(passLabel, BorderLayout.WEST);

     JPanel panel = new JPanel(new BorderLayout());
     panel.add(userPanel, BorderLayout.NORTH);
     panel.add(passPanel, BorderLayout.SOUTH);
     content.add(panel, BorderLayout.NORTH);
     
     JButton ok=new JButton("OK");
     ok.setFont(new Font ("Arial", Font.PLAIN, 40));
     
     
     content.add(ok, BorderLayout.CENTER);
     
     frame.add(ok);
     frame.setSize(400, 250);
     frame.setVisible(true);
     frame.setLocationRelativeTo(null);
     frame.setResizable(false);
	
	
	 ok.addActionListener(new ActionListener(){
    	 public void actionPerformed(ActionEvent event) {
    		 overGame = true;
    		 	frame.dispose();
    		 	
    		 try {
				HistoryFile.writeFile(tester.currentPlayer[0], DrawShapes.score, tester.currentPlayer[1], DrawShapes.score2, dateR);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		 
    		 
    		 
         }     
     });
}
   
}
