// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int K = Integer.parseInt(in.readLine());
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int A[] = new int[N];
            for (int i = 0; i < N; i++) A[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            System.out.println(ob.maxProfit(K, N, A));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int maxProfit(int K, int N, int A[]) {
        // code here
        int[][] dp=new int[K+1][N+1];
        for(int t=1;t<=K;++t){
            int diff=Integer.MIN_VALUE;
            for(int i=1;i<N;++i){
                diff=Math.max(diff,dp[t-1][i-1]-A[i-1]);
                dp[t][i]=Math.max(dp[t][i-1],diff+A[i]);
            }
        }
        return dp[K][N-1];
        
        
    }
}