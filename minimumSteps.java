class Solution {
    public long minimumSteps(String s) {
        int i=0, j=0;
        int n = s.length();
        for(; i<n; i++){
            if(s.charAt(i)=='1'){
                break;
            }
        }
        long swaps=0;
        if(i==n) return 0L;

        for(j=i+1; j<n; j++){
            if(s.charAt(j)=='0'){
                swaps+=(j-i);
                i++;
            }
        }

        return swaps;
    }
}
