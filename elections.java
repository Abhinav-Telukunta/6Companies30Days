import java.io.*;
import java.util.*;

class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            String arr[] = new String[n];
            
            for(int i = 0; i < n; i++)
                arr[i] = sc.next();
            
            Solution obj = new Solution();    
            String result[] = obj.winner(arr, n);
            System.out.println(result[0] + " " + result[1]);
            
           
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to return the name of candidate that received maximum votes.
    public static String[] winner(String arr[], int n)
    {
        // add your code
        Map<String,Integer>map=new HashMap<>();
        for(int i=0;i<n;++i){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        ArrayList<String[]>list=new ArrayList<>();
        for(Map.Entry<String,Integer>entry:map.entrySet()){
            list.add(new String[]{entry.getKey(),entry.getValue()+""});
        }
        Collections.sort(list,(a,b)->{
            int num1=Integer.parseInt(a[1]);
            int num2=Integer.parseInt(b[1]);
            if(num1!=num2) return num2-num1;
            else return a[0].compareTo(b[0]);
        });
        String key=list.get(0)[0];
        String value=list.get(0)[1];
        return new String[]{key,value};
    }
}

