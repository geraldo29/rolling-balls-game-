import java.awt.Canvas;  
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

    /**
     * creates the new game. implements runnable to control a game loop and extends canvas 
     * @author geraldo
     *
     */
public class Game extends Canvas implements Runnable{

    /**
     * 
     */
    private static final long serialVersionUID = -5046303350517016229L;
    
    
    public static final int WIDTH = 1200, HEIGHT = 800;
    public static final int WIDTHGAME = 700, HEIGHTGAME= 700;
    private Thread thread; 
    private boolean running =  false;
    private Menu menu;
    static Handler handler = new Handler();; 
    private Random r;
    private MenuBar menuBar;
    Player player;
    GameOver gameover;
	protected boolean FirstTime = true;
	static GameObject gameObject;
    static int x;
    int numWidth = 0;
    int numHeight =0;
    int balls = 10;
    ArrayList<Integer> randomNumbers = new ArrayList<Integer>();
    ArrayList<Integer> otherRandomNumbers = new ArrayList<Integer>();
    MouseInput input;
	static int y,z;
    
/**
 * this is a enum which I use to change states.
 * @author geraldo
 *
 */
public enum State {
    
        Menu,
        Game,
        PlayNewGame,
        CurrentPlayer,
        SelectNewPlayer, 
        FirstTimePlayer,
        History,
        Help, 
        Exit,
    
};


    
    
    public static State gameState1 = State.Menu;
    
    /**
     * Constructor of game. creates the menu and game.
     */
    
