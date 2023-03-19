class WordDictionary {

    private final TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                curr.children.put(c, new TrieNode());
            }
            curr = curr.children.get(c);
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }

    private boolean searchHelper(String word, int idx, TrieNode node) {
        if (idx == word.length()) {
            return node.isWord;
        }
        if (node.children.containsKey(word.charAt(idx))) {
            return searchHelper(word, idx + 1, node.children.get(word.charAt(idx)));
        }
        if (word.charAt(idx) == '.') {
            for (TrieNode child : node.children.values()) {
                if (searchHelper(word, idx + 1, child)) {
                    return true;
                }
            }
        }
        return false;
    }


    static class TrieNode {
        private final Map<Character, TrieNode> children;
        private boolean isWord;

        public TrieNode() {
            this.children = new HashMap<>();
            this.isWord = false;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
