class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        if (arr == null || arr.length == 0) {
            return true;
        }

        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> unique = new HashSet<>();

        for (int val : arr) {
            map.put(val, map.getOrDefault(val, 0) + 1);
            
        }

        for (int val : map.values()) {
            if (unique.contains(val)) {
                return false;
            } else {
                unique.add(val);
            }
        }
        return true;
}
}
