class Solution {
    public int largestAltitude(int[] gain) {
        int maxPoint = 0;
        int currPoint = 0;
        for(int i=0; i<gain.length; i++){
            currPoint = gain[i] + currPoint;
            if(currPoint > maxPoint) maxPoint = currPoint;
        }

        return maxPoint;
    }
}
