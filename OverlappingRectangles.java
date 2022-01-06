// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            int p[] = new int[2];
            int q[] = new int[2];
            int r[] = new int[2];
            int s[] = new int[2];
            p[0] = Integer.parseInt(S[0]);
            p[1] = Integer.parseInt(S[1]);
            q[0] = Integer.parseInt(S[2]);
            q[1] = Integer.parseInt(S[3]);
            r[0] = Integer.parseInt(S[4]);
            r[1] = Integer.parseInt(S[5]);
            s[0] = Integer.parseInt(S[6]);
            s[1] = Integer.parseInt(S[7]);
            Solution ob = new Solution();
            int ans = ob.doOverlap(p, q, r, s);
            System.out.println(ans);
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
    int doOverlap(int L1[], int R1[], int L2[], int R2[]) {
        // code here
        int fxl=0,fxh=0,fyl=0,fyh=0;
        if(L1[0]<R1[0]){
            fxl=L1[0];
            fxh=R1[0];
        }
        else{
            fxl=R1[0];
            fxh=L1[0];
        }
        if(L1[1]<R1[1]){
            fyl=L1[1];
            fyh=R1[1];
        }
        else{
            fyl=R1[1];
            fyh=L1[1];
        }
        int sxl=0,sxh=0,syl=0,syh=0;
        if(L2[0]<R2[0]){
            sxl=L2[0];
            sxh=R2[0];
        }
        else{
            sxl=R2[0];
            sxh=L2[0];
        }
        if(L2[1]<R2[1]){
            syl=L2[1];
            syh=R2[1];
        }
        else{
            syl=R2[1];
            syh=L2[1];
        }
        int x=0,y=0;
        if(sxl<=fxl && fxl<=sxh && sxh<=fxh) x=1;
        if(fxl<=sxl && sxl<=sxh && sxh<=fxh) x=1;
        if(fxl<=sxl && sxl<=fxh && fxh<=sxh) x=1;
        if(sxl<=fxl && fxl<=fxh && fxh<=sxh) x=1;
        if(syl<=fyl && fyl<=syh && syh<=fyh) y=1;
        if(fyl<=syl && syl<=syh && syh<=fyh) y=1;
        if(fyl<=syl && syl<=fyh && fyh<=syh) y=1;
        if(syl<=fyl && fyl<=fyh && fyh<=syh) y=1;
        return (x==1 && y==1)?1:0;
        
    }
};