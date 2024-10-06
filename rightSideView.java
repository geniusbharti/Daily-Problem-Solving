class Solution {
    class Pair{
        TreeNode node;
        int level;
        Pair(TreeNode node, int level){
            this.node = node;
            this.level = level;
        }
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans=new ArrayList();
        if(root == null) return ans;
        
        HashMap<Integer, TreeNode> mpp = new HashMap<>();
        Queue<Pair> q = new ArrayDeque<>();
        int max = 0;
        q.add(new Pair(root, 0));
        mpp.put(0, root);
        while(!q.isEmpty()){
            Pair p = q.remove();
            mpp.put(p.level, p.node);

            max = Math.max(max, p.level);

            if(p.node.left != null){
            q.add(new Pair(p.node.left, p.level+1));
            }

            if(p.node.right != null){
                q.add(new Pair(p.node.right, p.level+1));
            }
        }

        
        for(int i=0; i<=max; i++){
            ans.add(mpp.get(i).val);
        }
        return ans;
    }
}
