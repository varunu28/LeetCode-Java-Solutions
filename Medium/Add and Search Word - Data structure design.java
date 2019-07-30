class WordDictionary {

    /** Initialize your data structure here. */
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        addToTrie(word);
    }
    
    private void addToTrie(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            
            curr = curr.children[c - 'a'];
            
            if (i == word.length() - 1) {
                curr.isWord = true;
            }
        }
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        TrieNode curr = root;
        boolean[] ans = {false};
        helper(word, 0, curr, ans);
        return ans[0];
    }
    
    private void helper(String word, int idx, TrieNode curr, boolean[] ans) {
        if (curr == null) {
            return;
        }
        
        if (idx == word.length()) {
            if (curr.isWord) {
                ans[0] = true;
            }
            return;
        }
        
        if (word.charAt(idx) != '.') {
            helper(word, idx + 1, curr.children[word.charAt(idx) - 'a'], ans);
        }
        else {
            for (int i = 0; i < 26; i++) {
                if (curr.children[i] != null) {
                    helper(word, idx + 1, curr.children[i], ans);
                }
            }
        }
    }
}

class TrieNode {
    TrieNode[] children;
    boolean isWord;
        
    public TrieNode() {
        children = new TrieNode[26];
        isWord = false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
