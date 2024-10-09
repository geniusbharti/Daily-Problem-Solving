class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n=spells.length;
        int m=potions.length;
        int[] ans = new int[n];
        Arrays.sort(potions);
        for(int i=0; i<n; i++){
            ans[i]=getPairsWithPotions(spells[i], potions, success);
        }
        return ans;
    }
    private int getPairsWithPotions(int s, int[] p, long tar){
        int i=0, j=p.length-1, idx=-1;
        while(i<=j){
            int mid=i+(j-i)/2;
            if((long)s*p[mid] >= tar){
                idx=mid;
                j=mid-1;
            }else{
                i=mid+1;
            }
        }
        return (idx==-1) ? 0 : p.length-idx;
    }
}
