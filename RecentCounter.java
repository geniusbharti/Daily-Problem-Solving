class RecentCounter {
    Queue<Integer> q;
    public RecentCounter() {
        q=new ArrayDeque<>();
    }
    
    public int ping(int t) {
        q.add(t);
        int first = t-3000;
        while(q.size()>1 && q.peek()<first){
            q.remove();
        }
        return q.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