    public Game(){
    	
    	
        menu = new Menu();

        input = new MouseInput(handler);

        new MenuBar(WIDTH, HEIGHT,this);
        this.addMouseListener(input);
        this.addMouseListener(menu);
      
      r = new Random();
      int HFballs = r.nextInt(4)+1;
      int Oballs = r.nextInt(4)+1;
      int Mballs = r.nextInt(4)+1;
  
     
    	 
    	 for(int i=0; i<Mballs;i++){

	        	int randomnumber = r.nextInt(WIDTHGAME);
	        	numWidth = randomnumber + 0;
	        	if (i >= 1 && Game.tooclose(randomnumber, numWidth)){
	        		do{
	        		randomnumber = r.nextInt(WIDTHGAME);
	        		for(int e = 0; e<randomNumbers.size();e++){
	        			if (Game.tooclose(randomnumber, randomNumbers.get(e))){
	        					randomnumber= r.nextInt(WIDTHGAME);
	        					e=-1;
	        			}
	        					
	        		}
	        		}
	        		while(Game.tooclose(randomnumber, numWidth));
	        			
	        	}
	    		randomNumbers.add(randomnumber);

	        	int otherrandomnumber = r.nextInt(HEIGHTGAME);
	        	numHeight = otherrandomnumber + 0;
	        	if (i >= 1 && Game.tooclose(otherrandomnumber, numHeight)){
	        		do{
	        			otherrandomnumber = r.nextInt(HEIGHTGAME);
	        			for(int e = 0; e<otherRandomNumbers.size();e++){
	            			if (Game.tooclose(otherrandomnumber, otherRandomNumbers.get(e))){
	            					otherrandomnumber= r.nextInt(HEIGHTGAME);
	            					e=-1;
	            			}
	            		}
	        			
	        		}
	        		while(Game.tooclose(otherrandomnumber, numHeight));

	        	}
	    		otherRandomNumbers.add(otherrandomnumber);

	        	numHeight = otherrandomnumber + 0;
	            handler.addObject(new Mine(randomnumber, otherrandomnumber, ID.Mine,handler));
	            
	        }
	        for(int i=0; i<Oballs;i++){

	        	int randomnumber = r.nextInt(WIDTHGAME);
	        	numWidth = randomnumber + 0;
	        	if (i >= 1 && Game.tooclose(randomnumber, numWidth)){
	        		do{
	        		randomnumber = r.nextInt(WIDTHGAME);
	        		for(int e = 0; e<randomNumbers.size();e++){
	        			if (Game.tooclose(randomnumber, randomNumbers.get(e))){
	        					randomnumber= r.nextInt(WIDTHGAME);
	        					e=-1;
	        			}
	        					
	        		}
	        		}
	        		while(Game.tooclose(randomnumber, numWidth));
	        			
	        	}
	    		randomNumbers.add(randomnumber);

	        	int otherrandomnumber = r.nextInt(HEIGHTGAME);
	        	numHeight = otherrandomnumber + 0;
	        	if (i >= 1 && Game.tooclose(otherrandomnumber, numHeight)){
	        		do{
	        			otherrandomnumber = r.nextInt(HEIGHTGAME);
	        			for(int e = 0; e<otherRandomNumbers.size();e++){
	            			if (Game.tooclose(otherrandomnumber, otherRandomNumbers.get(e))){
	            					otherrandomnumber= r.nextInt(HEIGHTGAME);
	            					e=-1;
	            			}
	            		}
	        			
	        		}
	        		while(Game.tooclose(otherrandomnumber, numHeight));

	        	}
	    		otherRandomNumbers.add(otherrandomnumber);

	        	numHeight = otherrandomnumber + 0;
	            handler.addObject(new Obstacle(randomnumber, otherrandomnumber, ID.Obstacle,handler));
	            
	        }for(int i=0; i<HFballs;i++){

	        	int randomnumber = r.nextInt(WIDTHGAME);
	        	numWidth = randomnumber + 0;
	        	if (i >= 1 && Game.tooclose(randomnumber, numWidth)){
	        		do{
	        		randomnumber = r.nextInt(WIDTHGAME);
	        		for(int e = 0; e<randomNumbers.size();e++){
	        			if (Game.tooclose(randomnumber, randomNumbers.get(e))){
	        					randomnumber= r.nextInt(WIDTHGAME);
	        					e=-1;
	        			}
	        					
	        		}
	        		}
	        		while(Game.tooclose(randomnumber, numWidth));
	        			
	        	}
	    		randomNumbers.add(randomnumber);

	        	int otherrandomnumber = r.nextInt(HEIGHTGAME);
	        	numHeight = otherrandomnumber + 0;
	        	if (i >= 1 && Game.tooclose(otherrandomnumber, numHeight)){
	        		do{
	        			otherrandomnumber = r.nextInt(HEIGHTGAME);
	        			for(int e = 0; e<otherRandomNumbers.size();e++){
	            			if (Game.tooclose(otherrandomnumber, otherRandomNumbers.get(e))){
	            					otherrandomnumber= r.nextInt(HEIGHTGAME);
	            					e=-1;
	            			}
	            		}
	        			
	        		}
	        		while(Game.tooclose(otherrandomnumber, numHeight));

	        	}
	    		otherRandomNumbers.add(otherrandomnumber);

	        	numHeight = otherrandomnumber + 0;
	            handler.addObject(new HappyFace(randomnumber, otherrandomnumber, ID.HappyFace,handler));
	           
	        }
	        for(int i=0; i<balls;i++){

	        	int randomnumber = r.nextInt(WIDTHGAME);
	        	numWidth = randomnumber + 0;
	        	if (i >= 1 && Game.tooclose(randomnumber, numWidth)){
	        		do{
	        		randomnumber = r.nextInt(WIDTHGAME);
	        		for(int e = 0; e<randomNumbers.size();e++){
	        			if (Game.tooclose(randomnumber, randomNumbers.get(e))){
	        					randomnumber= r.nextInt(WIDTHGAME);
	        					e=-1;
	        			}
	        					
	        		}
	        		}
	        		while(Game.tooclose(randomnumber, numWidth));
	        			
	        	}
	    		randomNumbers.add(randomnumber);

	        	int otherrandomnumber = r.nextInt(HEIGHTGAME);
	        	numHeight = otherrandomnumber + 0;
	        	if (i >= 1 && Game.tooclose(otherrandomnumber, numHeight)){
	        		do{
	        			otherrandomnumber = r.nextInt(HEIGHTGAME);
	        			for(int e = 0; e<otherRandomNumbers.size();e++){
	            			if (Game.tooclose(otherrandomnumber, otherRandomNumbers.get(e))){
	            					otherrandomnumber= r.nextInt(HEIGHTGAME);
	            					e=-1;
	            			}
	            		}
	        			
	        		}
	        		while(Game.tooclose(otherrandomnumber, numHeight));

	        	}
	    		otherRandomNumbers.add(otherrandomnumber);

	        	numHeight = otherrandomnumber + 0;
	       handler.addObject(new Player(randomnumber, otherrandomnumber, ID.Player1,handler));
	        
	        }
	        for(int i=0; i<balls;i++){

	        	int randomnumber = r.nextInt(WIDTHGAME);
	        	numWidth = randomnumber + 0;
	        	if (i >= 1 && Game.tooclose(randomnumber, numWidth)){
	        		do{
	        		randomnumber = r.nextInt(WIDTHGAME);
	        		for(int e = 0; e<randomNumbers.size();e++){
	        			if (Game.tooclose(randomnumber, randomNumbers.get(e))){
	        					randomnumber= r.nextInt(WIDTHGAME);
	        					e=-1;
	        			}
	        					
	        		}
	        		}
	        		while(Game.tooclose(randomnumber, numWidth));
	        			
	        	}
	    		randomNumbers.add(randomnumber);

	        	int otherrandomnumber = r.nextInt(HEIGHTGAME);
	        	numHeight = otherrandomnumber + 0;
	        	if (i >= 1 && Game.tooclose(otherrandomnumber, numHeight)){
	        		do{
	        			otherrandomnumber = r.nextInt(HEIGHTGAME);
	        			for(int e = 0; e<otherRandomNumbers.size();e++){
	            			if (Game.tooclose(otherrandomnumber, otherRandomNumbers.get(e))){
	            					otherrandomnumber= r.nextInt(HEIGHTGAME);
	            					e=-1;
	            			}
	            		}
	        			
	        		}
	        		while(Game.tooclose(otherrandomnumber, numHeight));

	        	}
	    		otherRandomNumbers.add(otherrandomnumber);

	        	numHeight = otherrandomnumber + 0;
	        handler.addObject(new Player2(randomnumber, otherrandomnumber, ID.Player2,handler));
	        
	        }
	        
	        
	        
	        handler.addObject(new DrawShapes(800,200,ID.Design,handler));
     }
	        
  
    
   
    /**
     * starts my game loop 
     */
    public synchronized void start(){
        
        
        thread = new Thread(this);
        thread.start();
        running = true;
        
        
    }

