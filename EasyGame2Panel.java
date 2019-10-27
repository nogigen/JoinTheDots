import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;
import java.util.concurrent.TimeUnit;
import java.io.*;
import java.net.URL;
import java.applet.AudioClip;
import java.applet.Applet;


public class EasyGame2Panel extends JPanel{
   
   //Variables
   AudioClip click;
   boolean highestScore;
   boolean gameWon;
   EasyDraw2 easy2Panel;
   HelpfulMethods info;
   int id;
   Player player;
   String name,mode;
   boolean conditionTime = true;
   boolean musicPlaying = false;
   JPanel gamePanel;
   JButton retrn,ok,play,pause;
   JLabel retrnLabel,titleLabel,timeLabel,scoreIconLabel,timeIconLabel,scoreLabel,gameModeLabel,congratsLabel,winLabel,rankLabel,plusLabel,userIconLabel,usernameLabel;
   ImageIcon timeIcon,scoreIcon, returnIcon, userIcon,playIcon,pauseIcon;
   ImageIcon img = new ImageIcon("back.jpg");
   int seconds = 60; 
   int  score = 0;
   GameListener listener = new GameListener();
   Timer t = new Timer(1000,listener);
   
   // Constructor
   public EasyGame2Panel(String name,String mode,HelpfulMethods info , int id) throws FileNotFoundException {
      
      this.info = info;
      this.id = id;
      this.name = name;
      this.mode = mode;
      createComponents();
      addComponents();
      
   }
   //Create components
   public void createComponents() throws FileNotFoundException {
      
      easy2Panel = new EasyDraw2("GAME 2",info,id);
      easy2Panel.draw();
      easy2Panel.setBounds(0,0,750,600);
      
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
      
      gameModeLabel = new JLabel(mode);
      gameModeLabel.setFont(new Font("Arial Black", Font.PLAIN, 36));
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
      
      
      titleLabel = new JLabel();
      titleLabel.setText(name);
      titleLabel.setFont(new Font("Arial Black", Font.PLAIN, 36));
      titleLabel.setBounds(780,40,300,50);
      
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
      
      
      
   }
   // adding components
   public void addComponents(){
      
      add(timeLabel);
      add(timeIconLabel);
      add(scoreLabel);
      add(scoreIconLabel);
      add(retrn);
      add(titleLabel);
      add(easy2Panel);
      add(gameModeLabel);
      add(userIconLabel);
      add(usernameLabel);
      add(pause);
      add(play);
      
      
      
      t.start();
      
      
   }
   /**
    * This method gives back the mode of the game
    *@return returns mode of the game 
    */
   public String getMode(){
      
      return mode;
   }
   
   /**
    * This method draws image to panel
    *@param g is the graphics 
    */
   public void paintComponent(Graphics g) {
      
      g.drawImage(img.getImage(), 750, 0, null);
      
   }
   // Game Listener class
   private class GameListener implements ActionListener{
      
      boolean highestRank;
      String rank;
      boolean condition = true;
      
      public void actionPerformed(ActionEvent e){
         score = easy2Panel.getScore();
         scoreLabel.setText(""+score);
         
         if(condition) {
            if(seconds>0){seconds--;}
            
            long second = TimeUnit.SECONDS.toSeconds(seconds)
               - (TimeUnit.SECONDS.toMinutes(seconds) * 60);
            timeLabel.setText( "" + second );
            if (seconds == 0) {
               t.stop();
               GameOver panel = new GameOver(mode,info,id);
               panel.setBounds(0,0,1000,600);
               removeAll();
               
               add(panel);
               repaint();
               
            }
         }
         
         
         if (e.getSource()== retrn ){
            if(musicPlaying) {
               click.stop();
            }
            t.stop();
            GameModes panel = new GameModes(mode,info,id);
            panel.setBounds(0,0,1000,600);
            removeAll();
            
            add(panel);
            repaint();
            
            
            
         }
         if(easy2Panel.getIsOver()){
            
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
            
            easy2Panel.setIsOver(false);
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
            score = easy2Panel.getScore()+seconds;
            
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
               info.getallPlayers().get(id-1).setHighestScore(score);
               
               rankLabel.setText("New Rank : " +info.getallPlayers().get(id - 1).getRank());
               rankLabel.setFont(new Font("Arial Black",Font.PLAIN,17));
               
            }
            else {
               rankLabel.setText( "Rank : " +info.getallPlayers().get(id - 1).getRank());
               rankLabel.setFont(new Font("Arial Black",Font.PLAIN,17));
            }
            
            
            info.getallPlayers().get(id - 1).seteasyGame3(1);
            
         }
      }
   }
   
   
   
   // Ok Button listener class
   private class OkButtonListener implements ActionListener {
      
      public void actionPerformed(ActionEvent e) {
         
         if( e.getSource() == ok ) {
            
            if(musicPlaying) {
               click.stop();
            }
            if( gameWon ) {
              // score = seconds;
            }
            
            
            if( highestScore ) { 
               
               info.getallPlayers().get(id - 1).setHighestScore(score);
               
            }      
            info.getallPlayers().get(id - 1).seteasyGame3(1);
            GameModes panel = new GameModes(mode,info,id);
            panel.setBounds(0,0,1000,600);
            removeAll();
            
            add(panel);
            repaint();
            
         }
      }
   }
   //Music Listener class
   private class MusicListener implements ActionListener{
      
      
      public void actionPerformed(ActionEvent e) {
         if (e.getSource() == play && conditionTime) {
            URL urlClick = EasyGame1Panel.class.getResource("ceza.wav");
            click = Applet.newAudioClip(urlClick);
            click.loop();
            conditionTime = false;
            musicPlaying = true;
         }
         
         if (e.getSource() == pause && !conditionTime) {
            click.stop();
            conditionTime = true;
            musicPlaying = false;
         }
      }  
   }
}