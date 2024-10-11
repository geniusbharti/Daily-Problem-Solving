class Solution {
    class Pair{
        int a;
        int l;
        int c;
        Pair(int a, int l, int c){
            this.a=a;
            this.l=l;
            this.c=c;
        }
    }
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;
        int[][] pairs = new int[n][3];
        for(int i=0; i<n; i++){
            pairs[i] = new int[]{times[i][0], times[i][1], i};
        }
        Arrays.sort(pairs, (a, b)->a[0]-b[0]);
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)->a.l-b.l);
        PriorityQueue<Integer> chairs = new PriorityQueue();

        int c=0;

        for(int i=0; i<n; i++){
            int assign=-1;
            while(!pq.isEmpty() && pq.peek().l <= pairs[i][0]){
                chairs.add(pq.peek().c);
                pq.poll();
            }
            if(chairs.isEmpty()==false) assign=chairs.poll();
            else assign=c++;

            pq.add(new Pair(pairs[i][0], pairs[i][1], assign));

            if(pairs[i][2]==targetFriend) return assign;
        }

        return -1;
    }
}
