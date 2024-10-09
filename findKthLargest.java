class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue();
        int i=0;
        while(i<nums.length){
            pq.add(nums[i]);
            if(pq.size()>k)pq.poll();
            i++;
        }
        return pq.peek();
    }
}
