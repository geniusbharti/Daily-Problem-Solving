class Solution {
    public int maxOperations(int[] nums, int k) {
    int c=0;
    HashMap<Integer, Integer> set = new HashMap<>();
    for(int i=0; i<nums.length; i++){
        if(set.containsKey(k-nums[i])){
            c++;
            set.put(k-nums[i], set.get(k-nums[i])-1);
            if(set.get(k-nums[i])==0) set.remove(k-nums[i]);
        }else {
            set.put(nums[i], set.getOrDefault(nums[i], 0)+1);
        }
    }
    return c;
    }
}
