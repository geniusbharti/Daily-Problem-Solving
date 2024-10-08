class Solution {
    public int findPeakElement(int[] nums) {
        int n=nums.length;
        if(n==1) return 0;
        if(n>=2){
            if(nums[0]>nums[1]) return 0;
            if(nums[n-1]>nums[n-2]) return n-1;
        }
        int i=1, j = n-2; 
        while(i<=j){
            int m=i+(j-i)/2;
            if(nums[m]>nums[m-1] && nums[m]>nums[m+1]) return m;

            if(nums[m]>nums[m-1]){
                i=m+1;
            }else{
                j=m-1;
            }
        }

        return -1;
    }
}
