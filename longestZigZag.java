class Solution {
    class Pair {
        int len;
        int max;
        
        Pair(int len, int max) {
            this.len = len;
            this.max = max;
        }
    }
    
    public int longestZigZag(TreeNode root) {
        if (root == null) return 0;
        Pair leftPath = getMaxLen(root.left, false);
        Pair rightPath = getMaxLen(root.right, true);
        return Math.max(leftPath.max, rightPath.max);
    }
    
    private Pair getMaxLen(TreeNode root, boolean cameFromRight) {
        if (root == null) {
            return new Pair(0, 0);
        }
        
        Pair leftPath = getMaxLen(root.left, false);
        Pair rightPath = getMaxLen(root.right, true);

        int currLen = 0;
        int maxLen = 0;

        if (cameFromRight) {
            currLen = leftPath.len + 1;
            maxLen = Math.max(currLen, leftPath.max);
        } else {
            currLen = rightPath.len + 1;
            maxLen = Math.max(currLen, rightPath.max);
        }

        maxLen = Math.max(maxLen, Math.max(leftPath.max, rightPath.max));
        return new Pair(currLen, maxLen);
    }
}
