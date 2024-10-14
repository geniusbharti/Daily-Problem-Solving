class Solution {
    public long maxKelements(int[] nums, int k) {
        long sum = 0L;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->b-a);
        int n= nums.length;
        int i=0;
        while(i<n){
            pq.add(nums[i++]);
        }
        while(k-->0){
            int num = pq.poll();
            sum += num;
            pq.add((int)Math.ceil((double)num/3));
        }
        return sum;
    }
}
