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
            String[] S = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            char [][] board = new char[n][m];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    board[i][j] = s[j].charAt(0);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(board, word);
            if(ans)
                System.out.println("1");
            else
                System.out.println("0");
       }
    }
}// } Driver Code Ends


class Solution
{
    public boolean isWordExist(char[][] board, String word)
    {
        // Code here
        int r=board.length,c=board[0].length;
        char ch=word.charAt(0);
        for(int i=0;i<r;++i){
            for(int j=0;j<c;++j){
                if(board[i][j]==ch){
                   if(dfs(board,i,j,r,c,word,0)) return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board,int i,int j,int r,int c,String word,int idx){
        if(i<0 || i>=r || j<0 || j>=c || board[i][j]=='1' || idx>=word.length()) return false;
        char ch=word.charAt(idx);
        if(ch==board[i][j]){
            if(idx==word.length()-1){
                return true;
            }
            char t=board[i][j];
            board[i][j]='1';
            boolean res1=dfs(board,i-1,j,r,c,word,idx+1); 
            boolean res2=dfs(board,i,j+1,r,c,word,idx+1); 
            boolean res3=dfs(board,i+1,j,r,c,word,idx+1);
            boolean res4=dfs(board,i,j-1,r,c,word,idx+1);
            board[i][j]=t;
            return res1||res2||res3||res4;
        }
        return false;
    }
}