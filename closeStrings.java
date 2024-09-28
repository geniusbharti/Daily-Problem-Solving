class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        int[] chars1 = new int[26];
        int[] chars2 = new int[26];

        for (char ch : word1.toCharArray()) {
            chars1[ch - 'a']++;
        }

        for (char ch : word2.toCharArray()) {
            chars2[ch - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if ((chars1[i] == 0 && chars2[i] != 0) || (chars1[i] != 0 && chars2[i] == 0)) {
                return false;
            }
        }

        Arrays.sort(chars1);
        Arrays.sort(chars2);

        return Arrays.equals(chars1, chars2);
    }
}
