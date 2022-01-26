class Solution {
    public int splitArray(int[] nums, int m) {
        int n=nums.length;
        int total=0,maxx=0;
        for(int num:nums) {
            total+=num;
            maxx=Math.max(maxx,num);
        }
        int low=maxx,high=total;
        while(low<=high){
            int mid=(low+high)/2;
            if(possible(mid,nums,m)) high=mid-1;
            else low=mid+1;
        }
        return low;
        
    }
    public boolean possible(int target,int[] nums,int m){
        int cnt=1;
        int total=0;
        for(int num:nums){
            total+=num;
            if(total>target){
                total=num;
                cnt++;
                if(cnt>m) return false;
            }
        }
        return true;
    }
}