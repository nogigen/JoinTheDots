import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class CreateGameDots {
   
   // instance variables
   private ArrayList<String> info;
   private ArrayList<Integer> xCoordinate;
   private ArrayList<Integer> yCoordinate;
   
   // constructor
   public CreateGameDots() {
      
      info = new ArrayList<String>();
      xCoordinate = new ArrayList<Integer>();
      yCoordinate = new ArrayList<Integer>();
   }
   
   /**
    * This method reads the emgame2info.txt file and stores it into an arraylist.
    * @exception FileNotFoundException if aFile does not exist.
    */
   public void savefileToList() throws FileNotFoundException {
      
      ArrayList<String> myList = new ArrayList<String>();
      File file = new File("gamesaver.txt");
      Scanner in = new Scanner(file);
      String line;
      
      while( in.hasNextLine() ) {
         
         line = in.nextLine();
         info.add(line);
      }
      
      in.close();
   }
   /**
    * This method takes 3 parameters and uses them to store the information on the emgame2info.txt file.
    * @exception FileNotFoundException if aFile does not exist.
    * @param createdots are the dots that will be writeen to the file
    */
   public void writedotsToFile( ArrayList<CreateDots> createdots) throws FileNotFoundException  {
      
      PrintWriter writer = new PrintWriter("gamesaver.txt");
      String str = "";
      
      for(int i = 0 ; i < createdots.size() ; i++ ) {
         str = createdots.get(i).toString();
         writer.println(str);
      }
      
      writer.close();
   }
   /**
    * This method gets the players latest score.
    *@return info is the string arraylist which contains the information of dots.
    */
   public ArrayList<String> getCreateGameInfo() {
      return info;
   }  
}