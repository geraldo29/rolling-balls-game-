import java.awt.Canvas;   
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


/**
 * creates the menubar 
 * @author geraldo
 *
 */


public class MenuBar extends Canvas{

    /**
     * 
     */
    private static final long serialVersionUID = -2574392034004979138L;
    
    
    Game.State state;
    DrawShapes paint;
    JFrame frame =new JFrame("Rolling Balls Game");
;
    JMenuBar menuBar; 
    JMenu playNewGame; 
    JMenu firstTimePlayer;
    JMenu history;
    JMenu help;
    JMenu exit;
    JMenuItem Player1;
    JMenuItem Player2;
    JMenuItem Player1LG;
    JMenuItem Player2LG;
    GameOver gameover;
    JMenuItem currentPlayers;
    JMenu selectNewPlayer;
    
    JMenuItem allGames;
    JMenuItem exitGame;
    JMenuItem aboutGame; 
    JMenuItem historyGame; 
    JMenuItem HowToPlay;
    JMenuItem historyOrder;
    JMenuItem firstTimePlay;
    JMenu Logout;
    Register register;
    Login login;
	   Random r = new Random();
    static boolean player1= false;
    static boolean player2= false;
    private  Game game;
    private Handler handler;
    static boolean logout1Successful =false;
   static boolean logout2Successful = false;
   
  static boolean createNewGame =false;


    DrawPanel draws = new DrawPanel();

    
    
