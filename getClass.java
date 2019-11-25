public class getClass{

 int initial = 0;
 int[] list;
 int result = 0;
 int enter = 0;
 String condition = "";

   public getClass(int n){
      initial = n;
   }


   
   
    public String getMoves(){
    list = new int[initial+1];
      int value = get(initial);
     
          }
     
     public int get(int n){
      if(list[n] != 0){
      return list[n];
   }
   
       if(n == 1){
         result = 0;
      }
      
      else{
      
      if(n%2==0 && n%3==0){  
      enter++;   
      
         if(enter==1){
            condition = "11";
         }                    //11
         result = 1 + Math.min(Math.min(get(n-1), get(n/2)), get(n/3));
         
      }
      
      else if(n%2==0){  
      enter++;   
      if(enter == 1){
         condition = "10";
      }                         //10
         result =  1 + Math.min(Math.min(get(n-1), get(n/2)), 1000);
      }
      
      else if(n%3==0){        
      enter++;     
      if(enter == 1){
         condition = "01";
      }                 //01
         result = 1 + Math.min(Math.min(get(n-1), 1000), get(n/3));
      }
      
      else{   
      enter++;   
      if(enter ==1){
         condition = "00";
      }                        //00
         result = 1 + Math.min(Math.min(get(n-1), 1000), 1000);
      }
       
      }
      
      
      list[n] = result;
      return result;
     } //get ends





}