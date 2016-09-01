import java.awt.BorderLayout;  
import java.awt.Button;
import java.awt.Container;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * Controls the Login of the game 
 * @author geraldo
 *
 */
public class Login {
	Button login;
    JTextField userTextField;
    JPasswordField passTextField;
    Insets inset;
    boolean newUser = false;
    String passString;
    static int index;
    tester file;
    boolean empty = false;
    String comboList;
    String indexuser;
    String passList;
    char[] passwordCombo;
    String passwordString;
    String usernameString;
   static String PasswordCopy;
   static String PasswordCopy2;
   static int indexplayer1= -1;
    static int indexplayer2 = -1;

  static boolean player1login = false;
  static boolean player2login =false;
    JComboBox<String> combo;
	
    /**
     * creates a new Login frame so you can play a new game
     */
	public Login(){
	        
         String title = "LOGIN";
         final JFrame frame = new JFrame(title);
         Container content = frame.getContentPane();
        combo = new JComboBox<String>();
       
         
         inset = content.getInsets();

         JPanel userPanel = new JPanel(new BorderLayout());
         JLabel userLabel = new JLabel("Username: ");
         userLabel.setDisplayedMnemonic(KeyEvent.VK_U);
         
         
         
         
         final JTextField userTextField = new JTextField();
         userLabel.setLabelFor(userTextField);
         userPanel.add(userLabel, BorderLayout.WEST);
         userPanel.add(combo, BorderLayout.CENTER);
         try {
			tester.readFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

         for (int i=0;i< tester.jComboBoxUserName.size();i++){
        	  comboList = (tester.jComboBoxUserName.get(i));
        	  combo.addItem(comboList);
         }
         
         combo.addActionListener(new ActionListener(){
        	 public void actionPerformed(ActionEvent event) {
        		 	
        		 
        		 
             }     
         });

         JPanel passPanel = new JPanel(new BorderLayout());
         JLabel passLabel = new JLabel("Password: ");
         passLabel.setDisplayedMnemonic(KeyEvent.VK_P);
         final JPasswordField passTextField = new JPasswordField();
         passLabel.setLabelFor(passTextField);
         passPanel.add(passLabel, BorderLayout.WEST);
         passPanel.add(passTextField, BorderLayout.CENTER);

         JPanel panel = new JPanel(new BorderLayout());
         panel.add(userPanel, BorderLayout.NORTH);
         panel.add(passPanel, BorderLayout.SOUTH);
         content.add(panel, BorderLayout.NORTH);
         
         JButton login=new JButton("LOGIN");
         login.setFont(new Font ("Arial", Font.PLAIN, 40));
         
         content.add(login);
         login.setBounds(inset.left + 10, inset.top + 20, 30, 10);
         
         frame.add(login);
         frame.setSize(250, 150);
         frame.setVisible(true);
         frame.setLocationRelativeTo(null);
         frame.setResizable(false);
         
     
     
 login.addActionListener(new ActionListener() {
	 
	 
	 
     public void actionPerformed(ActionEvent event) {
    	 
    	 index =  combo.getSelectedIndex();
    	 for (int i=0;i< tester.username.size();i++){
    		 usernameString = (tester.jComboBoxUserName.get(index));
           	  
            }
    	 try {
			tester.readFile();
			 passList = (tester.jComboBoxPassword.get(index));

			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	 	
			 
       	  
        
		passwordCombo =  passTextField.getPassword();
		if(passwordCombo.length ==4){
			passwordString = "" + passwordCombo[0]+ passwordCombo[1]+ passwordCombo[2]+ passwordCombo[3];

		}
		
		if (passwordCombo.length !=4){
			 JOptionPane.showMessageDialog(null, "Enter Your FOUR Digit Password");
        	 passTextField.setText("");

		}

		
		else{
			
		 if (passList.equals(passwordString)){
			 
			 if (MenuBar.player1){
				 try {
					 	PasswordCopy = passwordString;
					 	indexplayer1 = index;
					 	tester.currentPlayer[0]= tester.jComboBoxUserName.get(indexplayer1);
				
					 	
						tester.readFile();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			 JOptionPane.showMessageDialog(null, "User Login as Player 1");
			 
			 player1login = true;
			 MenuBar.player1 = false;
			 
			 }
			 else if (MenuBar.player2){
				 try {
					 	PasswordCopy2 = passString;
					 	indexplayer2 = index;
					 	tester.currentPlayer[1]= tester.jComboBoxUserName.get(indexplayer2);

					tester.readFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 JOptionPane.showMessageDialog(null, "User Login as Player 2");
				 
				
				 player2login= true;
				 MenuBar.player2 = false;
				
			 }
			 frame.dispose();
		 }
		 else {
        	 passTextField.setText("");
			 JOptionPane.showMessageDialog(null, "Incorrect Password");


		 }

		}
	 
     }     
 });
	
	 
 }
	
	
       	  
	 
}