    static boolean play = false;
    static boolean fileCreated = false;


/**
 * constructor for a frame for the menubar 
 * @param width the width of the frame 
 * @param height  the height of the frame 
 * @param game the game it will add 
 */
    public MenuBar(int width, int height, final Game game) {

    	
        // TODO Auto-generated method stub
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(width, height);
        frame.setBackground(Color.WHITE);
        frame.add(game);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.add(draws);
        
        game.start();
        menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        
        
        
        playNewGame = new JMenu("Play New Game ");
        playNewGame.addMouseListener(new MouseListener() {
            
        	
            
                

        @Override
        public void mouseClicked(MouseEvent arg0) {
            // TODO Auto-generated method stub
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
        	if (game.gameState1 == state.Game){
                
            }else{
            game.gameState1=state.PlayNewGame;
            }

        }

        @Override
        public void mouseReleased(MouseEvent arg0) {
            // TODO Auto-generated method stub
        	if (game.gameState1 == state.Game){
                
                
                
                
                
            }else{
            game.gameState1= state.Menu;
            }
        }     
            });
        
        firstTimePlayer =new JMenu("First Time Player");
        firstTimePlayer.addMouseListener(new MouseListener() {
               
               
               

            @Override
            public void mouseClicked(MouseEvent arg0) {
                // TODO Auto-generated method stub
                //game.gameState1=state.FirstTimePlayer;
                
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
            	if (game.gameState1 == state.Game){
                    
                
                }else{
               register = new Register ();
               game.gameState1=state.FirstTimePlayer;
                }
             

                
            }

            @Override
            public void mouseReleased(MouseEvent arg0) {
                // TODO Auto-generated method stub
                
            }     
                });
        history = new JMenu("History"); 
        history.addMouseListener(new MouseListener() {
               
               
               

            @Override
            public void mouseClicked(MouseEvent arg0) {
                // TODO Auto-generated method stub
                game.gameState1=state.History;
                String s = DateTime.getDateTime();
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
                });
        help = new JMenu("Help");
        
        exit= new JMenu("Exit");
        exit.addMouseListener(new MouseListener() {
               
               
               

            @Override
            public void mouseClicked(MouseEvent arg0) {
                System.exit(0);

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
                });
        
        
        currentPlayers = new JMenuItem("Current Players");
        currentPlayers.setToolTipText("Plays Game With Players That Are Logged In");
        currentPlayers.addActionListener(new ActionListener() {
             
             private Graphics g;

			public void actionPerformed(ActionEvent event) {
				
            	 if (login.player1login && login.player2login){
                     new SelectNumberOfBalls("Select Number Of Balls", "Number of Balls",10);
                    
                     
                     }
                     

                 
            	 else{
            	 try {
					if (tester.readFile()){
	        			 JOptionPane.showMessageDialog(null, "No Players Registrated");
	        			 

						register = new Register ();
						try {
							tester.readFile();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					  game.gameState1=state.FirstTimePlayer;
					} else{
						if (login.player1login && login.player2login){
		            		 game.gameState1=state.Game;
		            		 
		            	 }
		            	 else {
		        		 JOptionPane.showMessageDialog(null, "Login Both Players");
		        			 
		            		 if (login.player1login){
		      					try {
		      						
		      						player2 = true;
		      	            		 login = new Login();

									tester.readFile();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

		            		 
		            		 }
		            		 else if(login.player2login){
		      					try {
		      						player1=true;
		      	            		 login = new Login();
									tester.readFile();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

		            			 
		            		 }
		            		 else if (!login.player2login){
		            			 try {
		       						player1=true;
		       	            		 login = new Login();
		 							tester.readFile();
		 						} catch (IOException e) {
		 							// TODO Auto-generated catch block
		 							e.printStackTrace();
		 						}
		            			 
		            		 }
		            	 }
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	 
            	 
            	
            	 }
             }     
             });
        
        
       
        
        selectNewPlayer = new JMenu("Select New Player");
        selectNewPlayer.setToolTipText("New Player");
        selectNewPlayer.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent event) {
            	if (game.gameState1 == state.Game){
                    
                    
                    
                    
                    
                }
                 }
                 });
             
        
        
        Player1 = new JMenuItem("Player1");
        Player1.setToolTipText("Select Player 1");
        Player1.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent event) {
            	if (!Login.player1login){

            	
            	try {
     				if (tester.readFile()){
	        			 JOptionPane.showMessageDialog(null, "No Players Registrated");
     					register = new Register ();
                     game.gameState1=state.FirstTimePlayer;
     				}
     				
     				
     				else {
     					player1 = true;
     					player2 = false;
     					game.gameState1 = state.SelectNewPlayer;
     					login = new Login();
     					
     					
     				}
     				
     				
     				
     				
     				
     				
     				
     				
     				
     				
     				
     			} catch (IOException e) {
     				// TODO Auto-generated catch block
     				e.printStackTrace();
     			}
            	}
            	else {
   				 	JOptionPane.showMessageDialog(null, "Player One is already logged in. To select a new Player, log out first");

            	}

            }     
            });
        
        Player2 = new JMenuItem("Player2");
        Player2.setToolTipText("Select player 2");
        Player2.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent event) {
            	if (!Login.player2login){
            		
            		
            	
            	
            	try {
     				if (tester.readFile()){
     					register = new Register ();
                     game.gameState1=state.FirstTimePlayer;
     				}
     				
     				
     				else {
     					player1 = false;
     					player2 = true;
     					game.gameState1 = state.SelectNewPlayer;
     					login = new Login();
     					
     				}
     				
     				
     				
     				
     				
     				
     				
     				
     				
     				
     				
     			} catch (IOException e) {
     				// TODO Auto-generated catch block
     				e.printStackTrace();
     			}
            	}
            	else {
   				 	JOptionPane.showMessageDialog(null, "Player 2 is already logged in. To select a new Player, log out first");

            	}

            }     
            });
        
        aboutGame=new JMenuItem("About");
        aboutGame.setToolTipText("Game Description");
        aboutGame.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent event) {
                new aboutFrame();

            }     
            });
       
        HowToPlay = new JMenuItem("How To Play");
        HowToPlay.setToolTipText("Game rules and details on how to play.");
        HowToPlay.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent event) {
            	new rulesFrame();
            }     
            });
        Logout = new JMenu("Logout");
        Logout.setToolTipText("Logout player 1 or player 2.");
        Logout.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent event) {
            	
                

            }     
            });
        Player1LG = new JMenuItem("Player 1 ");
        Player1LG.setToolTipText("Player 1 Logout.");
        Player1LG.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent event) {
            	
            	if (!Login.player1login)
            		
					JOptionPane.showMessageDialog(null, "Log In First Dummy");
            	else {
            		Login.player1login = false;

            		
            		try {
						tester.readFile();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
            		
            		
            		tester.currentPlayer[0]= "Player 1 not Logged in";
   				 	JOptionPane.showMessageDialog(null, "Player1 Logged Out");
   				 	logout1Successful = true;
   				
            	}


            	
            }     
            });
        Player2LG = new JMenuItem("Player 2");
        Player2LG.setToolTipText("Player 2 Logout.");
        Player2LG.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent event) {
            	if (!Login.player2login)
					JOptionPane.showMessageDialog(null, "Log In First Dummy");
            	else {
            		Login.player2login = false;
            		try {
						tester.readFile();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
            		tester.currentPlayer[1]= "Player 2 not Logged in";
            		JOptionPane.showMessageDialog(null, "Player 2 Logged Out");
            		logout2Successful = true;
            	

            	}

            }     
            });
        allGames = new JMenuItem("All Games Played");
        allGames.setToolTipText("History of ALL games Played");
        allGames.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent event) {
            	HistoryFile.ShowTable();

            	

            }     
            });
        historyOrder = new JMenuItem("History In Order");
        historyOrder.setToolTipText("Select the column header you want in order");
        historyOrder.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent event) {
            	new historyOrder();       	

            }     
            });
        
        
       
        menuBar.add(playNewGame); 
        menuBar.add(firstTimePlayer); 
        menuBar.add(history); 
        menuBar.add(help); 
        menuBar.add(exit); 
        

        playNewGame.add(currentPlayers);
        playNewGame.add(selectNewPlayer);
        playNewGame.add(Logout);
        selectNewPlayer.add(Player1);
        selectNewPlayer.add(Player2);
        Logout.add(Player1LG);
        Logout.add(Player2LG);
        history.add(allGames);
        history.add(historyOrder);
        
       
        help.add(aboutGame);
        help.add(HowToPlay);
       

    }

    
    



  
    
}
	
	



  
    
