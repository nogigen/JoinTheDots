import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class EasyGameDotsCollection {
   
   // instance variables
   private ArrayList<String> dotsInfo1;
   private ArrayList<Integer> EGame1xCoordinates;
   private ArrayList<Integer> EGame1yCoordinates;
   private ArrayList<Integer> EGame1dotID;
   private EasyGameDots EGame1dots;
   
   private ArrayList<String> dotsInfo2;
   private ArrayList<Integer> EGame2xCoordinates;
   private ArrayList<Integer> EGame2yCoordinates;
   private ArrayList<Integer> EGame2dotID;
   private EasyGameDots EGame2dots;
   
   
   private ArrayList<String> dotsInfo3;
   private ArrayList<Integer> EGame3xCoordinates;
   private ArrayList<Integer> EGame3yCoordinates;
   private ArrayList<Integer> EGame3dotID;
   private EasyGameDots EGame3dots;
   
   // constructor
   public EasyGameDotsCollection() throws FileNotFoundException {
      
      EGame1xCoordinates = new ArrayList<Integer>();
      EGame1yCoordinates = new ArrayList<Integer>();
      EGame1dotID = new ArrayList<Integer>();
      EGame1dots = new EasyGameDots();
      EGame1dots.userfileToList();
      dotsInfo1 = EGame1dots.geteasygame1Info();
      
      Scanner in1;
      String line1;
      String strDot1;
      String strX1;
      String strY1;
      int dot1;
      int x1;
      int y1;
      
      for( int i = 0 ; i < dotsInfo1.size() ; i++ ) {
         
         line1 = dotsInfo1.get(i);
         in1 = new Scanner(line1);
         in1.useDelimiter("/");
         strDot1 = in1.next();
         strX1 = in1.next();
         strY1 = in1.next();
         dot1 = Integer.parseInt(strDot1);
         x1 = Integer.parseInt(strX1);
         y1 = Integer.parseInt(strY1);
         EGame1dotID.add(dot1);
         EGame1xCoordinates.add(x1);
         EGame1yCoordinates.add(y1);
         in1.close();
         
      }
      
      
      
      
      EGame2xCoordinates = new ArrayList<Integer>();
      EGame2yCoordinates = new ArrayList<Integer>();
      EGame2dotID = new ArrayList<Integer>();
      EGame2dots = new EasyGameDots();
      EGame2dots.userfileToList();
      dotsInfo2 = EGame2dots.geteasygame2Info();
      
      Scanner in2;
      String line2;
      String strDot2;
      String strX2;
      String strY2;
      int dot2;
      int x2;
      int y2;
      
      for( int i = 0 ; i < dotsInfo2.size() ; i++ ) {
         
         line2 = dotsInfo2.get(i);
         in2 = new Scanner(line2);
         in2.useDelimiter("/");
         strDot2 = in2.next();
         strX2 = in2.next();
         strY2 = in2.next();
         dot2 = Integer.parseInt(strDot2);
         x2 = Integer.parseInt(strX2);
         y2 = Integer.parseInt(strY2);
         EGame2dotID.add(dot2);
         EGame2xCoordinates.add(x2);
         EGame2yCoordinates.add(y2);
         
         in2.close();
         
      }
      
      
      EGame3xCoordinates = new ArrayList<Integer>();
      EGame3yCoordinates = new ArrayList<Integer>();
      EGame3dotID = new ArrayList<Integer>();
      EGame3dots = new EasyGameDots();
      EGame3dots.userfileToList();
      dotsInfo3 = EGame3dots.geteasygame3Info();
      
      Scanner in3;
      String line3;
      String strDot3;
      String strX3;
      String strY3;
      int dot3;
      int x3;
      int y3;
      
      for( int i = 0 ; i < dotsInfo3.size() ; i++ ) {
         
         line3 = dotsInfo3.get(i);
         in3 = new Scanner(line3);
         in3.useDelimiter("/");
         strDot3 = in3.next();
         strX3 = in3.next();
         strY3 = in3.next();
         dot3 = Integer.parseInt(strDot3);
         x3 = Integer.parseInt(strX3);
         y3 = Integer.parseInt(strY3);
         EGame3dotID.add(dot3);
         EGame3xCoordinates.add(x3);
         EGame3yCoordinates.add(y3);
         
         in3.close();
         
      }
      
   }
   /**
    * This method takes two integers and sets a new dot.
    *@param x is the new dots x coordinate
    *@param y is the new dots y coordinate
    */
   public void addnextDot1(int x , int y) {
      
      EGame1xCoordinates.add(x);
      EGame1yCoordinates.add(y);
      EGame1dotID.add(EGame1xCoordinates.size() );
   }
   /**
    * This method takes two integers and sets a new dot.
    *@param x is the new dots x coordinate
    *@param y is the new dots y coordinate
    */
   public void addnextDot2(int x , int y) {
      
      EGame2xCoordinates.add(x);
      EGame2yCoordinates.add(y);
      EGame2dotID.add(EGame2xCoordinates.size() );
   }
   /**
    * This method takes two integers and sets a new dot.
    *@param x is the new dots x coordinate
    *@param y is the new dots y coordinate
    */
   public void addnextDot3(int x , int y) {
      
      EGame3xCoordinates.add(x);
      EGame3yCoordinates.add(y);
      EGame3dotID.add(EGame3xCoordinates.size() );
   }
   /**
    *  This method returns the arraylist which contains the IDs of dots.
    *@return EMgame1dotID is the arraylist which contains the IDs of dots.
    */
   public ArrayList<Integer> getdotID1() {
      return EGame1dotID;
   }
   /**
    *  This method returns the arraylist which contains the x coordinates of dots.
    *@return EMgame1xCoordinates is the arraylist which contains x coordinates.
    */
   public ArrayList<Integer> getx1Coordinate() {
      return EGame1xCoordinates;
   }
   /**
    * This method returns the arraylist which contains the y coordinates of dots.
    *@return EMgame1yCoordinates is the arraylist which contains y coordinates.
    */
   public ArrayList<Integer> gety1Coordinate() {
      return EGame1yCoordinates;
   }
   /**
    *  This method returns the arraylist which contains the IDs of dots.
    *@return EMgame2dotID is the arraylist which contains the IDs of dots.
    */
   public ArrayList<Integer> getdotID2() {
      return EGame2dotID;
   }
   /**
    *  This method returns the arraylist which contains the x coordinates of dots.
    *@return EMgame1xCoordinates is the arraylist which contains x coordinates.
    */
   public ArrayList<Integer> getx2Coordinate() {
      return EGame2xCoordinates;
   }
   /**
    * This method returns the arraylist which contains the y coordinates of dots.
    *@return EMgame1yCoordinates is the arraylist which contains y coordinates.
    */
   public ArrayList<Integer> gety2Coordinate() {
      return EGame2yCoordinates;
   }
   /**
    *  This method returns the arraylist which contains the IDs of dots.
    *@return EMgame3dotID is the arraylist which contains the IDs of dots.
    */
   public ArrayList<Integer> getdotID3() {
      return EGame3dotID;
   }
   /**
    *  This method returns the arraylist which contains the x coordinates of dots.
    *@return EMgame1xCoordinates is the arraylist which contains x coordinates.
    */
   public ArrayList<Integer> getx3Coordinate() {
      return EGame3xCoordinates;
   }
   /**
    * This method returns the arraylist which contains the y coordinates of dots.
    *@return EMgame1yCoordinates is the arraylist which contains y coordinates.
    */
   public ArrayList<Integer> gety3Coordinate() {
      return EGame3yCoordinates;
   }
}





