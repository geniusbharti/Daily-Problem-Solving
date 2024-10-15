class TrieNode{
    TrieNode[] child;
    boolean isEndOfWord;

    public TrieNode() {
        child = new TrieNode[26];
        isEndOfWord = false;
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for(int i=0; i<word.length(); i++){
            if(curr.child[word.charAt(i)-'a'] == null){
                TrieNode nnode = new TrieNode();
                curr.child[word.charAt(i)-'a'] = nnode;
            }
            curr = curr.child[word.charAt(i)-'a'];
        }

        curr.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        for(int i=0; i<word.length(); i++){
            if(curr.child[word.charAt(i)-'a'] == null) return false;
            curr = curr.child[word.charAt(i)-'a'];
        }

        return curr.isEndOfWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i=0; i<prefix.length(); i++){
            if(curr.child[prefix.charAt(i)-'a'] == null) return false;
            curr = curr.child[prefix.charAt(i)-'a'];
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
