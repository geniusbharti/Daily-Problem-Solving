class Solution {
    public int minSwaps(String s) {
        //  Stack<Character> stack  = new Stack<>();
        int stack_size=0;
         int i=0; int n=s.length();
         while(i<n){
            if(stack_size!=0 && s.charAt(i)==']') stack_size--;
            else stack_size++;
            i++;
         }
         return (stack_size==n) ? 2 : stack_size/2;
    }
}
