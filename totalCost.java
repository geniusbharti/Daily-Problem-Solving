class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        int i=0, j=n-1;
        PriorityQueue<Integer> firstPq = new PriorityQueue();
        PriorityQueue<Integer> lastPq = new PriorityQueue();
        long cost = 0L;
        while(k-->0){
            while(firstPq.size() < candidates && i<=j){
                firstPq.add(costs[i++]);
            }

            while(lastPq.size() < candidates && i<=j){
                lastPq.add(costs[j--]);
            }

            int v1 = (!firstPq.isEmpty()) ? firstPq.peek() : Integer.MAX_VALUE;
            int v2 = (!lastPq.isEmpty()) ? lastPq.peek() : Integer.MAX_VALUE;

            if(v1 <= v2) {
                cost+=v1;
                firstPq.poll();
            }else{
                cost+=v2;
                lastPq.poll();
            }

        }

        return cost;

    }
}
