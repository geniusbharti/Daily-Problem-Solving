class Solution {
    public int equalPairs(int[][] grid) {
        HashMap<String, Integer> map =new HashMap<>();
        int m = grid.length;
        int n = grid[0].length;
        for(int c=0; c<n; c++){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<m; i++){
                sb.append(grid[i][c]+",");
            }
            map.put(sb.toString(), map.getOrDefault(sb.toString(),0)+1);
        }
        int pairs=0;
        for(int r=0; r<m; r++){
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<n; j++){
                sb.append(grid[r][j]+",");
            }
            pairs += map.getOrDefault(sb.toString(), 0);
        }
        return pairs;
    }
}
