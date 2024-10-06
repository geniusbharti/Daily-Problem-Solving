class Solution {
    public int findCircleNum(int[][] isConnected) { 
        int n=isConnected.length;
        int[] vis=new int[n];
        int c=0;
        for(int r=0; r<n; r++){
            if(vis[r]==0) {
               c++;
               dfs(r, vis, isConnected, n);
            }
        }
        return c;
    }
    void dfs(int src, int[] vis, int[][] isConnected, int n){
        //mark vis
        vis[src]=1;
        //vis ngbrs
        for(int i=0; i<n; i++){
            if(isConnected[src][i]==1){
            if(vis[i]==0) dfs(i, vis, isConnected, n);
            }
        }
    }
}
