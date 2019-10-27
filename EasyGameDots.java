import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class EasyGameDots {
   
   // instance variables
   private ArrayList<String> info1; 
   private ArrayList<String> info2; 
   private ArrayList<String> info3;
   
   
   // constructor
   public EasyGameDots() {
      
      info1 = new ArrayList<String>();
      info2 = new ArrayList<String>();
      info3 = new ArrayList<String>();
      
   }
   /**
    * This method reads the emgame1info.txt file and stores it into an arraylist.
    *  @exception FileNotFoundException if aFile does not exist.
    */
   public void userfileToList() throws FileNotFoundException {
      
      File file1 = new File("easygame1info.txt");
      Scanner in1 = new Scanner(file1);
      String line1;
      
      while( in1.hasNextLine() ) {
         
         line1 = in1.nextLine();
         info1.add(line1);
      }      
      in1.close();
      
      
      File file2 = new File("easygame2info.txt");
      Scanner in2 = new Scanner(file2);
      String line2;
      
      while( in2.hasNextLine() ) {
         
         line2 = in2.nextLine();
         info2.add(line2);
      }      
      in2.close();
      
      
      File file3 = new File("easygame3info.txt");
      Scanner in3 = new Scanner(file3);
      String line3;
      
      while( in3.hasNextLine() ) {
         
         line3 = in3.nextLine();
         info3.add(line3);
      }      
      in3.close();
      
   }
   
   
   /**
    * This method takes 3 parameters and uses them to store the information on the emgame1info.txt file.
    *@param dot is the arraylist which contains the dots order.
    *@param x is the arraylist which contains the dots x coordination.
    *@param y is the arraylist which contains the dots y coordination.
    *@exception FileNotFoundException if aFile does not exist.
    */
   public void userlisteasy1ToFile(ArrayList<Integer> dot , ArrayList<Integer> x , ArrayList<Integer> y ) throws FileNotFoundException  {
      
      PrintWriter writer = new PrintWriter("easygame1info.txt");
      String str;
      
      for(int i = 0 ; i < dot.size() ; i++ ) {
         
         str = dot.get(i) +"/" +x.get(i) +"/" +y.get(i);
         writer.println(str);
      }
      writer.close();
   }
   /**
    * This method takes 3 parameters and uses them to store the information on the emgame1info.txt file.
    *@param dot is the arraylist which contains the dots order.
    *@param x is the arraylist which contains the dots x coordination.
    *@param y is the arraylist which contains the dots y coordination.
    *@exception FileNotFoundException if aFile does not exist.
    */
   public void userlisteasy2ToFile(ArrayList<Integer> dot , ArrayList<Integer> x , ArrayList<Integer> y ) throws FileNotFoundException  {
      
      PrintWriter writer = new PrintWriter("easygame2info.txt");
      String str;
      
      for(int i = 0 ; i < dot.size() ; i++ ) {
         
         str = dot.get(i) +"/" +x.get(i) +"/" +y.get(i);
         writer.println(str);
      }
      writer.close();
   }
   /**
    * This method takes 3 parameters and uses them to store the information on the emgame1info.txt file.
    *@param dot is the arraylist which contains the dots order.
    *@param x is the arraylist which contains the dots x coordination.
    *@param y is the arraylist which contains the dots y coordination.
    *@exception FileNotFoundException if aFile does not exist.
    */
   public void userlisteasy3ToFile(ArrayList<Integer> dot , ArrayList<Integer> x , ArrayList<Integer> y ) throws FileNotFoundException  {
      
      PrintWriter writer = new PrintWriter("easygame3info.txt");
      String str;
      
      for(int i = 0 ; i < dot.size() ; i++ ) {
         
         str = dot.get(i) +"/" +x.get(i) +"/" +y.get(i);
         writer.println(str);
      }
      writer.close();
   }
   /**
    * This method gets the players latest score.
    *@return info is the string arraylist which contains the information of dots.
    */
   public ArrayList<String> geteasygame1Info() {
      return info1;
   } 
   /**
    * This method gets the players latest score.
    *@return info is the string arraylist which contains the information of dots.
    */
   public ArrayList<String> geteasygame2Info() {
      return info2;
   }
   /**
    * This method gets the players latest score.
    *@return info is the string arraylist which contains the information of dots.
    */
   public ArrayList<String> geteasygame3Info() {
      return info3;
   }
}




