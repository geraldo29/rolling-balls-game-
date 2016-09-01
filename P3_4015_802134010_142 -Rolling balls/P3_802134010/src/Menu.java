import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

/**
 * creates the main menu implements mouseListener 
 * @author geraldo
 *
 */

public class Menu extends MouseAdapter implements MouseListener{
	
    Game.State state;
    private  Game game;
    GameObject object;
    static int x;
   static int y;
	  /**
	   * creates the menu
	   */
	  public Menu(){
	  }
		
	  /**
	   * method to sync game logic and rendering graphics 
	   */
	  public void tick(){
	    	
	    }
	  /**
	   * updates my graphics in the game.
	   * @param g
	   */
	    public void render(Graphics g){
	    	g.setFont(new Font("TimesRoman", Font.BOLD, 50));
	    	g.setColor(Color.BLACK);
	    	g.drawString("The", 420, 200);
	    	g.drawString("Rolling-Balls", 350, 250);
	    	g.drawString("Game", 400, 300);
	    	g.setFont(new Font("TimesRoman", Font.ITALIC, 25));
	    	g.drawString("...by GERALDO LOPEZ", 180, 700);
	    	
	    	
	    }
	    /**
	     * controls when you click a mouse during the game. 
	     */
		@Override
		public void mouseClicked(MouseEvent e) {
			
			 x = e.getX();
			y = e.getY();
			System.out.println(x);
			System.out.println(y);
			
			if (game.gameState1 == state.Game){
				
			if (MouseInput.ballSelected && MouseInput.player1turn){
			
			if (x<834 && x >760 && y <580 && y > 551){
				new SelectDistance("Distance" , "Enter your Distance", 1500 );
				 
			}
			}
			if (MouseInput.ballSelected2 && MouseInput.player2turn){
			
			
			if (x<834 && x >760 && y <669 && y > 640){
				new SelectDistance("Distance" , "Enter your Distance", 1500 );
				
			}
			}
			if (x<1149 && x >1065 && y <670 && y > 640){
				if(JOptionPane.showConfirmDialog(null, "If you abort game, this game WILL NOT be saved. Are you sure you want to abort game", "Confirm ABORT", 
                        JOptionPane.YES_NO_OPTION) == 0)
					game.gameState1 = state.Menu;
				  

				
			}
		}
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
}
