/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int goodNodes(TreeNode root) {
        if(root == null) return 0;
        //check one more test case when only root is there
        int[] count = new int[1];
        goodnodes(root, root, count);
        return count[0];
    }

    private void goodnodes(TreeNode root, TreeNode max, int[] count){
        if(root == null) return;

        if(root.val >= max.val) {
            max = root;
            count[0]++;
        }

        goodnodes(root.left, max, count);
        goodnodes(root.right, max, count);
    }
}
