class Solution {
    int[][] dp;

    public int backtrack(int[] nums, int i, int currentOR, int maxOR) {
        // Base case: if we've considered all elements
        if (i == nums.length) {
            // If current OR equals maxOR, count it as a valid subset
            return currentOR == maxOR ? 1 : 0;
        }

        // If we already computed this state, return the stored result
        if (dp[i][currentOR] != -1) return dp[i][currentOR];

        // Case 1: Include nums[i] in the current subset (OR operation)
        int include = backtrack(nums, i + 1, currentOR | nums[i], maxOR);

        // Case 2: Exclude nums[i] from the current subset
        int exclude = backtrack(nums, i + 1, currentOR, maxOR);

        // Store the total count of valid subsets from both choices
        dp[i][currentOR] = include + exclude;

        return dp[i][currentOR];
    }

    public int countMaxOrSubsets(int[] nums) {
        int maxOR = 0;

        // Step 1: Compute the maximum OR across all elements
        for (int num : nums) {
            maxOR |= num;
        }

        // Initialize dp array with -1 (to denote unvisited states)
        dp = new int[nums.length + 1][maxOR + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // Step 2: Use backtracking with memoization to count subsets
        return backtrack(nums, 0, 0, maxOR);
    }
}
