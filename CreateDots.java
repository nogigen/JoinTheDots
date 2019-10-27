import java.util.ArrayList;
public class CreateDots {
   //Variables
   private ArrayList<Integer> x;
   private ArrayList<Integer> y;
   private String name;
   
   //Constructor
   public CreateDots(ArrayList<Integer> x , ArrayList<Integer> y , String name ) {
      
      this.x = x;
      this.y = y;
      this.name = name;
      
   }
   /**
    * This method sets x Arraylist
    *@param x is the x ArrayList
    */
   public void setxArrayList(ArrayList<Integer> x ) {
      this.x = x;
   }
   /**
    * This method sets y Arraylist
    *@param y is the y ArrayList
    */
   public void setyArrayList(ArrayList<Integer> y ) {
      this.y = y;
   }
   /**
    * This method sets the created name
    *@param name is the name that user gives
    */
   public void setCreateName(String name) {
      this.name = name;
   }
   /**
    * This method gives back the x coordinates
    *@return returns x Arraylist
    */
   public ArrayList<Integer> getxArrayList() {
      return x;
   }
   /**
    * This method gives back the y coordinates
    *@return returns y Arraylist
    */
   public ArrayList<Integer> getyArrayList() {
      return y;
   }
   /**
    * This method gives back the created name
    *@return returns name back
    */
   public String getCreateName() {
      return name;
   }
   
   /**
    * This method gives back the String version of coordinates
    *@return returns back the String version
    */
   public String toString() {
      String str = "";
     
      for(int i = 0 ; i < x.size() ; i++ ) {
         
         if( i == 0 ) {
            str = str + name;
         }
         str = str +"/" + x.get(i) +"/" +y.get(i);
      }
      return str;
   }
}