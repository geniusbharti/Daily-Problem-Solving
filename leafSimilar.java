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
    List<Integer> tree1Leaves=new ArrayList();
    List<Integer> tree2Leaves=new ArrayList();
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if(root1 == null || root2 == null) return false;

        getLeavesFor(root1, tree1Leaves);
        getLeavesFor(root2, tree2Leaves);

        return tree1Leaves.equals(tree2Leaves);
    }

    void getLeavesFor(TreeNode node, List<Integer> list){
        if(node==null) return;

        if(node.left == null
          && node.right == null) list.add(node.val);

        getLeavesFor(node.left, list);
        getLeavesFor(node.right, list);
    }
}
