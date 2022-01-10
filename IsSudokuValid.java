// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-->0){
            String s1[] = in.readLine().trim().split("\\s+");
            int mat[][] = new int[9][9];
            for(int i = 0;i < 81;i++)
                mat[i/9][i%9] = Integer.parseInt(s1[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.isValid(mat));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static int isValid(int mat[][]){
        // code here
        int r=mat.length;
        int c=mat[0].length;
        Map<Integer,Set<Integer>>row=new HashMap<>();
        Map<Integer,Set<Integer>>col=new HashMap<>();
        Map<Integer,Set<Integer>>grid=new HashMap<>();
        row=init_hmp(row);
        col=init_hmp(col);
        grid=init_hmp(grid);
        for(int i=0;i<r;++i){
            for(int j=0;j<c;++j){
                int num=mat[i][j];
                if(num!=0){
                    if(row.get(i).contains(num) || col.get(j).contains(num)) return 0;
                    Set<Integer>temp1=row.get(i);
                    temp1.add(num);
                    row.put(i,temp1);
                    Set<Integer>temp2=col.get(j);
                    temp2.add(num);
                    col.put(j,temp2);
                    int grid_idx=(i/3)*3+(j/3);
                    if(grid.get(grid_idx).contains(num)) return 0;
                    Set<Integer>temp3=grid.get(grid_idx);
                    temp3.add(num);
                    grid.put(grid_idx,temp3);
                }
            }
        }
        return 1;
    }
    static Map<Integer,Set<Integer>> init_hmp(Map<Integer,Set<Integer>>map){
        for(int i=0;i<9;++i) map.put(i,new HashSet<>());
        return map;
    }
}