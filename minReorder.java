class Solution {
    public int minReorder(int n, int[][] connections) {
         List<List<Integer>> adj = new ArrayList();
         for(int i=0; i<n; i++) adj.add(new ArrayList());

         for(int[] e: connections){
            int a = e[0], b = e[1];
            adj.get(a).add(b);
            adj.get(b).add(-a);  //to indicate artificial edge
         }

         return dfs(0, -1, adj);
    }

    int dfs(int src, int par, List<List<Integer>> adj){
        int change=0;
        for(int nbr: adj.get(src)){
            if(Math.abs(nbr)!=par) 
            change += ((nbr > 0) ? 1 : 0) + dfs(Math.abs(nbr), src, adj);
        }
        return change;
    }
}
