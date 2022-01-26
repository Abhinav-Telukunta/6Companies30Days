class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int low=0,high=0;
        for(int w:weights){
            low=Math.max(low,w);
            high+=w;
        }
        int ans=0;
        while(low<=high){
            int mid=(low+high)/2;
            int curr=0,req=1;
            for(int w:weights){
                if(curr+w>mid){
                    curr=0;
                    req++;
                }
                curr+=w;
            }
            if(req>D) low=mid+1;
            else high=mid-1;
        }
        return low;
        
    }
}