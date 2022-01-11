// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int p[] = new int[n];
            for(int i = 0;i < n;i++)
                p[i] = Integer.parseInt(a[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.matrixChainOrder(p, n));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static char name='\0';
    static String matrixChainOrder(int p[], int n){
        // code here
        int[][] m = new int[n][n];
        int[][] bracket = new int[n][n];
        for (int i = 1; i < n; i++) m[i][i] = 0;
        for (int L = 2; L < n; L++) 
        {
          for (int i = 1; i < n - L + 1; i++) 
          {
            int j = i + L - 1;
            m[i][j] = Integer.MAX_VALUE;
            for (int k = i; k <= j - 1; k++)
            {
              int q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
              if (q < m[i][j]) 
              {
                m[i][j] = q;
                bracket[i][j] = k;
              }
            }
          }
        }
        StringBuilder sb=new StringBuilder();
        name = 'A';
        printParenthesis(1, n - 1, n, bracket,sb);
        return sb.toString();
            
    }
    static void printParenthesis(int i, int j, 
                               int n, int[][] bracket,StringBuilder sb){
    
        if (i == j)
        {
          sb.append(name+"");
          name++;
          return;
        }
        sb.append("(");
        printParenthesis(i, bracket[i][j], n, bracket,sb);
        printParenthesis(bracket[i][j] + 1, j, n, bracket,sb);
        sb.append(")");
    }



}