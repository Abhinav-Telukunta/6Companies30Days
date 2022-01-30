// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.height(N));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution{
    static int height(int N){
        // code here
        int ans=(-1+(int)Math.sqrt(1+8*N))/2;
        return ans;
    }
}