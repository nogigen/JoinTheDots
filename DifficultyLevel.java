import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class DifficultyLevel extends JPanel{
   
//variables
   
   int id;
   HelpfulMethods info;
   JButton easy,medium,retrn,hard,createGame;
   JLabel retrnLabel,titleLabel;
   ImageIcon easyIcon,mediumIcon,hardIcon;
   ImageIcon img = new ImageIcon("back.jpg");
   ImageIcon returnIcon;
   
   public DifficultyLevel(HelpfulMethods info , int id){
      this.info = info;
      this.id = id;
      createComponents();
      addComponents();
      
   }
   // creating components
   public void createComponents(){
      
      easyIcon = new ImageIcon("easy.png");
      mediumIcon = new ImageIcon("medium1.png");
      hardIcon = new ImageIcon("hard.png");
      
      
      
      returnIcon = new ImageIcon("return1.png");
      
      easy = new JButton(easyIcon);
      easy.setBounds(450,150,170,60);
      easy.setBackground(Color.BLUE);
      easy.addActionListener(new MyDifficultyListener());
      
      
      
      medium = new JButton(mediumIcon);
      medium.setBounds(450,230,170,65);
      medium.setBackground(Color.YELLOW);
      medium.addActionListener(new MyDifficultyListener());
      
      
      
      hard = new JButton( hardIcon);
      hard.setBounds(450,310,170,60);
      hard.setBackground(Color.GREEN);
      hard.addActionListener(new MyDifficultyListener());
      
      createGame = new JButton( "CREATE GAME");
      createGame.setBounds(450,390,170,60);
      createGame.setBackground(Color.RED);
      createGame.setFont(new Font("Arial Black", Font.PLAIN, 16));
      createGame.addActionListener(new MyDifficultyListener());
      
      
      
      
      retrn = new JButton(returnIcon );
      retrn.setBounds(900,500,50,40);
      retrn.addActionListener(new MyDifficultyListener());
      
      
      
      titleLabel = new JLabel("Difficulty Levels");
      titleLabel.setFont(new Font("Arial Black", Font.PLAIN, 36));
      titleLabel.setBounds(380,20,600,50);
      
      
   }
   // adding components
   public void addComponents(){
      
      
      setLayout(null); 
      add(easy);
      add(medium);
      add(hard);
      add(retrn);
      add(createGame);
      add(titleLabel);
      repaint();
      
   }
   
   /**
    * This method draws image to panel
    *@param g is the graphics 
    */
   public void paintComponent(Graphics g) {
      
      g.drawImage(img.getImage(), 0, 0, null);
   }
   //My Difficulty Listener class
   private class MyDifficultyListener implements ActionListener{
      
      public void actionPerformed(ActionEvent e){
         
         if(e.getSource()==retrn){
            
            
            MenuPanel panel = new MenuPanel(info,id);
            panel.setBounds(0,0,1000,600);
            removeAll();
            
            add(panel);
            repaint();
            
         }
         else if (e.getSource()==easy){
            
            GameModes panel = new GameModes("EASY",info,id);
            panel.setBounds(0,0,1000,600);
            removeAll();
            
            add(panel);
            repaint();
            
         }
         else if (e.getSource()==medium){
            
            GameModes panel = new GameModes("MEDIUM",info,id);
            panel.setBounds(0,0,1000,600);
            removeAll();
            
            add(panel);
            repaint();
            
         }
         else if (e.getSource()==hard){
            
            GameModes panel = new GameModes("HARD",info,id);
            panel.setBounds(0,0,1000,600);
            removeAll();
            
            add(panel);
            repaint();
            
         }
         else if (e.getSource()==createGame){
            try{
               DrawName panel = new DrawName(info,id);
               panel.setBounds(0,0,1000,600);
               removeAll();
               
               add(panel);
               repaint();
            }
            
            catch( IOException except ) {
               
               System.out.println("could not write to the file");
            }
         } 
      }
   }
}