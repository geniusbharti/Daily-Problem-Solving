class Solution {
    public String reverseWords(String s) {
        int n = s.length();
        s=reverse(s, 0, n-1); //ASSIGN BACK TO S
        // System.out.print(s);
        StringBuilder ans = new StringBuilder();
        int i=0;
        while(i<n){
            if(s.charAt(i)==' ') {i++;continue;}
            int j = i;
            StringBuilder str = new StringBuilder();
            while(j<n && s.charAt(j) != ' ') {
                str.append(s.charAt(j));
                j++;
            }
            
            ans.append(reverse(str.toString(), 0, str.length()-1));
            if(j<n) ans.append(" ");
            i=j;
            i++;
        }

        return ans.toString().trim(); //ENDING SPACE
        // return "";
        
    }

    String reverse(String str, int i, int j){
        StringBuilder ss = new StringBuilder(str);
        while(i<j){
            char s = ss.charAt(i);
            ss.setCharAt(i, ss.charAt(j));
            ss.setCharAt(j, s);
            i++;
            j--;
        }
        return ss.toString();
    }
}
