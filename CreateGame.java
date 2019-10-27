import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.io.*;
import javax.swing.Timer;
import java.util.concurrent.TimeUnit;
import java.net.URL;
import java.applet.AudioClip;
import java.applet.Applet;


public class CreateGame extends JPanel{
   
   //Variables
   AudioClip click;
   HelpfulMethods info;
   int score = 0;
   int id;
   String gameMode;
   ArrayList<Integer> dotsX;
   ArrayList<Integer> dotsY;
   String dotsName;
   ArrayList<JButton> buttons = new ArrayList<JButton>();
   ArrayList <Integer> xxx = new ArrayList<Integer>();
   ArrayList <Integer> yyy = new ArrayList<Integer>();
   ArrayList<Color> colorArray = new ArrayList<Color>();
   boolean checker3 =false;
   boolean isOver =false;
   boolean gameWon =false;
   boolean gameStarted=false;
   boolean musicStarted = false;
   boolean conditionTime = true;
   boolean highestScore;
   boolean dotsSize;
   int seconds = 60;
   int counter =0;
   boolean checker =false;
   boolean lose =false;
   int colorRandom;
   Color color;
   ArrayList<CreateDots> dots;
   CreateGameDotsCollection dotscollection;
   CreateDots newPicture;
   String drawingName;
   ImageIcon drawIcon;
   JButton retrn,ok,play,pause,draw;
   JLabel retrnLabel,emptyLabel,titleLabel,timeLabel,scoreIconLabel,timeIconLabel,scoreLabel,gameModeLabel,congratsLabel,winLabel,rankLabel,plusLabel,userIconLabel,usernameLabel;
   ImageIcon timeIcon,scoreIcon, returnIcon, userIcon,playIcon,pauseIcon,empty;
   ImageIcon img = new ImageIcon("back.jpg"); 
   GameListener listener = new GameListener();
   Timer t = new Timer(1000,listener);
   
   //Constructor
   public CreateGame(HelpfulMethods info,int id,CreateGameDotsCollection dotscollection,String drawingName) throws FileNotFoundException{
      this.info =info;
      this.id = id;
      this.dotscollection = dotscollection;
      this.drawingName = drawingName;
      newPicture = dotscollection.loginCreateGame(drawingName);
      createComponents();  
      addComponents();
      dotsName = newPicture.getCreateName();
      
      if( newPicture.getxArrayList().size() == 0 ) {
         dotsSize = true;
      }
      else {
         dotsSize = false;
         xxx = newPicture.getxArrayList();
         yyy = newPicture.getyArrayList();
      }
      
      colorArray.add(Color.RED);
      colorArray.add(Color.GREEN);
      colorArray.add(Color.ORANGE);
      colorArray.add(Color.WHITE);
      colorArray.add(Color.YELLOW);
   }
   
   //Creating components
   public void createComponents()  {
      
      
      setLayout(null);
      timeIcon = new ImageIcon("time.png");
      scoreIcon = new ImageIcon("star.png");
      returnIcon = new ImageIcon("return1.png");
      userIcon = new ImageIcon(info.getallPlayers().get(id-1).geticonPath());
      
      userIconLabel = new JLabel(userIcon);
      userIconLabel.setBounds(780,100,50,50);
      
      usernameLabel = new JLabel(info.getallPlayers().get(id-1).getName());
      usernameLabel.setBounds(850,100,100,50);
      usernameLabel.setFont(new Font("Arial Black", Font.PLAIN, 18));
      
      
      retrn = new JButton(returnIcon);
      retrn.setBounds(910,490,50,50);
      retrn.setBackground(Color.BLUE);
      retrn.addActionListener(new GameListener());
      
      gameModeLabel = new JLabel("CREATE MODE");
      gameModeLabel.setFont(new Font("Arial Black", Font.PLAIN, 20));
      gameModeLabel.setBounds(780,10,300,40);
      
      
      
      timeLabel  = new JLabel();
      timeLabel.setBounds(850,160,100,30);
      timeLabel.setFont(new Font("Arial Black", Font.PLAIN, 20));
      timeIconLabel = new JLabel(timeIcon);
      timeIconLabel.setBounds(780,160,50,50);
      
      
      scoreLabel = new JLabel(""+score);
      scoreLabel.setBounds(850,220,100,30 );
      scoreLabel.setFont(new Font("Arial Black", Font.PLAIN, 20));
      
      scoreIconLabel = new JLabel(scoreIcon);
      scoreIconLabel.setBounds(780,210,50,50);
      
      
      
      
      playIcon = new ImageIcon("playmusic.jpg");
      play = new JButton(playIcon);
      play.setBounds(800,270,70,50);
      play.addActionListener(new MusicListener());
      play.setBackground(Color.WHITE);
      
      pauseIcon = new ImageIcon("pause.jpg");
      pause = new JButton(pauseIcon);
      pause.setBounds(875,270,70,50);
      pause.addActionListener(new MusicListener());
      pause.setBackground(Color.WHITE);
      
      empty = new ImageIcon("empty.png");
      emptyLabel = new JLabel(empty);
      emptyLabel.setBounds(0,0,750,600);
      
      drawIcon = new ImageIcon("draw.png");           
      draw = new JButton(drawIcon);
      draw.setBackground(Color.WHITE);
      draw.setBounds(0,550,750,50);
      draw.addActionListener(new ButtonListener());
      
      
   }
   
