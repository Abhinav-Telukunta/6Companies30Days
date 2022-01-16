// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            String[] nk = br.readLine().trim().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            Solution sln = new Solution();
            ArrayList<ArrayList<Integer>> ans = sln.fourSum(a, k);
            for (ArrayList<Integer> v : ans) {
                for (int u : v) {
                    System.out.print(u + " ");
                }
                System.out.print("$");
            }
            if (ans.isEmpty()) {
                System.out.print(-1);
            }
            System.out.println();
        }
    }
}// } Driver Code Ends


// User function Template for Java

// arr[] : int input array of integers
// k : the quadruple sum required

class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        // code here
        Arrays.sort(arr);
        int n=arr.length;
        TreeSet<ArrayList<Integer>>set=new TreeSet<>((a,b)->{if(a.get(0)!=b.get(0)) return a.get(0)-b.get(0); else if(a.get(1)!=b.get(1)) return a.get(1)-b.get(1); else if(a.get(2)!=b.get(2)) return a.get(2)-b.get(2); else return a.get(3)-b.get(3);});
        for(int i=0;i<n-3;++i){
            for(int j=i+1;j<n-2;++j){
                int low=j+1,high=n-1;
                while(low<high){
                    if(arr[i]+arr[j]+arr[low]+arr[high]==k){
                        ArrayList<Integer>t=new ArrayList<>();
                        t.add(arr[i]);
                        t.add(arr[j]);
                        t.add(arr[low]);
                        t.add(arr[high]);
                        set.add(t);
                        low++;
                        high--;
                    }
                    else if(arr[i]+arr[j]+arr[low]+arr[high]<k) low++;
                    else high--;
                }
            }
        }
        ArrayList<ArrayList<Integer>>ans=new ArrayList<>();
        for(ArrayList<Integer>ele:set) ans.add(ele);
        return ans;
    }
}