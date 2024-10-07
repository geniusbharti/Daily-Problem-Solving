class Solution {
    public int minLength(String s) {
        Stack<Character> stack = new Stack<>();
        int i=0; int n=s.length();
        while(i<n){
            char ch = s.charAt(i);
            if(!stack.isEmpty() && ((stack.peek()=='A' && ch == 'B') || (stack.peek()=='C' && ch == 'D'))) {
                stack.pop();
            }else{
                stack.push(ch);
            }
            i++;
        }
        return stack.size();
    }
}
