class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = 1000000000, mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            int total = 0;
            for (int i = 0; i < piles.length; i ++) 
                total += Math.ceil(1.0 * piles[i] / mid);
            if (total > h)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;
    }
}