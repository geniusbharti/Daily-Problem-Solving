class Solution {
    public int[] asteroidCollision(int[] a) {
        Stack<Integer> stack = new Stack<>();
        int i=0;
        int n=a.length;
        while(i<n){
            if(stack.isEmpty() || a[i]>=0) {
                stack.push(a[i]);
                i++;
                continue;
            }
            while(!stack.isEmpty() && stack.peek()>0 && stack.peek()<Math.abs(a[i])){
                    stack.pop();
                }

            if(!stack.isEmpty() && Math.abs(a[i])==stack.peek()){
                stack.pop();
            }else if(stack.isEmpty() || stack.peek()<0){
                stack.push(a[i]);
            }
            i++;
        }

        int[] ans=new int[stack.size()];
        i=stack.size()-1;
        while(stack.isEmpty()==false){
            ans[i--]=stack.pop();
        }
        return ans;
    }
}
