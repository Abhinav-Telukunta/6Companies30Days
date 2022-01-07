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
            String s = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.decodedString(s));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static String decodedString(String s){
        // code here
        int n=s.length();
        int prevNum=0,currNum=0;
        Stack<String>strStack=new Stack<>();
        Stack<Integer>numStack=new Stack<>();
        String currStr="",prevStr="";
        for(int i=0;i<n;++i){
            char ch=s.charAt(i);
            if(Character.isDigit(ch)) currNum=currNum*10+(ch-'0');
            else if(Character.isLetter(ch)) currStr+=ch;
            else if(ch=='['){
                strStack.push(currStr);
                numStack.push(currNum);
                currNum=0;
                currStr="";
            }
            else{
                prevStr=strStack.pop();
                prevNum=numStack.pop();
                for(int j=0;j<prevNum;++j){
                    prevStr+=currStr;
                }
                currStr=prevStr;
            }
        }
        return currStr;
        
    }
}