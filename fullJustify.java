class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans_in_strings = new ArrayList<>();
        int total_words_len =0, spaces = -1;
        List<String> words_list = new ArrayList<>();
         

        for(int i=0; i<words.length; i++){
            total_words_len += words[i].length();
            spaces++;
            if(total_words_len+spaces<=maxWidth){
                words_list.add(words[i]);
            }else{
                int total_words= total_words_len-words[i].length();
                putWordsInLine(words_list, total_words, maxWidth, ans_in_strings);
                words_list=new ArrayList<>();
                words_list.add(words[i]);
                total_words_len = words[i].length();
                spaces=0;
            }

        }

        //handles last line
        int empty_pos = maxWidth-total_words_len;
        StringBuilder sb = new StringBuilder();
        for(String str: words_list){
            sb.append(str+" ");
            empty_pos--;
        }


        while(empty_pos-->0) sb.append(' ');
        if(sb.length()>maxWidth) sb.deleteCharAt(sb.length()-1);
        ans_in_strings.add(sb.toString());


        return ans_in_strings;

    }

    void putWordsInLine(List<String> words, int total_words, int maxWidth, List<String> ans_in_strings){
        //handles one word in line ->/0 error
        if(words.size()==1) {
            String special = words.get(0);
            while(special.length()<maxWidth){
                special += " ";
            }

            ans_in_strings.add(special);
            return ;
        }

        int all_spaces = maxWidth - total_words;
        int div  =  words.size()-1;
        int even_spaces = all_spaces/div;
        int extra_spaces= all_spaces%div;

        StringBuilder sb = new StringBuilder();

        for(String str: words){
            sb.append(str);
            if(div>0) {
                for(int i=0; i<even_spaces; i++) sb.append(' ');
                if(extra_spaces>0) {
                    sb.append(' ');
                    extra_spaces--;
                }
                div--;
            }
        }

        ans_in_strings.add(sb.toString());

    }
}
