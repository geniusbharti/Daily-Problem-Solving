class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        int[] vis=new int[n];
        int c=0;
        for(int r=0; r<n; r++){
            if(vis[r]==0) {
               c++;
               if(c>1) return false;
               dfs(r, vis, rooms);
            }
        }
        return true;
    }
    void dfs(int src, int[] vis, List<List<Integer>> rooms){
        //mark vis
        vis[src]=1;
        //vis ngbrs
        for(int e: rooms.get(src)){
            if(vis[e]==0) dfs(e, vis, rooms);
        }
    }
}
