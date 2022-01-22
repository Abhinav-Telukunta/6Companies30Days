
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            int ans = new Solution().lengthOfLongestAP(a, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int lengthOfLongestAP(int[] A, int n) {
        // code here
        int maxx=A[n-1];
        int[][] dp=new int[n][maxx+1];
        for(int i=0;i<n;++i){
            for(int j=0;j<=maxx;++j) dp[i][j]=1;
        }
        int ans=1;
        for(int i=1;i<n;++i){
            for(int j=0;j<i;++j){
                int diff=A[i]-A[j];
                dp[i][diff]=dp[j][diff]+1;
                ans=Math.max(ans,dp[i][diff]);
            }
        }
        return ans;
    }
}
