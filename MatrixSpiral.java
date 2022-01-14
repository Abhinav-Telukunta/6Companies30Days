import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int r = sc.nextInt();
            int c = sc.nextInt();
            
            int matrix[][] = new int[r][c];
            
            for(int i = 0; i < r; i++)
            {
                for(int j = 0; j < c; j++)
                 matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix, r, c);
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    }
}// } Driver Code Ends


class Solution
{
    //Function to return a list of integers denoting spiral traversal of matrix.
    static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c)
    {
        // code here 
        ArrayList<Integer>ans=new ArrayList<>();
        int ru=0,rd=r-1,cl=0,cr=c-1;
        while(ans.size()!=r*c){
            for(int col=cl;col<=cr;++col) ans.add(matrix[ru][col]);
            ru++;
            if(ru>rd) break;
            for(int row=ru;row<=rd;++row) ans.add(matrix[row][cr]);
            cr--;
            if(cr>=cl){
                for(int col=cr;col>=cl;--col) ans.add(matrix[rd][col]);
                rd--;
            }
            else break;
            if(rd>=ru){
                for(int row=rd;row>=ru;--row) ans.add(matrix[row][cl]);
                cl++;
            }
            else break;
            if(cl>cr) break;
        }
        return ans;
    }
}
