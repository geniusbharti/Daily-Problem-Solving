class Solution {
    public int[] arrayRankTransform(int[] a) {
        int n=a.length;
        int[] copy = Arrays.copyOf(a, n);
        Arrays.sort(copy);
        HashMap<Integer, Integer> mpp = new HashMap<>();
        int r=1; if(n>=1) mpp.put(copy[0], 1);
        for(int i=1; i<n; i++){
            if(copy[i] > copy[i-1]){
                r++;
                mpp.put(copy[i], r);
            }
        }
        for(int i=0; i<n; i++){
            a[i] = mpp.get(a[i]);
        }
        return a;
    }
}
