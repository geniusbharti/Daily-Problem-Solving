class Solution {
    public int tribonacci(int n) {
        if(n==0) return 0;

        if(n==1 || n==2) return 1;
        int[] store = new int[n+1];
        for(int i=0; i<=n; i++){
            if(i==0 || i==1) store[i]=i;
            else if(i==2) store[i]=1;
            else store[i]=store[i-1]+store[i-2]+store[i-3];
        }
        return store[n];
    }
}
