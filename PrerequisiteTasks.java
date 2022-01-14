// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String args[]) throws IOException
	{
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
		while(t>0)
		{
		    int N = sc.nextInt();
		    int P = sc.nextInt();
		    int prerequisites[][] = new int[P][2];
		    for(int i=0;i<P;i++)
		    {
		        for(int j=0;j<2;j++)
		        {
		            prerequisites[i][j] = sc.nextInt();
		        }
		    }
			Solution ob = new Solution();
			if(ob.isPossible(N,prerequisites))
			{
			    System.out.println("Yes");
			}
			else{
			    System.out.println("No");
			}
			t--;
		}
	}
	
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public boolean isPossible(int N, int[][] prerequisites)
    {
        // Your Code goes here
        Graph g=new Graph(N);
        for(int[] edge:prerequisites){
            g.addEdge(edge);
        }
        boolean[] visited=new boolean[N];
        boolean[] stack=new boolean[N];
        for(int i=0;i<N;++i){
            if(isCycle(i,visited,stack,g)){
                return false;
            }
        }
        return true;
        
    }
    public boolean isCycle(int i,boolean[] visited,boolean[] stack,Graph g){
        if(stack[i]) return true;
        if(visited[i]) return false;
        visited[i]=true;
        stack[i]=true;
        List<Integer>neigh=g.adj.get(i);
        for(int ele:neigh){
            if(isCycle(ele,visited,stack,g)) return true;
        }
        stack[i]=false;
        return false;
    }
    
}

class Graph{
    int V;
    List<List<Integer>>adj;
    public Graph(int V){
        this.V=V;
        adj=new ArrayList<>(V);
        for(int i=0;i<V;++i){
            adj.add(new LinkedList<>());
        }
    }
    public void addEdge(int[] arr){
        int src=arr[1],dest=arr[0];
        adj.get(src).add(dest);
    }
}