   //adding components 
   public void addComponents(){
      
      add(timeLabel);
      add(timeIconLabel);
      add(scoreLabel);
      add(scoreIconLabel);
      add(retrn);
      
      
      add(gameModeLabel);
      add(userIconLabel);
      add(usernameLabel);
      add(pause);
      add(play);
      add(draw);
      addMouseListener(new MyMouseListener());
      
      
   }
   // this method draws buttons
   public void draw() {
      
      for(int i =0;i<xxx.size();i++){
         
         colorRandom = (int) (Math.random() * colorArray.size() );
         color = colorArray.get(colorRandom);
         JButton a = new JButton(""+(i+1));
         //a.setFont(new Font("Arial Black", Font.PLAIN, 2));
         a.setBackground(color);
         a.addActionListener(new ButtonListener());
         a.setBounds(xxx.get(i),yyy.get(i),10,10);
         buttons.add(a);
         add(a);
         
         
      }
      
   }
   /**
    * This method draws image to panel
    *@param g is the graphics 
    */
   public void paintComponent(Graphics g) {
      Graphics2D g2 = (Graphics2D) g;
      
      
      g.drawImage(img.getImage(), 750, 0, null);
      g.drawImage(empty.getImage(),0,0,null);
      
      
      if(!gameStarted) {
         for(int i = 0 ; i < xxx.size() ; i++) {
            g2.setStroke(new BasicStroke(4));
            
            if(i!=0) {                  
               g2.drawLine(xxx.get(i-1),yyy.get(i-1),xxx.get(i),yyy.get(i));
            }
         }
      }
      
      if (checker){
         for(int i = 0 ; i < counter; i++ ) {
            g2.setStroke(new BasicStroke(4));
            if(i!=0) {                  
               g2.drawLine(xxx.get(i-1),yyy.get(i-1),xxx.get(i),yyy.get(i));
            }
            
         }            
         
         checker = false;
         
      } 
   }
   
   
   
   
   // My Mouse Listener class
   private class MyMouseListener implements MouseListener{
      
      
      public void mouseClicked(MouseEvent e){
         if(dotsSize) {
            Object obj = e.getSource();
            if( obj != draw ) { 
               if(!gameStarted){
                  int x = e.getX();
                  int y = e.getY();
                  if(x<=740 && y<=540){
                     
                     xxx.add(x);
                     yyy.add(y);
                     
                  }
                  repaint();
               }
            }
         }
      }
      public void mouseEntered(MouseEvent e){
         
         
      }
      public void mouseExited(MouseEvent e){
         
         
      }
      public void mouseReleased(MouseEvent e){
         
         
      }
      public void mousePressed(MouseEvent e){
         
         
      }      
   }
   
   // Game Listener Class
   private class GameListener implements ActionListener{
      
      boolean highestRank;
      String rank;
      boolean condition = true;
      
