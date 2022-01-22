//Initial template for JAVA

import java.util.Scanner;

class aToi
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String str = sc.nextLine();
			
			Solution obj = new Solution();
			System.out.println(obj.atoi(str));
		t--;
		}
	}
}// } Driver Code Ends


//User function template for JAVA

/*You are required to complete this method */
class Solution
{
    int atoi(String str) {
	    // Your code here
	    int num=0,n=str.length();
	    int flag=0;
	    for(int i=0;i<n;++i){
	        char ch=str.charAt(i);
	        if(i!=0 && !Character.isDigit(ch)) return -1;
	        if(i==0 && ch=='-'){
	            flag=1;
	            continue;
	        }
	        num=num*10+(ch-'0');
	    }
	    return flag==1?-num:num;
    }
}
