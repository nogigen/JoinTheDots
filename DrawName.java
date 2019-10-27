import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class DrawName extends JPanel{
   
   //Variables
   ArrayList<CreateDots> allarrayDots;
   CreateDots dots;
   CreateGameDotsCollection dotscollection;
   HelpfulMethods info;
   int id;
   String name;
   JButton retrn;
   JLabel drawname,press,titleLabel;
   JTextField usernameField;
   ImageIcon img = new ImageIcon("back.jpg");
   ImageIcon returnIcon;
   
   //Constructor
   public DrawName(HelpfulMethods info,int id) throws FileNotFoundException{ 
      
      this.info = info;
      this.id = id;
      dotscollection = new CreateGameDotsCollection();
      createComponents();
      addComponents();
      
   }
   //creating components
   public void createComponents(){
      
      
      drawname = new JLabel("PICTURE NAME :");
      drawname.setBounds(270,200,250,60);
      drawname.setFont(new Font("Arial Black", Font.PLAIN, 24));
      
      usernameField = new JTextField();
      usernameField.setBounds(500,210,170,40);
      usernameField.addKeyListener(new EnterListener());
      
      
      
      titleLabel = new JLabel("JOIN THE DOTS");
      titleLabel.setFont(new Font("Arial Black", Font.PLAIN, 36));
      titleLabel.setBounds(380,20,600,50);
      
      returnIcon = new ImageIcon("return1.png");
      retrn = new JButton(returnIcon);
      retrn.setBounds(910,490,50,50);
      retrn.setBackground(Color.BLUE);
      retrn.addActionListener(new UsernameListener());
      
      
   }
   //adding components
   public void addComponents(){
      
      
      setLayout(null);
      add(drawname);
      add(usernameField);
      add(titleLabel);
      add(retrn);
      repaint();
      
      
      
   }
   
   /**
    * This method gives back the name of the user
    *@return returns name 
    */
   public String getName(){
      return name;
      
   }
   /**
    * This sets name of the user
    *@param name is the name that user gives
    */
   public void setName(String name){
      
      this.name = name;
   }
   /**
    * This method draws image to panel
    *@param g is the graphics 
    */
   
   public void paintComponent(Graphics g) {
      
      g.drawImage(img.getImage(), 0, 0, null);
      
   }
   // Enter Listener Class
   private class EnterListener implements KeyListener{
      
      public void keyPressed(KeyEvent evt){
         if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            
            try {
               setName(usernameField.getText());
               CreateGame panel = new CreateGame(info,id,dotscollection,usernameField.getText());
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
      public void keyTyped(KeyEvent evt){
         
      }
      
      public void keyReleased(KeyEvent evt) {
         
      }
   }
   
   //Username Listener class
   private class UsernameListener implements ActionListener{
      
      public void actionPerformed(ActionEvent e){
         
         if(e.getSource()==retrn){
            
            DifficultyLevel panel = new DifficultyLevel(info,id);
            panel.setBounds(0,0,1000,600);
            removeAll();
            
            add(panel);
            repaint();
            
         } 
      }
   }
}