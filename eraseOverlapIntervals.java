class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b)->a[1]-b[1]);

        int countOverlappingIntervals=0;
        int prevEnd = intervals[0][1];

        for(int i=1; i<n; i++){
            if(intervals[i][0]<prevEnd){
                countOverlappingIntervals++;
            }else{
                prevEnd = intervals[i][1];
            }
        }

        return countOverlappingIntervals;
    }
}
