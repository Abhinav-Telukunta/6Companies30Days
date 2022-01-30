class Solution {
    public boolean winnerOfGame(String colors) {
        int n=colors.length();
        int a=0,b=0;
        for(int i=1;i<n-1;++i){
            if(colors.charAt(i)==colors.charAt(i-1) && colors.charAt(i)==colors.charAt(i+1)){
                if(colors.charAt(i)=='A') a++;
                else b++;
            }
        }
        return a>b;
    }
}