class SmallestInfiniteSet {
    PriorityQueue<Integer> pq;
    Set<Integer> set;
    public SmallestInfiniteSet() {
        pq =  new PriorityQueue();
        set = new HashSet();
        pq.add(1);
    }
    
    public int popSmallest() {
        int pop = pq.peek();
        set.add(pop);
        pq.poll();
        if(pq.isEmpty()) pq.add(pop+1);
        return pop;
    }
    
    public void addBack(int num) {
        if(set.contains(num)) pq.add(num);
        set.remove(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
