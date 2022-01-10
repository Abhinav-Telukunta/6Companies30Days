//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*; 
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
    		System.out.println (new Solution().colName (n));
        }
        
    }
}

// Contributed By: Pranay Bansal 
// } Driver Code Ends


//User function Template for Java

class Solution
{
    String colName (long n)
    {
        // your code here
        StringBuilder ans=new StringBuilder();
        while(n>0){
            long rem=n%26;
            if(rem==0){
                ans.append('Z');
                n=n/26-1;
            }
            else{
                ans.append((char)((rem-1)+'A'));
                n/=26;
            }
        }
        return ans.reverse().toString();
    }
}