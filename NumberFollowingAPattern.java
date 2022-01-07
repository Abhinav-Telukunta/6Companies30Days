// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.printMinNumberForPattern(S));
        }
    }
}// } Driver Code Ends


//User function Template for Java
class Solution{
    static String printMinNumberForPattern(String S){
        // code here
        int n=S.length();
        int[] ans=new int[9];
        int ptr=0,min=0,I_index=0;
        if(S.charAt(0)=='I'){
            ans[ptr++]=1;
            ans[ptr++]=2;
            min=3;
            I_index=1;
        }
        else{
            ans[ptr++]=2;
            ans[ptr++]=1;
            min=3;
        }
        for(int i=1;i<n;++i){
            char ch=S.charAt(i);
            if(ch=='I'){
                ans[ptr++]=min;
                I_index=i+1;
            }
            else{
                int last=ans[i];
                ans[ptr++]=last;
                for(int j=I_index;j<=i;++j) ans[j]++;
            }
            min++;
        }
        String res="";
        for(int num:ans){
            if(num==0) break;
            res+=num;
        }
        return res;
        
    }
}
