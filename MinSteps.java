import java.util.*;
import java.lang.*;

/**
 * The MinSteps class calculates the minimum number of steps in playing the game. 
 Here the game has "n" pile of stacks. On each move, the player can subtract 1 or
 divide to half or remove 2/3 of the pile. The player should play till the pile 
 reaches to 1. The class has three methods recSolution(), dpSolution() and getMoves().
 * @author Aswin Timalsina
 */
 
 

public class MinSteps{

   int divTwo = 0;
   int divThree = 0;
   String recorder ="";
   int uinitial = 0;
   int initial = 0;
   int[] list;    
   int result = 0;

 
   /**
	 * Constructor initialise the number of tokens in pile
	 * @param number of tokens 
  	 */
   public MinSteps(int n){
      initial = n;
   }


   /**
	 * Method calls rec(int n) method
    @return the number of minimum steps to reach the pile to 1
  	 */
   public int recSolution(){
      return rec(initial);
   }


   /**
	 * Method to get the number of minimum steps to decrease the pile of token to 1
    * Method solves the problem using recursive method only
  	 * @return a number of minimum steps to decrease the pile of token to 1
  	 * @param n number of tokens
  	 */
   public int rec(int n){                 
         if(n == 1){
         return 0;
      }
      
      else{
      
         if(n%2==0 && n%3==0){                         //11
            return 1 + Math.min(Math.min(rec(n-1), rec(n/2)), rec(n/3));
         
         }
         
         else if(n%2==0){                              //10
            return 1 + Math.min(Math.min(rec(n-1), rec(n/2)), 1000);
         }
         
         else if(n%3==0){                              //01
            return 1 + Math.min(Math.min(rec(n-1), 1000), rec(n/3));
         }
         
         else{                                         //00
            return 1 + Math.min(Math.min(rec(n-1), 1000), 1000);
         }
      }
   }
   
  
 /**
	 * Method calls dp(int n) method
    @return the number of minimum steps to reach the stack to 1
  	 */ 
   public int dpSolution(){
      list  = new int[initial+1];
      return dp(initial);
   }
   
   
 /**
	 * Method to get the number of minimum steps to decrease the stack to 1
    * Method solves the problem using dynamic programming
    * Method uses recursive method as well as array to store the value 
  	 * @return a number of minimum steps to decrease the pile of tokens to 1
  	 * @param number of stacks
  	 */ 
   public int dp(int n){
      list[0] = 1000;
      if(list[n] != 0){
         return list[n];
      }
   
      if(n == 1){
         result = 0;
      }
      
      else{
      
         if(n%2==0 && n%3==0){
                             //11
            result = 1 + Math.min(Math.min(dp(n-1), dp(n/2)), dp(n/3));
         
         }
         
         else if(n%2==0){    
                             //10
            result =  1 + Math.min(Math.min(dp(n-1), dp(n/2)), 1000);
         }
         
         else if(n%3==0){    
                             //01
            result = 1 + Math.min(Math.min(dp(n-1), 1000), dp(n/3));
         }
         
         else{  
                            //00
            result = 1 + Math.min(Math.min(dp(n-1), 1000), 1000);
         }
       
      }
      list[n] = result;
      return result;
   }
   
   
   /**
	 * Method to get the move
    * Method calls dpSolution() method
    * Method solves the problem using dynamic programming
    * Method uses recursive method as well as array to store the value 
  	 * @return String of sequence of moves
  	 */ 
   public String getMoves(){
      uinitial = initial;
      list = new int[uinitial+1];
      list[0] = 1000;
      int loop = dpSolution()-1;
      for(int i = 0; i<loop; i++){
         divTwo = 0;
         divThree = 0;
      
         if(uinitial % 2 == 0){
            divTwo = uinitial/2;
         }
         
         else{divTwo = 0;}
      
         if(uinitial%3 == 0){
            divThree = uinitial/3;
         }
         
         else{divThree = 0;}
      
         if(list[uinitial-1]<=list[divTwo] && list[uinitial-1]<=list[divThree]){
            recorder = recorder + Integer.toString(uinitial-1) + " --> ";
            uinitial--;
         }
         
         else if(list[divTwo]<=list[uinitial-1] && list[divTwo]<=list[divThree]){
            recorder = recorder +  Integer.toString(divTwo) + " --> ";
            uinitial = divTwo;
         }
         
         else{
            recorder=recorder + Integer.toString(divThree) + " --> ";
            uinitial = divThree;
         }
      }
     
      if(initial == 1){
         return "1";
      }
     
      return Integer.toString(initial) + " --> " + recorder + "1";
   }
    
}//class ends
