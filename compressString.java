class Solution {
    public int compress(char[] chars) {
        int i=0;
        int idx=0;

        while(i<chars.length){
            char ch = chars[i];
            int c=0;

            while(i<chars.length && chars[i]==ch){
                c++;
                i++;
            }

            chars[idx++]=ch;
            if(c>1){
                String cStr = String.valueOf(c);
                for(char v: cStr.toCharArray()) chars[idx++]=v;
            }

        }

        return idx;
    }
}
