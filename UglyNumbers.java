// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            System.out.println(new Solution().getNthUglyNo(n));
        }
    }
}// } Driver Code Ends


class Solution {
    /* Function to get the nth ugly number*/
    long getNthUglyNo(int n) {
        // code here
        long[] dp=new long[n];
        dp[0]=1;
        int cnt=0;
        int i2=0,i3=0,i5=0;
        int i=1;
        while(cnt<n-1){
            long num2=dp[i2]*2;
            long num3=dp[i3]*3;
            long num5=dp[i5]*5;
            long next_ugly=Math.min(num2,Math.min(num3,num5));
            dp[i++]=next_ugly;
            if(next_ugly==num2){
                i2++;
                num2=dp[i2]*2;
            }
            if(next_ugly==num3){
                i3++;
                num3=dp[i3]*3;
            }
            if(next_ugly==num5){
                i5++;
                num5=dp[i5]*5;
            }
            cnt++;
        }
        return dp[n-1];
        
    }
}