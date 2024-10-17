class Solution {
    class Pair{
        char ch;
        int f;
        Pair(int f, char ch) {this.f = f; this.ch=ch;}
    }
    public String strWithout3a3b(int a, int b) {
        StringBuilder sb = new StringBuilder();
        Pair ap = null, bp = null, curr=null, other=null;
        ap = new Pair(a, 'a');
        bp = new Pair(b, 'b');
        while(ap.f!=0 || bp.f!=0){
            if(ap.f>bp.f) curr = ap;
            else curr = bp;

            if(sb.length()==0 || sb.length()<2 || (sb.charAt(sb.length()-1)!=curr.ch) || (sb.charAt(sb.length()-2)!=curr.ch)){
                sb.append(curr.ch);
                curr.f--;
            }else{
                other =  (curr == ap) ? bp : ap;
                sb.append(other.ch);
                other.f--;
            }
        }
        return sb.toString();
    }
}
