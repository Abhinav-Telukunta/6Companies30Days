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
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.findMaxArea(grid);
            System.out.println(ans);
        }
    }
}// } Driver Code Ends


class Solution
{
    //Function to find unit area of the largest region of 1s.
    int t=0;
    public int findMaxArea(int[][] grid)
    {
        // Code here
        int r=grid.length,c=grid[0].length;
        int ans=0;
        for(int i=0;i<r;++i){
            for(int j=0;j<c;++j){
                if(grid[i][j]==1){
                    dfs(grid,i,j,r,c);
                    ans=Math.max(ans,t);
                    t=0;
                }
            }
        }
        return ans;
    }
    public void dfs(int[][] grid,int i,int j,int r,int c){
        if(i<0 || i>=r || j<0 || j>=c || grid[i][j]==0) return;
        grid[i][j]=0;
        t++;
        dfs(grid,i-1,j,r,c);
        dfs(grid,i+1,j,r,c);
        dfs(grid,i,j-1,r,c);
        dfs(grid,i,j+1,r,c);
        dfs(grid,i-1,j-1,r,c);
        dfs(grid,i-1,j+1,r,c);
        dfs(grid,i+1,j-1,r,c);
        dfs(grid,i+1,j+1,r,c);
    }
}