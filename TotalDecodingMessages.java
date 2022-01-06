// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.CountWays(str);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int CountWays(String str)
    {
        // code here
        char[] charr=str.toCharArray();
        int n=charr.length;
        int[] dp=new int[n+1];
        dp[0]=dp[1]=1;
        if(charr[0]=='0') return 0;
        int mod=(int)1e9+7;
        for(int i=2;i<=n;++i){
            if(charr[i-1]>'0') dp[i]=dp[i-1];
            if(charr[i-2]=='1' || (charr[i-2]=='2' && charr[i-1]<'7')) dp[i]=(dp[i]+dp[i-2])%mod;
        }
        return dp[n];
    }
}