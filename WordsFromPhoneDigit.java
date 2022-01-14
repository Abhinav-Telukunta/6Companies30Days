//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class PhoneDigit
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();//testcases
        
        
        while(t-- > 0)
        {
            int n = sc.nextInt(); // input size of array
            int arr[] = new int[n]; //input the elements of array that are keys to be pressed
            
            for(int i = 0; i < n; i++)
               arr[i] = sc.nextInt();//input the elements of array that are keys to be pressed
            ArrayList <String> res = new Solution().possibleWords(arr, n);
            for (String i : res) System.out.print (i + " ");
             System.out.println();
              
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find list of all words possible by pressing given numbers.
    static ArrayList <String> possibleWords(int a[], int N)
    {
        // your code here  
        Map<Integer,ArrayList<Character>>map=new HashMap<>();
        map.put(2,new ArrayList<Character>(Arrays.asList('a','b','c')));
        map.put(3,new ArrayList<Character>(Arrays.asList('d','e','f')));
        map.put(4,new ArrayList<Character>(Arrays.asList('g','h','i')));
        map.put(5,new ArrayList<Character>(Arrays.asList('j','k','l')));
        map.put(6,new ArrayList<Character>(Arrays.asList('m','n','o')));
        map.put(7,new ArrayList<Character>(Arrays.asList('p','q','r','s')));
        map.put(8,new ArrayList<Character>(Arrays.asList('t','u','v')));
        map.put(9,new ArrayList<Character>(Arrays.asList('w','x','y','z')));
        ArrayList<String>ans=new ArrayList<>();
        dfs(map,a,ans,N,0,"");
        return ans;
    }
    static void dfs(Map<Integer,ArrayList<Character>>map,int[] a,ArrayList<String>ans,int N,int pos,String str){
        if(pos==N){
            ans.add(str);
            return;
        }
        int num=a[pos];
        for(char ch:map.get(num)){
            dfs(map,a,ans,N,pos+1,str+""+ch);
        }
    }
}


