class Solution {
    public int pivotIndex(int[] nums) {
         int totsum = 0, n = nums.length;
         for(int e:nums) totsum+=e;
         int lsum=0, rsum=0;
         for(int i=0; i<n; i++){
            if((totsum-lsum-nums[i])==lsum) return i;
            lsum+=nums[i];
         }
         return -1;
    }
}
