class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        if(n==1)  return cost[0];
        int store[] = new int[n+1];
        Arrays.fill(store, -1);
        return getMinCost(n, cost, store, false);
    }
    private int getMinCost(int idx, int[] cost, int[] store, boolean flag){
        //edge/base case
        if(idx==0 || idx==1) return cost[idx];

        //store has idx val
        if(store[idx]!=-1) return store[idx];

        //main case
        return store[idx] = ((flag) ? cost[idx] : 0) + Math.min(getMinCost(idx-1, cost, store, true), getMinCost(idx-2, cost, store, true));


    }
}
