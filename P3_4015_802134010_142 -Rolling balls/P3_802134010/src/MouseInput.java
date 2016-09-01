import java.awt.Color; 
import java.awt.Graphics;
import java.awt.event.MouseEvent; 
import java.awt.event.MouseListener;

/**
 * handles the mouse inputs during the game 
 * @author geraldo
 *
 */
public class MouseInput implements MouseListener{

	Player player1;
	int x;
	static boolean ballSelected = false;
	static boolean ballSelected2 =false;
	static boolean player1turn = true;
	static boolean player2turn = true;
	static boolean shootPlayer1 =true;
	static boolean shootPlayer2 = false;
	static float playerX;
	static float playerY;
	
	private Handler handler; 
	
	/**
	 * mouseinput constructor 
	 * @param handler renders through game 
	 */
	public MouseInput(Handler handler){
		this.handler = handler;
		
	}
	
	
	
	
	
	/**
	 * controls when you click the mouse
	 */
	@Override
	public void mouseClicked(MouseEvent arg0) {

		ballSelected = false;
		if(player1turn){
		// TODO Auto-generated method stub
		for (int i =0; i<handler.object.size();i++){
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getID() == ID.Player1){
			
				if (tempObject.getX() >= (Menu.x-20) && tempObject.getX() <=(Menu.x ) && tempObject.getY() >= Menu.y - 20 && tempObject.getY() <= Menu.y){
					ballSelected = true;
				
				}
			}
	}
		}
		else if(player2turn)
		for (int i =0; i<handler.object.size();i++){
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getID() == ID.Player2){
			
				if (tempObject.getX() >= (Menu.x-20) && tempObject.getX() <=(Menu.x ) && tempObject.getY() >= Menu.y - 20 && tempObject.getY() <= Menu.y){
					ballSelected2 = true;
				
				}
			}
			
				
	}

	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * updates my game 
	 * @param g graphics g 
	 */
	public void render (Graphics g){
		if (ballSelected){
			for (int i =0; i<handler.object.size();i++){
				GameObject tempObject = handler.object.get(i);
				if(tempObject.getID() == ID.Player1){
				
			if (tempObject.getX() >= (Menu.x-20) && tempObject.getX() <=(Menu.x ) && tempObject.getY() >= Menu.y - 20 && tempObject.getY() <= Menu.y){
			g.setColor(Color.BLACK);
			g.drawOval((int)tempObject.getX(), (int)tempObject.getY(), 21,21);
			
			playerX = tempObject.getX();
			playerY = tempObject.getY();
			}
			 }
			}
		
			
			g.setColor(Color.BLACK);
			g.drawRect(758, 548, 80, 34);
			
		}
		
			
			if (ballSelected2){
				
				
				
				for (int i =0; i<handler.object.size();i++){
					GameObject tempObject = handler.object.get(i);
					if(tempObject.getID() == ID.Player2){
					
				if (tempObject.getX() >= (Menu.x-20) && tempObject.getX() <=(Menu.x ) && tempObject.getY() >= Menu.y - 20 && tempObject.getY() <= Menu.y){
				g.setColor(Color.BLACK);
				g.drawOval((int)tempObject.getX(), (int)tempObject.getY(), 21,21);
				
				playerX = tempObject.getX();
				playerY = tempObject.getY();
				}
				 }
				g.setColor(Color.BLACK);
				g.drawRect(758, 638, 80, 34);
				
			}
		
}

	}
	
}