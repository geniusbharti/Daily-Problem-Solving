class Solution {
    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        Arrays.sort(points, (a, b)->Integer.compare(a[0], b[0]));
        int arrows=1;
        long[] balloonDia = new long[2];
        balloonDia[0] = points[0][0];
        balloonDia[1] = points[0][1];
        for(int i=1; i<n; i++){
            long start = points[i][0];
            long end = points[i][1];
            if(balloonDia[1] < start){
                arrows++;
                balloonDia[0]=start;
                balloonDia[1]=end;
            }else{
                balloonDia[1] = Math.min(balloonDia[1], end);
            }
        }
        return arrows;
    }
}
