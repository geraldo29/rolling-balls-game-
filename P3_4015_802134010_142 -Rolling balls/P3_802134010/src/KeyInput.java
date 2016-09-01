import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * classs not used. it can control the ball using the mouse. 
 * @author geraldo
 *
 */
public class KeyInput extends KeyAdapter{
	
	private Handler handler; 
	private boolean[] keys = new boolean[8];
	/**
	 * constructor 
	 * @param handler updates the moving of the balls 
	 */
	public KeyInput(Handler handler){
		this.handler = handler;
		keys[0]=false;
		keys[1]=false;
		keys[2]=false;
		keys[3]=false;
		keys[4]=false;
		keys[5]=false;
		keys[6]=false;
		keys[7]=false;
	}
	
	/**
	 * moves the ball if you press a key 
	 * @param the key you pressed
	 */
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		for (int i =0; i<handler.object.size();i++){
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getID() == ID.Player1)
			{
				//keyEvents for player 1
				if (key == KeyEvent.VK_W){
					tempObject.setVelY(-5);
					keys[0]=true;	
					
				}
				if (key == KeyEvent.VK_S){
					tempObject.setVelY(5);
					keys[1]=true;
				}
				if (key == KeyEvent.VK_D){
					tempObject.setVelX(5);
					keys[2]=true;
				}
				if (key == KeyEvent.VK_A){
					tempObject.setVelX(-5);
					keys[3]=true;
				}
			}
			if(tempObject.getID() == ID.Player2)
			{
				//keyEvents for player 2
				if (key == KeyEvent.VK_UP){
					tempObject.setVelY(-5);
					keys[4]=true;
				}
				if (key == KeyEvent.VK_DOWN){
					tempObject.setVelY(5);
					keys[5]=true;
				}
				if (key == KeyEvent.VK_RIGHT){
					tempObject.setVelX(5);
					keys[6]=true;
				}
				if (key == KeyEvent.VK_LEFT){
					tempObject.setVelX(-5);
					keys[7]=true;
				}
				
			}
			

		}
			
	}
	/**
	 * stops moving the ball 
	 * 
	 */
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		for (int i =0; i<handler.object.size();i++){
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getID() == ID.Player1)
			{
				//keyEvents for player 1
				if (key == KeyEvent.VK_W)
					keys[0]=false;
				if (key == KeyEvent.VK_S)
					keys[1]=false;
				if (key == KeyEvent.VK_D)
					keys[2]=false;
				if (key == KeyEvent.VK_A)
					keys[3]=false;
				}
			if(tempObject.getID() == ID.Player2)
			{
				//keyEvents for player 1
				if (key == KeyEvent.VK_UP)
					keys[4]=false;
				if (key == KeyEvent.VK_DOWN)
					keys[5]=false;
				if (key == KeyEvent.VK_RIGHT)
					keys[6]=false;
				if (key == KeyEvent.VK_LEFT)
					keys[7]=false;
				
			}
			
			if(!keys[0] && !keys[1] && !keys[4] && !keys[5]  )
				tempObject.setVelY(0);
			if(!keys[2] && !keys[3] && !keys[6] && !keys[7]  )
				tempObject.setVelX(0);
			



		}
	}

}
