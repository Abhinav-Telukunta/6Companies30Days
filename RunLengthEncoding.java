// { Driver Code Starts
import java.util.*;
 
class RLEncoding
{
   public static void main(String[] args) 
   {
 
      Scanner sc = new Scanner(System.in);
    
	  int T = sc.nextInt();
	  sc.nextLine();
	  while(T>0)
	  {
		  
		String str = sc.nextLine();
		
		GfG g = new GfG();
		System.out.println(g.encode(str));
		
      
        T--;
	  }
   }
}

// } Driver Code Ends


class GfG
 {
	String encode(String str)
	{
          //Your code here
          int cnt=1;
          String ans="";
          char curCh='\0';
          for(int i=0;i<str.length()-1;++i){
              curCh=str.charAt(i);
              char nextCh=str.charAt(i+1);
              if(curCh==nextCh) cnt++;
              else{
                  ans+=curCh;
                  ans+=cnt;
                  cnt=1;
              }
              
          }
          if(curCh!=str.charAt(str.length()-1)){
              ans+=str.charAt(str.length()-1);
              ans+=cnt;
          }
          else{
              ans+=curCh;
              ans+=cnt;
          }
          return ans;
          
	}
	
 }