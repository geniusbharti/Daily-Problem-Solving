class CustomStack {
    ArrayList<Integer> stack;    
    int maxSize, currSize=0;
    public CustomStack(int maxSize) {
        stack=new ArrayList<>();
        this.maxSize = maxSize;
    }
    
    public void push(int x) {
        if(currSize == maxSize) return;

        stack.add(x);
        currSize++;
    }
    
    public int pop() {
        if(stack.size()==0) return -1;

        currSize--;
        return stack.remove(currSize);
    }
    
    public void increment(int k, int val) {
        k = Math.min(k, stack.size());  // Ensure k doesn't exceed the size of the stack
        for (int i = 0; i < k; i++) {
            stack.set(i, stack.get(i) + val);  // Increment each of the first k elements
        }
    }

}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
