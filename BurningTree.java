// { Driver Code Starts
//Initial Template for Java


import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class GfG {

	static Node buildTree(String str) {

		if (str.length() == 0 || str.charAt(0) == 'N') {
			return null;
		}

		String ip[] = str.split(" ");
		// Create the root of the tree
		Node root = new Node(Integer.parseInt(ip[0]));
		// Push the root to the queue

		Queue<Node> queue = new LinkedList<>();

		queue.add(root);
		// Starting from the second element

		int i = 1;
		while (queue.size() > 0 && i < ip.length) {

			// Get and remove the front of the queue
			Node currNode = queue.peek();
			queue.remove();

			// Get the current node's value from the string
			String currVal = ip[i];

			// If the left child is not null
			if (!currVal.equals("N")) {

				// Create the left child for the current node
				currNode.left = new Node(Integer.parseInt(currVal));
				// Push it to the queue
				queue.add(currNode.left);
			}

			// For the right child
			i++;
			if (i >= ip.length)
				break;

			currVal = ip[i];

			// If the right child is not null
			if (!currVal.equals("N")) {

				// Create the right child for the current node
				currNode.right = new Node(Integer.parseInt(currVal));

				// Push it to the queue
				queue.add(currNode.right);
			}
			i++;
		}

		return root;
	}

	static void printInorder(Node root) {
		if (root == null)
			return;

		printInorder(root.left);
		System.out.print(root.data + " ");

		printInorder(root.right);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t > 0) {
			String s = br.readLine();
			int target = Integer.parseInt(br.readLine());
			Node root = buildTree(s);

			Solution g = new Solution();
			System.out.println(g.minTime(root, target));
			t--;

		}
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    /*class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }*/
    static Node trgtptr=null;
    
    public static int minTime(Node root, int target) 
    {
        // Your code goes here
        Map<Node,List<Node>>map=new HashMap<>();
        buildGraph(map,root,null);
        int time=0;
        Queue<Node>queue=new LinkedList<>();
        Set<Node>visited=new HashSet<>();
        search(root,target);
        queue.add(trgtptr);
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;++i){
                Node curr=queue.poll();
                for(Node neigh:map.get(curr)){
                    if(visited.contains(neigh)) continue;
                    visited.add(neigh);
                    queue.add(neigh);
                }
            }
            time++;
        }
        return time-1;
        
    }
    public static void buildGraph(Map<Node,List<Node>>map,Node root,Node parent){
        if(root==null) return;
        if(map.get(root)==null){
            map.put(root,new ArrayList<Node>());
            if(parent!=null) {
                map.get(root).add(parent);
                map.get(parent).add(root);
            }
            buildGraph(map,root.left,root);
            buildGraph(map,root.right,root);
        }
    }
    public static void search(Node root,int target){
        if(root==null) return;
        if(root.data==target){
            trgtptr=root;
            return;
        }
        search(root.left,target);
        search(root.right,target);
    }
}