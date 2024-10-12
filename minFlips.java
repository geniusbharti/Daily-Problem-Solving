class Solution {
    public int minFlips(int a, int b, int c) {
        int cc=0;
        for(int i=31; i>=0; i--){
            int bita = (a>>i)&1;
            int bitb = (b>>i)&1;
            int bitc = (c>>i)&1;
            if((bita | bitb) != bitc){
                if(bita==1 && bitb==1) cc+=2;
                else cc+=1;
            }
        }
        return cc;
    }
}
