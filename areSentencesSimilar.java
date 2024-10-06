class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        if(sentence1.equals(sentence2)) return true;

        String[] a = sentence1.split(" ");
        String[] b = sentence2.split(" ");

        int i=0;
        int m=a.length;
        int n=b.length;
        if(m > n) {
            return areSentencesSimilar(sentence2, sentence1);
        }
        int j = m-1;
        int j2= n-1;
        while(i<m && a[i].equals(b[i])){
            i++;
        }

        while(j>=0 && a[j].equals(b[j2])){
                j--;
                j2--;
        }
        return  i>j ? true : false;
    }
}
