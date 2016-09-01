import java.awt.BorderLayout;    
import java.awt.Button;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
                     
/**
 * controls the frame for registering a new player 
 * @author geraldo
 *
 */
public class Register extends JFrame {
    Button register;
    JTextField userTextField;
    JPasswordField passTextField;
    Insets inset;
    boolean newUser = false;
    String passString;
    tester file;
    boolean empty = false;
    int n;
    
    /**
     * register constructor 
     */
    public Register(){
        
            String title = "New Player";
            final JFrame frame = new JFrame(title);
            Container content = frame.getContentPane();
            
            inset = content.getInsets();

            JPanel userPanel = new JPanel(new BorderLayout());
            JLabel userLabel = new JLabel("Username: ");
            userLabel.setDisplayedMnemonic(KeyEvent.VK_U);
            final JTextField userTextField = new JTextField();
            userLabel.setLabelFor(userTextField);
            userPanel.add(userLabel, BorderLayout.WEST);
            userPanel.add(userTextField, BorderLayout.CENTER);

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
            
            JButton register=new JButton("Register");
            register.setFont(new Font ("Arial", Font.PLAIN, 40));
            
            content.add(register);
            register.setBounds(inset.left + 10, inset.top + 20, 30, 10);
            
            frame.add(register);
            frame.setSize(250, 150);
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
            frame.setResizable(false);
            
       	
        
        
    register.addActionListener(new ActionListener() {
          
          public void actionPerformed(ActionEvent event) {
             

        	 
             String user = userTextField.getText();
             char[] pass = passTextField.getPassword();
             
             
          
             
             
             if (user.length()==0 && !(pass.length==4)){
                 JOptionPane.showMessageDialog(null, "Fill in the blanks");
                 empty = true;
             }
             

             else {
             if (user.length()==0){
                 JOptionPane.showMessageDialog(null, "Enter a username");
                 empty = true;

             }
             if (pass.length==0){
                 JOptionPane.showMessageDialog(null, "Enter a four digit password");
                 empty = true;

             }
             else
             if (!(pass.length == 4)){
            	 passTextField.setText("");
                 JOptionPane.showMessageDialog(null, "Four Digit Password Only");
                 empty = true;
                 
            	 
             }
             }
             
             if (pass.length == 4)
                 passString = "" + pass[0]+ pass[1]+ pass[2]+ pass[3];

           if (!empty){
			try {
				if (tester.compare(user)){
		      	tester.writeFile(passString,user);
				JOptionPane.showMessageDialog(null, "User created");
				tester.readFile();
                frame.dispose();
                tester.setUsername(tester.username);
                tester.setPassword(tester.password);
                
				}
				else {
					JOptionPane.showMessageDialog(null, "User already exists");
	            	 passTextField.setText("");
	            	 userTextField.setText("");

		      	
				}
		      	
		      	
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
			}
           
    }
           
          }   
          });
    
    

              
       } 
  
    
    

}