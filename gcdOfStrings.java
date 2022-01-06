class Solution {
    public String gcdOfStrings(String str1, String str2) {
        String res1=str1+str2;
        String res2=str2+str1;
        if(res1.equals(res2)){
            int len=gcd(str1.length(),str2.length());
            return str1.substring(0,len);
        }
        return "";
    }
    public int gcd(int a,int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
}