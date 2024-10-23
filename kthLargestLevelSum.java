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
    public long kthLargestLevelSum(TreeNode root, int k) {
        if(root == null) return -1;
        return getTopK(root, k);
    }

    private long
     getTopK(TreeNode root, int k){
        Queue<TreeNode> q = new ArrayDeque<>();
        PriorityQueue<Long> pq = new PriorityQueue<>();
        q.add(root);
        while(q.isEmpty()==false){
            int size = q.size();
            long levelSum=0L;
            while(size-->0){
                TreeNode node = q.poll();
                levelSum+=node.val;
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
            pq.add(levelSum);
            if(pq.size()>k) pq.poll();
        }

         return (pq.size()<k) ? -1L : pq.peek();
    }
}
