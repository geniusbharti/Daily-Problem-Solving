class Solution {
    int[][] dir = {{0,1}, {1, 0}, {0, -1}, {-1,0}};
    class Pair{
        int i;
        int j;
        int d;
        Pair(int i, int j, int d){
            this.i=i;
            this.j=j;
            this.d=d;
        }
    }
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        Queue<Pair> q = new ArrayDeque();
        // int[][] vis = new int[m][n];
        int er = entrance[0], ec = entrance[1];
        maze[er][ec] = '+';
        q.add(new Pair(er, ec, 0));

        while(q.isEmpty()==false){
            Pair rem = q.poll();
            int row = rem.i, col = rem.j, dis = rem.d;
            if(row!=er || col!=ec){
                if(row==0 || row==m-1 || col==0 || col==n-1) return dis;
            }
            for(int d=0; d<4; d++){
                int nr = row+dir[d][0];
                int nc = col+dir[d][1];
                if(nr>=0 && nc>=0 && nr<m && nc<n && maze[nr][nc] == '.'){
                    q.add(new Pair(nr, nc, dis+1));
                    maze[nr][nc]='+';
                }
            }
        }
        return -1;
    }
}