    /**
     * stops my game loop
     */
    public synchronized void stop(){
        try{
            thread.join();
            running = false;
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    /**
     * method to control a game loop. It is copied and it is a very popular game loop.
     */
    @Override
    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0; 
        double ns = 1000000000 / amountOfTicks;
        double delta  = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;

        while (running)
        {
            long now = System.nanoTime();
            delta+= (now-lastTime)/ ns;
            lastTime = now;
            while (delta >= 1){
                tick();
                delta--;
            }
            if (running){
                render();
            }
            frames++; 
            
            if(System.currentTimeMillis() - timer > 1000){
                timer+= 1000;
                //System.out.println("FPS: " + frames);
                frames = 0; 
                
            }
            
        }
        stop();
    }

    /**
     * sync game logic and graphics rendering
     */
    private void tick() {
        
            handler.tick();

            
            
            
            if (gameState1 == State.Game){
                
                  
                
                
            }
    }
    
    /**
     * like and update. it renders my graphics.
     */
    private void render() {
        // TODO Auto-generated method stub
        BufferStrategy bs = this.getBufferStrategy(); 
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.white);
        g.fillRect(0,0, WIDTH, HEIGHT); 
        
        if (gameState1 == State.Game){
        	  if (!GameOver.overGame){
        		  handler.render(g);
			       input.render(g);
			       
        	  }
        	  
            if (GameOver.overGame){
            	gameState1 = State.Menu;
            	GameOver.overGame=false;
            
            }
            
            	
            
        }
        else if (gameState1==State.FirstTimePlayer){
            
        

        }
        else if (gameState1==State.History){
            

        }
        else if (gameState1==State.Help){
            
            

        }
        else if (gameState1==State.SelectNewPlayer){
            
            

        }
        else if (gameState1==State.PlayNewGame){
            
            

        }
        else if (gameState1==State.Menu)
            menu.render(g);
        
        g.dispose();
        bs.show();
        
    }
    
    /**
     * mehtod so you dont go through the walls during the game. 
     * @param var positon you are in
     * @param min minimum position you can be
     * @param max maximum position you can be 
     * @return
     */
    public static int clamp(int var, int min, int max){
        if (var>= max)
            return var= max;
        else if (var <= min)
            return var= min;
        else
        return var;
    }
   
    /**
     * checks whether a ball is too close to another one. 
     * @param n position of first ball
     * @param e position of second ball
     * @return
     */
    public static boolean tooclose(int n, int e){
    	if(Math.abs(n - e)<=9)
    		return true; 
    		return false;
    	
    }
    
/**
 * main method that runs the game. creates the files used here. 
 * @param args
 */

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new Game();
        
        tester.createFile();
       HistoryFile.createFile();
       try {
		HistoryFile.readFile(HistoryFile.table);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  
        
        
    }
    
}