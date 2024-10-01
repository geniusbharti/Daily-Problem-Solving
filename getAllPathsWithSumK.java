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
    public int pathSum(TreeNode root, int k) {
        int[] paths=new int[1];
        HashMap<Long, Integer> mpp=new HashMap<>();
        mpp.put(0L, 1);
        getAllPathsWithSumK(root, 0L, mpp, k, paths);
        return paths[0];
    }
    private void getAllPathsWithSumK(TreeNode root, Long sum, HashMap<Long, Integer> mpp, int k, int[] paths){
        if(root == null) return;

        sum += root.val;

        if(mpp.containsKey(sum-k)) paths[0]+=mpp.get(sum-k);

        mpp.put(sum, mpp.getOrDefault(sum,0)+1);

        getAllPathsWithSumK(root.left, sum, mpp, k, paths);
        getAllPathsWithSumK(root.right, sum, mpp, k, paths);

        mpp.put(sum, mpp.getOrDefault(sum,0)-1);
    }
}
