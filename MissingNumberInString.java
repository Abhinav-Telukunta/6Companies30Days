import java.util.*;
import java.lang.String;
import java.lang.Math;
class Main{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			String s=sc.next();
			GfG g=new GfG();
			System.out.println(g.missingNumber(s));
		}
	}
}// } Driver Code Ends


/*Complete the function below*/
class GfG
{
	public int missingNumber(String s)
    {
            //add code here.
        int n=s.length();
        int minn=Math.min(6,n);
        for(int len=1;len<=minn;++len){
            int prev=Integer.parseInt(s.substring(0,len));
            int ans=compute(s,len,prev,0,-1,n);
            if(ans!=-1) return ans;
        }
        return -1;
       
    }
    public int compute(String str,int idx,int prev,int flag,int missing,int n){
        if(idx==n) return missing;
        int curr=prev+1;
        String currVal=String.valueOf(curr);
        int currlen=currVal.length();
        if(n-idx>=currlen){
            String str1=str.substring(idx,idx+currlen);
            if(str1.equals(currVal))
                return compute(str,idx+currlen,curr,flag,missing,n);
        }
        if(flag==0){
            int next=prev+2;
            String nextVal=String.valueOf(next);
            int nextLen=nextVal.length();
            if(n-idx>=nextLen){
                String str2=str.substring(idx,idx+nextLen);
                if(str2.equals(nextVal))
                    return compute(str,idx+nextLen,next,1,curr,n);
                else return -1;
            }
            else return -1;
        }
        return -1;
    }
}
