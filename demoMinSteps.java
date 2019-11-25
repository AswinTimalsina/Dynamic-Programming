import java.util.*;
public class demoMinSteps{

   public static void main(String[] args){
   
   MinSteps demo = new MinSteps(200);
   
   System.out.printf("The number of minimal steps is %s", demo.getMoves());
   System.out.printf("\n\nThe number of minimal steps is %d. \n", demo.dpSolution());
   
   // int[] a = new int[10];
//     int b = 0;
//     if(a[5]==0){
//      b = 5;
//     }
//     System.out.print(b);
  }

}