class Solution {
    int[][] dp;
    public int maxProfit(int[] p, int fee) {
        int n=p.length;
        dp = new int[n+1][2];
        for(int i=n-1; i>=0; i--){
            for(int buy=1; buy>=0; buy--){
                if(buy==0){
                 dp[i][buy] = Math.max(-p[i]+dp[i+1][1-buy], dp[i+1][buy]);
                }else{
                 dp[i][buy] = Math.max(p[i]+dp[i+1][1-buy]-fee, dp[i+1][buy]);
                }
            }
        }
        return dp[0][0];
    }
}
