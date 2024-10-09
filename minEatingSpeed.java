class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            max = Math.max(max, piles[i]);
        }
        int low = 1, high = max, ans = max;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(canEatAllBananas(mid, piles, n, h)) {
                ans = mid;
                high = mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
    private boolean canEatAllBananas(int min, int[] arr, int n, int h){
        int currHr = 0;
        for(int i=0; i<n; i++){
            currHr += Math.ceil((double)arr[i]/(double)min);
        }
        return (currHr<=h) ? true : false;
    }
}