      public void actionPerformed(ActionEvent e){
         
         scoreLabel.setText(""+score);
         
         if(condition) {
            if(seconds>0){seconds--;}
            
            long second = TimeUnit.SECONDS.toSeconds(seconds)
               - (TimeUnit.SECONDS.toMinutes(seconds) * 60);
            timeLabel.setText( "" + second );
            if (seconds == 0) {
               t.stop();
               GameOver panel = new GameOver("CREATE GAME",info,id);
               panel.setBounds(0,0,1000,600);
               removeAll();
               
               add(panel);
               repaint();
               
            }
         }
         
         
         if (e.getSource()== retrn ){
            if(musicStarted) {
               click.stop();
            }
            t.stop();
            DifficultyLevel panel = new DifficultyLevel(info,id);
            panel.setBounds(0,0,1000,600);
            removeAll();
            
            add(panel);
            repaint();
            
            
            
         }
         if(isOver){
            if(lose) {
               
          
               t.stop();
               GameOver panel = new GameOver("CREATE GAME",info,id);
               panel.setBounds(0,0,1000,600);
               removeAll();
               
               add(panel);
               repaint();
               
            }
            else {
               
               ok = new JButton("OK");
               ok.setBounds(800,490,100,40);
               ActionListener listener = new OkButtonListener();
               ok.addActionListener(listener);
               
               winLabel = new JLabel();
               winLabel.setBounds(800,320,250,50);
               
               congratsLabel = new JLabel();
               congratsLabel.setBounds(760,380,250,50);
               
               rankLabel = new JLabel();
               rankLabel.setBounds(760,420,250,50);
               
               isOver = false;
               timeLabel.setText(""+seconds);
               
               plusLabel = new JLabel("+");
               plusLabel.setFont(new Font("Arial Black",Font.PLAIN,30));
               plusLabel.setBounds(850,180,50,50);
               
               
               
               add(ok);
               add(congratsLabel);
               add(winLabel);
               add(rankLabel);
               add(plusLabel);
               t.stop();
               condition = false;
               gameWon = true;
               repaint();
               score = score + seconds;
               
               highestScore = info.getallPlayers().get(id - 1).newHighestScore(score); // returns a boolean
               
               highestRank = info.getallPlayers().get(id - 1).newHighestRank(score);
               
               
               winLabel.setText("You Won!!!");
               winLabel.setFont(new Font("Arial Black",Font.PLAIN,28));
               if( highestScore ) {
                  
                  info.getallPlayers().get(id - 1).setHighestScore(score);
                  congratsLabel.setText("New Highest Score : " +score);
                  congratsLabel.setFont(new Font("Arial Black",Font.PLAIN,17));
                  
               }
               else {
                  
                  congratsLabel.setText("Score : " +score);
                  congratsLabel.setFont(new Font("Arial Black",Font.PLAIN,17));
               }
               
               if( highestRank ) {
                  info.getallPlayers().get(id-1).setHighestRank(info.getallPlayers().get(id-1).scoreToRank(score));
                  
                  rankLabel.setText("New Rank : " +info.getallPlayers().get(id - 1).getRank());
                  rankLabel.setFont(new Font("Arial Black",Font.PLAIN,17));
                  
               }
               else {
                  rankLabel.setText( "Rank : " +info.getallPlayers().get(id - 1).getRank());
                  rankLabel.setFont(new Font("Arial Black",Font.PLAIN,17));
               }
               
               
               
            }
         }
      }
   }
   // Ok Button Listener Class
   private class OkButtonListener implements ActionListener {
      
      public void actionPerformed(ActionEvent e) {
         
         
         
         if( e.getSource() == ok ) {
            
            if(musicStarted) {
               click.stop();
            }
            
            if( gameWon ) {
               score += seconds;
               try {
                  newPicture.setxArrayList(xxx);
                  newPicture.setyArrayList(yyy);
                  newPicture.setCreateName(drawingName);
                  CreateGameDots gamedots = new CreateGameDots();
                  gamedots.writedotsToFile(dotscollection.getCreateDots());
               }
               catch( IOException except ) {
                  
                  System.out.println("could not write to the file");
               }
            }
            
            
            
            if( highestScore ) { 
               
               info.getallPlayers().get(id - 1).setHighestScore(score);
               
            }      
            
            DifficultyLevel panel = new DifficultyLevel(info,id);
            panel.setBounds(0,0,1000,600);
            removeAll();
            
            add(panel);
            repaint();
            
         }
      }
   }
   
   
   // Button Listener Class
   private class ButtonListener implements ActionListener{
      
      public void actionPerformed(ActionEvent e){
         
         Object obj = e.getSource();
         JButton b = (JButton) obj;
         int horizontal = b.getX();
         int vertical = b.getY();
         
         if( gameStarted ) {
            if( counter <xxx.size()){
               
               if( horizontal == xxx.get(counter) && vertical == yyy.get(counter) ) {
                  score = score + 5;
                  checker = true;
                  repaint();
                  counter++;
                  
               }
               else{
                  isOver = true;
                  lose= true;
              
                  
               }
            }
            else {
               isOver = true;
               lose = false;
            }
            
            
            if( counter == xxx.size() ) {
            
               isOver = true;
               lose = false;
               
               
            }
         }
         
         if( e.getSource() == draw && xxx.size() != 0 ) {
            
            draw.setEnabled(false);
            draw();
            repaint();
            gameStarted = true;
            t.start();
            
         }  
      }  
   }
   //Menu Listener class
   private class MusicListener implements ActionListener{
      
      
      public void actionPerformed(ActionEvent e) {
         if (e.getSource() == play && conditionTime) {
            URL urlClick = EasyGame1Panel.class.getResource("ceza.wav");
            click = Applet.newAudioClip(urlClick);
            click.loop();
            conditionTime = false;
            musicStarted = true;
         }
         
         if (e.getSource() == pause && !conditionTime) {
            click.stop();
            conditionTime = true;
            musicStarted = false;
         }
      }  
   } 
}