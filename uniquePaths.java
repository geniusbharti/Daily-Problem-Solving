class Solution {
    int[][] mn = new int[101][101];
    
    public int uniquePaths(int m, int n) {
        for(int[] r: mn) Arrays.fill(r, -1);
        return helper(m-1, n-1);
    }
    private int helper(int m , int n){
        if(m==0 && n==0) return 1;

        if(m<0 || n<0) return 0;

        if(mn[m][n]!=-1) return mn[m][n];
        return mn[m][n] = helper(m-1, n) + helper(m, n-1);
    }
}
