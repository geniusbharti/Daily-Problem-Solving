class Solution {
    public int longestOnes(int[] nums, int k) {
        int i=0, j=0, n=nums.length, count0=0, max=Integer.MIN_VALUE;
        while(j<n){
            if(nums[j]==0) count0++;
            while(i<=j && count0>k) {
                if(nums[i]==0) count0--;
                i++;
            }
            max=Math.max(max, j-i+1);
            j++;
        }
        return max;
    }
}
