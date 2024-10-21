class Solution {
    public int maximumSwap(int num) {
        StringBuilder sb = new StringBuilder(String.valueOf(num));
   
        for(int i=0; i<sb.length(); i++){
            int max=-1, in=-1;
            for(int j=i+1; j<sb.length(); j++){
                if(sb.charAt(j)-'0' >= max){
                    max = sb.charAt(j)-'0';
                    in=j;
                }
            }

            if(max>sb.charAt(i)-'0'){
                sb.setCharAt(in, sb.charAt(i));
                sb.setCharAt(i, (char)(max+'0'));
                break;
            }

        }
        
        return Integer.parseInt(sb.toString());
    }
}
