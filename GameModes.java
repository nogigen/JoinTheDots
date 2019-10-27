import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class GameModes extends JPanel{
   
   //Variables
   HelpfulMethods info;
   int id;
   Player player;
   boolean easyGame2Condition;
   boolean easyGame3Condition;
   boolean mediumGame2Condition;
   boolean mediumGame3Condition;
   boolean hardGame2Condition;
   boolean hardGame3Condition;
   String lock = "lock.png";
   String play = "play.png";
   JLabel titleLabel,game1Label,game2Label,game3Label;
   JButton retrn,game1,game2,game3;
   ImageIcon playIcon,lockIcon,returnIcon;
   ImageIcon img = new ImageIcon("back.jpg");
   String type;// Easy Medium or Hard
   
   //Constructor
   public GameModes(String type,HelpfulMethods info , int id){
      this.info = info;
      this.id = id;
      this.type = type; 
      createComponents();
      addComponents();
      
      
   }
   /**
    * This method sets type of the game
    *@param type is type that user gives
    */
   public void setType(String type){
      
      this.type = type;
      
   }
   
   /**
    * This method gets type of the game
    *@return returns type
    */
   public String getType(){
      
      return type;
      
   }
   //Create components
   public void createComponents(){
      
      playIcon = new ImageIcon("play.png");
      lockIcon = new ImageIcon("lock.png");
      returnIcon = new ImageIcon("return1.png");
      
      retrn = new JButton(returnIcon);
      retrn.setBounds(470,450,50,50);
      retrn.setBackground(Color.BLUE);
      retrn.addActionListener(new GameListener());
      
      game1 = new JButton(playIcon);
      game1.setBounds(100,200,170,140);
      game1.addActionListener(new GameListener());
      
      if(type.equals("EASY")){         
         if( info.getallPlayers().get(id-1).geteasyGame2() == 0 ) {
            game2 = new JButton(lockIcon);
            easyGame2Condition = false;
         }
         else {
            game2 = new JButton(playIcon);
            easyGame2Condition = true;
         }
      }
      else if(type.equals("MEDIUM")) {
         if(info.getallPlayers().get(id-1).getmediumGame2() == 0 ) {
            game2 = new JButton(lockIcon);
            mediumGame2Condition = false;
         }
         else {
            game2 = new JButton(playIcon);
            mediumGame2Condition =true;
         }
      }
      else if(type.equals("HARD")) {
         if( info.getallPlayers().get(id-1).gethardGame2() == 0 ) {
            game2 = new JButton(lockIcon);
            hardGame2Condition = false;
         }
         else {
            game2 = new JButton(playIcon);
            hardGame2Condition = true;
         }
      }         
      
      game2.setBounds(400,200,170,140);
      game2.addActionListener(new GameListener());
      
      
      if(type.equals("EASY")){         
         if( info.getallPlayers().get(id-1).geteasyGame3() == 0 ) {
            game3 = new JButton(lockIcon);
            easyGame3Condition = false;
         }
         else {
            game3 = new JButton(playIcon);
            easyGame3Condition = true;
         }
      }
      else if(type.equals("MEDIUM")) {
         if(info.getallPlayers().get(id-1).getmediumGame3() == 0 ) {
            game3 = new JButton(lockIcon);
            mediumGame3Condition = false;
         }
         else {
            game3 = new JButton(playIcon);
            mediumGame3Condition = true;
         }
      }
      else if(type.equals("HARD")) {
         if( info.getallPlayers().get(id-1).gethardGame3() == 0 ) {
            game3 = new JButton(lockIcon);
            hardGame3Condition = false;
         }
         else {
            game3 = new JButton(playIcon);
            hardGame3Condition = true;
         }
      } 
      
      
      game3.setBounds(700,200,170,140);
      game3.addActionListener(new GameListener());
      
      
      game1Label = new JLabel("GAME1");
      game1Label.setBounds(150,350,80,50);
      game1Label.setFont(new Font("Arial Black", Font.PLAIN, 18));
      
      game2Label = new JLabel("GAME2");
      game2Label.setBounds(450,350,80,50);
      game2Label.setFont(new Font("Arial Black", Font.PLAIN, 18));
      
      game3Label = new JLabel("GAME3");
      game3Label.setBounds(750,350,80,50);
      game3Label.setFont(new Font("Arial Black", Font.PLAIN, 18));
      
      
      titleLabel = new JLabel(type +" MODE GAMES");
      titleLabel.setFont(new Font("Arial Black", Font.PLAIN, 36));
      titleLabel.setBounds(300,60,600,50);
      
      
   }
   // adding components
   public void addComponents(){
      
      
      setLayout(null);
      
      add(game1);
      add(game2);
      add(game3);
      add(titleLabel);
      add(game1Label);
      add(game2Label);
      add(game3Label);
      add(retrn);
      repaint();
      
   }
   
   //GameListener class
   private class GameListener implements ActionListener {
      
      public void actionPerformed(ActionEvent e){
         
         if(e.getSource()==game1){
            try {
               if( type.equals("EASY")) {
                  EasyGame1Panel panel = new EasyGame1Panel("GAME 1",type,info,id);
                  panel.setBounds(0,0,1000,600);
                  removeAll();
                  
                  add(panel);
                  repaint();
               }
               
               else if(type.equals("MEDIUM")){
                  
                  MediumGame1Panel panel = new MediumGame1Panel("GAME 1",type,info,id);
                  panel.setBounds(0,0,1000,600);
                  removeAll();
                  
                  add(panel);
                  repaint();
                  
                  
                  
               }
               
               else {
                  HardGame1Panel panel = new HardGame1Panel("GAME 1",type,info,id);
                  panel.setBounds(0,0,1000,600);
                  removeAll();
                  
                  add(panel);
                  repaint();
                  
               }
            }
            catch( IOException except ) {
               
               System.out.println("could not write to the file");
            } 
         }
         
         else if(e.getSource()==game2){
            try {
               if( type.equals("EASY")) {
                  if( easyGame2Condition ) {
                     EasyGame2Panel panel = new EasyGame2Panel("GAME 2",type,info,id);
                     panel.setBounds(0,0,1000,600);
                     removeAll();
                     
                     add(panel);
                     repaint();
                  }
               }
               
               else if(type.equals("MEDIUM")){
                  if( mediumGame2Condition ) {
                     
                     
                     MediumGame2Panel panel = new MediumGame2Panel("GAME 2",type,info,id);
                     panel.setBounds(0,0,1000,600);
                     removeAll();
                     
                     add(panel);
                     repaint();
                  }
               }             
               else if( hardGame2Condition ) {
                  HardGame2Panel panel = new HardGame2Panel("GAME 2",type,info,id);
                  panel.setBounds(0,0,1000,600);
                  removeAll();
                  
                  add(panel);
                  repaint();
                  
               }
            }
            
            catch( IOException except ) {
               
               System.out.println("could not write to the file");
            }
            
         }           
         
         else if(e.getSource()==game3){ 
            
            try {
               if( type.equals("EASY")) {
                  if( easyGame3Condition) {
                     EasyGame3Panel panel = new EasyGame3Panel("GAME 3",type,info,id);
                     panel.setBounds(0,0,1000,600);
                     removeAll();
                     
                     add(panel);
                     repaint();
                  }
               }
               
               else if(type.equals("MEDIUM")){
                  if( mediumGame3Condition ) {
                     
                     MediumGame3Panel panel = new MediumGame3Panel("GAME 3",type,info,id);
                     panel.setBounds(0,0,1000,600);
                     removeAll();
                     
                     add(panel);
                     repaint();
                  }  
               } 
               else if( hardGame3Condition ) {
                  HardGame3Panel panel = new HardGame3Panel("GAME 3",type,info,id);
                  panel.setBounds(0,0,1000,600);
                  removeAll();
                  
                  add(panel);
                  repaint();
                  
               }
               
            }
            catch( IOException except ) {
               
               System.out.println("could not write to the file");
            } 
         }
         else if(e.getSource()==retrn){
            
            DifficultyLevel panel = new DifficultyLevel(info,id);
            panel.setBounds(0,0,1000,600);
            removeAll();
            add(panel);
            repaint();
            
         }   
      }
   }
   
   /**
    * This method draws image to panel
    *@param g is the graphics 
    */
   public void paintComponent(Graphics g) {
      
      g.drawImage(img.getImage(), 0, 0, null);
      
   }
   
}