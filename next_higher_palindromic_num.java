
import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.nextPalin(s));
        }
            
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String nextPalin(String str) 
    { 
        //complete the function here
        int n=str.length();
        if(n<=3) return "-1";
        String half=str.substring(0,n/2);
        int len=half.length();
        String fhalf=next_permutation(half,len);
        if(fhalf.equals("-1")) return "-1";
        StringBuilder sb=new StringBuilder(fhalf);
        String shalf=sb.reverse().toString();
        if(n%2!=0) fhalf+=str.charAt(n/2);
        String ans=fhalf+shalf;
        return ans;
    }
    public String next_permutation(String str,int n){
        char[] charr=str.toCharArray();
        int i=n-2,idx=-1;
        while(i>=0){
            if(charr[i]<charr[i+1]){
                idx=i;
                break;
            }
            i--;
        }
        if(idx==-1) return "-1";
        int sidx=-1,minn=Integer.MAX_VALUE;
        for(int j=idx+1;j<n;++j){
            if(charr[j]>charr[idx]){
                minn=Math.min(minn,charr[j]-'0');
                if(minn==charr[j]-'0') sidx=j;
            }
        }
        char temp=charr[idx];
        charr[idx]=charr[sidx];
        charr[sidx]=temp;
        String res=new String(charr);
        StringBuilder sb=new StringBuilder(res.substring(idx+1));
        return res.substring(0,idx+1)+sb.reverse().toString();
        
    }
    
}
