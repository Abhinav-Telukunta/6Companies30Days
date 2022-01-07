class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n=nums.length;
        int i=0,j=0,sum=0;
        int ans=Integer.MAX_VALUE;
        while(i<n){
            if(sum>0) sum-=nums[i++];
            while(j<n && sum<target){
                sum+=nums[j++];
            }
            if(sum>=target) ans=Math.min(ans,j-i);
        }
        return ans==Integer.MAX_VALUE?0:ans;
    }
}