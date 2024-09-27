class Solution {
    public String decodeString(String s) {
        StringBuilder ans = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int i=0, n=s.length();
        while(i<n){
            char ch=s.charAt(i);
            if(ch!=']') {
                stack.push(ch);
            }else{
                //main
                StringBuilder sb = new StringBuilder();
                while(!stack.isEmpty() && stack.peek() != '['){
                    sb.insert(0, stack.pop());
                }       

                if(!stack.isEmpty()) stack.pop(); //[

                StringBuilder repeat = new StringBuilder();
                while(!stack.isEmpty() && Character.isDigit(stack.peek())){
                    repeat.insert(0, stack.pop());
                }

                String now = sb.toString().repeat(Integer.parseInt(repeat.toString()));
                for(int k=0; k<now.length(); k++){
                    stack.push(now.charAt(k));
                }
            }
            i++;
        }
        while(!stack.isEmpty()){
            ans.append(stack.peek());
            stack.pop();
        }
        return ans.reverse().toString();
    }
}
