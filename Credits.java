import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Credits extends JPanel{
   //variables
   HelpfulMethods info;
   int id;
   Player player;
   String name;
   JButton retrn;
   JLabel elshad,nogay,begum,berk,utku,elshadIconLabel,nogayIconLabel,begumIconLabel,berkIconLabel,utkuIconLabel,titleLabel,gif;
   ImageIcon img = new ImageIcon("back.jpg");
   ImageIcon returnIcon, elshadIcon,begumIcon,berkIcon,nogayIcon,utkuIcon,gifIcon;
   
   //Constructor
   public Credits(){
      createComponents();
      addComponents();
      
   }
   // creating components
   public void createComponents(){
      
      elshadIcon = new ImageIcon("elshad.jpg");
      begumIcon = new ImageIcon("begumm.jpg");
      berkIcon = new ImageIcon("berk.jpg");
      nogayIcon = new ImageIcon("nogay.jpg");
      utkuIcon = new ImageIcon("utku.jpg");
      gifIcon = new ImageIcon("metro.gif");
      
      elshadIconLabel = new JLabel(elshadIcon);
      elshadIconLabel.setBounds(30,150,50,50);
      
      nogayIconLabel = new JLabel(nogayIcon);
      nogayIconLabel.setBounds(30,200,50,50);
      
      begumIconLabel = new JLabel(begumIcon);
      begumIconLabel.setBounds(30,250,50,50);
      
      berkIconLabel = new JLabel(berkIcon);
      berkIconLabel.setBounds(30,300,50,50);
      
      utkuIconLabel = new JLabel(utkuIcon);
      utkuIconLabel.setBounds(30,350,50,50);
      
      elshad = new JLabel("1.ELSHAD MAHMUDOV EE");
      elshad.setFont(new Font("Arial Black", Font.PLAIN, 20));
      elshad.setBounds(90,150,600,50);
      
      nogay = new JLabel("2.NOGAY EVIRGEN CS");
      nogay.setFont(new Font("Arial Black", Font.PLAIN, 20));
      nogay.setBounds(90,200,600,50);
      
      
      begum = new JLabel("3.ZEYNEP BEGUM SEVEN EE");
      begum.setFont(new Font("Arial Black", Font.PLAIN, 20));
      begum.setBounds(90,250,600,50);
      
      berk = new JLabel("4.BERK BUYUKDURAK CS");
      berk.setFont(new Font("Arial Black", Font.PLAIN, 20));
      berk.setBounds(90,300,600,50);
      
      utku = new JLabel("5.MEHMET UTKU DINCER EE");
      utku.setFont(new Font("Arial Black", Font.PLAIN, 20));
      utku.setBounds(90,350,600,50);      
      
      gif = new JLabel(gifIcon);
      gif.setBounds(420,100,500,400);
      
      
      
      titleLabel = new JLabel("JOIN THE DOTS");
      titleLabel.setFont(new Font("Arial Black", Font.PLAIN, 36));
      titleLabel.setBounds(350,20,600,50);
      
      returnIcon = new ImageIcon("return1.png");
      retrn = new JButton(returnIcon);
      retrn.setBounds(910,490,50,50);
      retrn.setBackground(Color.BLUE);
      retrn.addActionListener(new CreditsListener());
      
      
   }
   
   // adding components
   public void addComponents(){
      
      
      setLayout(null);
      add(titleLabel);
      add(retrn);
      add(elshadIconLabel);
      add(elshad);
      add(nogayIconLabel);
      add(nogay);
      add(begumIconLabel);
      add(begum);
      add(utkuIconLabel);
      add(utku);
      add(berkIconLabel);
      add(berk);
      add(gif);
      
      repaint();
      
   }
   
   
   /**
    * This method draws image to panel
    *@param g is the graphics 
    */ 
   
   public void paintComponent(Graphics g) {
      
      g.drawImage(img.getImage(), 0, 0, null);
      
   }
   
   
   
   //Credits Listener class
   private class CreditsListener implements ActionListener{
      
      public void actionPerformed(ActionEvent e){
         
         
         
         if(e.getSource()==retrn){
            
            try {
               
               Intro panel = new Intro();
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