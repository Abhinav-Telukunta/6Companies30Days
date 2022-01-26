import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int k = sc.nextInt();
                    String str = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.findMaximumNum(str, k));
                }
        }
}// } Driver Code Ends




class Solution
{
    //Function to find the largest number after k swaps.
    static String ans="0";
    public static String findMaximumNum(String str, int k)
    {
        //code here.
        char[] charr=str.toCharArray();
        ans=str;
        int n=charr.length;
        compute(charr,n,k,0);
        return ans;
            
    }
    public static void compute(char[] charr,int n,int k,int pos){
        if(pos==n || k==0) return;
        char maxm=charr[pos];
        for(int i=pos+1;i<n;++i){
            if(charr[i]>maxm) maxm=charr[i];
        }
        if(maxm!=charr[pos]) k--;
        for(int i=n-1;i>=pos;--i){
            if(charr[i]==maxm){
                char t=charr[pos];
                charr[pos]=charr[i];
                charr[i]=t;
                String res=new String(charr);
                if(res.compareTo(ans)>0){
                    ans=res;
                }
                compute(charr,n,k,pos+1);
                t=charr[pos];
                charr[pos]=charr[i];
                charr[i]=t;
            }
        }
        
    }
}