import java.awt.BorderLayout;  
import java.awt.Button;
import java.awt.Container;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * creates a new frame to select distance to shoot the ball
 * @author geraldo
 *
 */
public class SelectDistance {
    Game.State state;
    static boolean selectedDistance  = false;
	Button login;
    JTextField selectNumber;
    Insets inset;
    static int index;
    Game game;
    String comboList;
    ArrayList <String> numbers = new ArrayList<String>();
    String title; 
  int number;
    JComboBox<String> combo;
    int sum = 0;
	/**
	 * constructor the frame to select distance 
	 * @param title the title for the frame 
	 * @param Label  the message it will show
	 * @param n the number of distances to choose from
	 */
	public SelectDistance(String title, String Label, int n){
	        
         this.title = title;
         final JFrame frame = new JFrame(title);
         Container content = frame.getContentPane();
         combo = new JComboBox<String>();
         this.number= n;
         
         inset = content.getInsets();

         JPanel userPanel = new JPanel(new BorderLayout());
         JLabel userLabel = new JLabel(Label);
         userLabel.setDisplayedMnemonic(KeyEvent.VK_U);
         
         
         
         
         final JTextField selectNumber = new JTextField();
         userLabel.setLabelFor(selectNumber);
         userPanel.add(userLabel, BorderLayout.WEST);
         userPanel.add(combo, BorderLayout.CENTER);
         
         for (int i = 0;i<number;i++){
        	 numbers.add("" +(i +1)) ;
         }
        
         for (int i=0;i< numbers.size();i++){
        	  comboList = numbers.get(i);
        	  combo.addItem(comboList);
         }
         
         combo.addActionListener(new ActionListener(){
        	 public void actionPerformed(ActionEvent event) {
        		 	
        		 
        		 
             }     
         });

         

         
         
         JButton login=new JButton("OK");
         login.setFont(new Font ("Arial", Font.PLAIN, 40));
         JPanel panel = new JPanel(new BorderLayout());
         panel.add(userPanel, BorderLayout.NORTH);
         content.add(panel, BorderLayout.NORTH);
         content.add(login);
         login.setBounds(inset.left + 10, inset.top + 20, 30, 10);
         
         frame.add(login);
         frame.setSize(250, 150);
         frame.setVisible(true);
         frame.setLocationRelativeTo(null);
         frame.setResizable(false);
         
     
     
 login.addActionListener(new ActionListener() {
	 
	 
	 
    

	public void actionPerformed(ActionEvent event) {
    	 selectedDistance = true;
    	 index =  combo.getSelectedIndex();
       	  frame.dispose();
       	  new SelectAngle("Direction","Angle of", 360);
		
     }     
 });
	
	 
 }
	
	
}