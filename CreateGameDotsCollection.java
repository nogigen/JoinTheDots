import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class CreateGameDotsCollection {
   
   // instance variables
   private CreateDots currentDots;
   private ArrayList<CreateDots> createDots;
   private ArrayList<String> info;
   private ArrayList<String> CGameNames;
   private ArrayList<Integer> CGamexCoordinates;
   private ArrayList<Integer> CGameyCoordinates;
   private String name;
   private CreateGameDots CGamedots;
   
   
   // constructor
   public CreateGameDotsCollection() throws FileNotFoundException {
      
      createDots = new ArrayList<CreateDots>();
      CGameNames = new ArrayList<String>();
      //    CGamexCoordinates = new ArrayList<Integer>();
      //   CGameyCoordinates = new ArrayList<Integer>();
      
      CGamedots = new CreateGameDots();
      CGamedots.savefileToList();
      info = CGamedots.getCreateGameInfo();
      
      CreateDots newDots;
      Scanner in;
      String line;
      String nameGame;
      String strX;
      String strY;
      int x;
      int y;
      
      int j = 0;
      
      
      
      for( int i = 0 ; i < info.size() ; i++ ) {
         
         CGamexCoordinates = new ArrayList<Integer>();
         CGameyCoordinates = new ArrayList<Integer>();
         nameGame = "";
         
         j = 0;
         
         line = info.get(i);
         in = new Scanner(line);
         in.useDelimiter("/");
         
         while(in.hasNext()) {
            if( j == 0 ) {         
               nameGame = in.next();
               CGameNames.add(nameGame);         
            }
            
            strX = in.next();
            
            
            strY = in.next();
            
            
            x = Integer.parseInt(strX);
            y = Integer.parseInt(strY);
            CGamexCoordinates.add(x);
            CGameyCoordinates.add(y);
            j++;
            
            
         }
         newDots = new CreateDots(CGamexCoordinates,CGameyCoordinates,nameGame);
         createDots.add(newDots);
         in.close();
         
      }
      
      
   }   
   
   /**
    *  This method returns the arraylist which contains the x coordinates of dots.
    *@return EMgame1xCoordinates is the arraylist which contains x coordinates.
    */
   public ArrayList<Integer> getCreateXCoordinate() {
      return CGamexCoordinates;
   }
   /**
    * This method returns the arraylist which contains the y coordinates of dots.
    *@return EMgame1yCoordinates is the arraylist which contains y coordinates.
    */
   public ArrayList<Integer> getCreateYCoordinate() {
      return CGameyCoordinates;
   }
   
   public ArrayList<String> getCreateNames() {
      return CGameNames;
   }
   public ArrayList<CreateDots> getCreateDots() {
      return createDots;
   }
   public void setCurrentDots(CreateDots currentDots) {
      this.currentDots = currentDots;
   }
   public CreateDots getCurrentDots() {
      return currentDots;
   }  
   
   
   public CreateDots loginCreateGame(String nickname) {
      
      int counter = 0;
      String name = "";
      
      // checks all players if the nickname taken as a parameter matches.
      for(int i = 0 ; i < createDots.size() ; i++ ) {
         
         name = createDots.get(i).getCreateName();
         
         // if the names match, it sets the player and returns.
         if( name.equals(nickname) ) {
            return createDots.get(i);
            
         }         
      }
      ArrayList<Integer> xTemp = new ArrayList<Integer>();
      ArrayList<Integer> yTemp = new ArrayList<Integer>();
      
      CreateDots newCreateDots = new CreateDots(xTemp,yTemp,nickname);
      createDots.add(newCreateDots);
      return newCreateDots;
   }
}