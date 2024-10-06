class Solution {
    int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q=new ArrayDeque();
        int fresh = 0;
        int m =grid.length;
        int n = grid[0].length;
        for(int i=0;i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==2) q.add(new int[]{i, j});
                else if(grid[i][j]==1) fresh++;
            }
        }
        if(fresh==0) return 0;
        int time=0;
        while(!q.isEmpty()){
            int sz=q.size();
            while(sz-->0){
                int[] rem=q.poll();
                int i=rem[0], j=rem[1];
                for(int d=0;d<4; d++){
                    int ni=i+dir[d][0];
                    int nj=j+dir[d][1];
                    if(ni>=0 && nj>=0 && ni<m && nj<n && grid[ni][nj]==1){
                        q.add(new int[]{ni, nj});
                        grid[ni][nj]=2;
                        fresh--;
                    }
                }
            }
            time++;

        }
        return (fresh==0) ? time-1 :-1;
    }
}
