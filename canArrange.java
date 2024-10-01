class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] f = new int[k];
        for(int i=0;i<arr.length; i++){
            int r = arr[i]%k;

            if(r < 0) r = r+k; //a way to make it positive within k range

            f[r]++;
        }

        //now at index =0 it should have even number of fq. means evn nums to form pairs
        // if num is completely divisibl 
        //as [0-k-1] is range when a num / k

        if(f[0]%2 != 0) return false;

        for(int i=1; i<=k/2; i++){
            if(k%2 == 0 && i==k/2 && f[k/2]%2 != 0){ //required only when n is not even
                return false;
            }else{
                if(f[i] != f[k-i]) return false;
            }
        }

        return true;
    }
}
