class Solution {
    public int[] countBits(int n) {
        int[] dp = new int[n+1];
        for(int i=1; i<=n; i++){
             dp[i] = (i%2==0) ? dp[i>>1] : dp[i>>1]+1;
        }
        return dp;
    }
}
