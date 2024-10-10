class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        int[] store = new int[n]; Arrays.fill(store, -1);
        return helper(n-1, nums, store);
    }

    private int helper(int idx, int[] nums, int[] store){
        //base
        if(idx<0) return 0;

        //store
        if(store[idx]!=-1) return store[idx];

        //main
        return store[idx] = Math.max(nums[idx]+helper(idx-2, nums, store), helper(idx-1, nums, store));
    }
}
