import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.io.*;

public class EasyDraw1 extends JPanel {
   //Variables
   HelpfulMethods info;
   int score = 0;
   int id;
   String gameMode;
   ArrayList<Integer> x = new ArrayList<Integer>();
   ArrayList<Integer> y = new ArrayList<Integer>();
   ArrayList<JButton> buttons = new ArrayList<JButton>();
   ArrayList<JButton> clickedButtons = new ArrayList<JButton>();
   
   
   int counter =0;
   boolean checker = false;
   boolean isOver = false;
   ImageIcon img = new ImageIcon("owl.png");
   
   //Constructor
   public EasyDraw1(String gameMode,HelpfulMethods info , int id){
      this.info = info;
      this.id = id;
      setLayout(null);
      this.gameMode = gameMode;
      
      
   }
   /**
    * This method gives back if game is over
    *@return retruns true or false depending on the situation
    */
   public boolean getIsOver(){
      
      return isOver;
      
   }
   /**
    * This method sets isover boolean
    *@param temp is boolean that we want to isOver be
    */
   public void setIsOver(boolean temp){
      
      isOver = temp;
      
   }
   /**
    * This method draws image and lines to panel
    *@param g is the graphics 
    */
   public void paintComponent(Graphics g) {
      
      
      Graphics2D g2 = (Graphics2D) g;
      g.drawImage(img.getImage(), 0, 0, null);
      if (checker){
         for(int i = 0 ; i < counter; i++ ) {
            g2.setStroke(new BasicStroke(4));
            g2.drawLine(x.get(i),y.get(i),x.get(i+1),y.get(i+1));
            
         }
         checker = false;
      }
   }
   /**
    * This method draws buttons to panel
    */
   public void draw() {
      
      try { //throws FileNotFoundException{
         
         
         if(gameMode.equals("GAME 1")){
            
            EasyGameDotsCollection EGame1collection = new EasyGameDotsCollection();
            
            x =  EGame1collection.getx1Coordinate();
            y =  EGame1collection.gety1Coordinate();
            
            for(int i =0;i<x.size();i++){
               
               JButton a = new JButton(""+(i+1));
               a.addActionListener(new ButtonListener());
               a.setBounds(x.get(i),y.get(i),10,10);
               buttons.add(a);
               add(a);
               
            }
            clickedButtons.add(buttons.get(0));
            
            
         }
      }
      catch( IOException except ) {
         
         System.out.println("could not write to the file");
      }  
   }
   /**
    * This method gives back score
    * @return  retruns back score
    */ 
   public int getScore() {
      return score;
   }
   
   //Button listener class
   private class ButtonListener implements ActionListener{
      
      
      public void actionPerformed(ActionEvent e){
         int number;
         Object obj = e.getSource();
         JButton b = (JButton) obj;
         number = Integer.parseInt(b.getText());
         if( number - 1 == Integer.parseInt(clickedButtons.get(counter).getText()) ) {
            score = score + 5;
            counter++;
            clickedButtons.add(b);
         }         
         
         if( counter != 0 ) {
            if(Integer.parseInt(clickedButtons.get(clickedButtons.size()-2).getText())== Integer.parseInt(clickedButtons.get(clickedButtons.size()-1).getText())-1){
               
               checker = true;
               repaint();
            }
         }
         
         if( clickedButtons.size() == buttons.size() ) {
            
            isOver = true;
            
            
         }
      } 
   }
}