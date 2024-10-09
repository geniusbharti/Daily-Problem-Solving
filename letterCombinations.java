class Solution {
    public List<String> letterCombinations(String digits) {
        // 2 | 36
        List<String> list = new ArrayList();
        if(digits.length() == 0) return list;
        String[] chars = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        getLetterCombinations(digits, chars, new StringBuilder(), list);
        return list;
    }

    void getLetterCombinations(String digits, String[] chars, StringBuilder curr, List<String> list){
        //base case
        if(digits.length() == 0){
            list.add(curr.toString());
            return;
        }

        //recurrence case
        int idx = digits.charAt(0) - '0';
        String charsAtZeroth = chars[idx];
        for(char ch: charsAtZeroth.toCharArray()){
            curr.append(ch);
            getLetterCombinations(digits.substring(1), chars, curr, list);  
            curr.deleteCharAt(curr.length()-1);
        }
    }
}
