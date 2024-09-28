class Solution {
    public String predictPartyVictory(String senate) {
        int n=senate.length();
        Queue<Integer> r, d;
        r=new ArrayDeque();
        d=new ArrayDeque();
        for(int i=0; i<n; i++){
            char ch = senate.charAt(i);
            if(ch == 'D') d.add(i);
            else r.add(i);
        }
        while(r.size()>0 && d.size()>0){
            if(r.peek()<d.peek()) r.add(n++);
            else d.add(n++);
            r.remove();
            d.remove();
        }
        return (d.size()==0) ? "Radiant" : "Dire";
    }
}
