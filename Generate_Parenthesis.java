
import java.io.*;
import java.util.*;

class GFG{
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = Integer.parseInt(sc.next());
        while(t>0)
        {
            int n = Integer.parseInt(sc.next());
            Solution T = new Solution();
            List<String> ans = T.AllParenthesis(n);
            String[] sequences = ans.toArray(new String[0]);
            Arrays.sort(sequences);
            int k = sequences.length;
            for(int i=0;i<k;i++)
            {
                System.out.println(sequences[i]);
            }
            
            t--;
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    
    public List<String> AllParenthesis(int n) 
    {
        // Write your code here
        char[] charr=new char[2*n];
        List<String>ans=new ArrayList<>();
        generate_par(ans,charr,0,n,0,0);
        return ans;
    }
    public void generate_par(List<String>ans,char[] charr,int idx,int n,int open,int close){
        if(close==n){
            ans.add(new String(charr));
            return;
        }
        else{
            if(open>close){
                charr[idx]=')';
                generate_par(ans,charr,idx+1,n,open,close+1);
            }
            if(open<n){
                charr[idx]='(';
                generate_par(ans,charr,idx+1,n,open+1,close);
            }
        }
    }
}