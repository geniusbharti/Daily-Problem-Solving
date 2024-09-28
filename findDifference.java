class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> setans = new HashSet<>();
        for(int i=0; i<nums2.length;i++){
           set.add(nums2[i]);
        }
        for(int i=0; i<nums1.length; i++) {
            if(set.contains(nums1[i])==false) setans.add(nums1[i]);
        }
        List<List<Integer>> r=new ArrayList();
        r.add(new ArrayList<>(setans));
        
        setans=new  HashSet<>();
        set=new HashSet<>();
       
        for(int i=0; i<nums1.length; i++) set.add(nums1[i]);
        
        for(int i=0; i<nums2.length; i++) {
            if(set.contains(nums2[i])==false) setans.add(nums2[i]);
        } 
        r.add(new ArrayList<>(setans));
       
        return r;
    }
}
