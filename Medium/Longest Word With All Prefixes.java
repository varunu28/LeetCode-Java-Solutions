class Solution {
    public String longestWord(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            root.insert(word);
        }
        String longestValidWord = "";
        for (String word : words) {
            if (root.hasAllPrefixes(word)) {
                if (word.length() > longestValidWord.length() || 
                    (word.length() == longestValidWord.length() && word.compareTo(longestValidWord) < 0)) {
                    longestValidWord = word;
                }
            }
        }
        return longestValidWord;
    }

    static class TrieNode {
        private final Map<Character, TrieNode> children;
        private boolean isWord;

        public TrieNode() {
            this.children = new HashMap<>();
        }

        public void insert(String word) {
            TrieNode curr = this;
            for (char c : word.toCharArray()) {
                curr = curr.getOrCreateChild(c);
            }
            curr.isWord = true;
        }

        public boolean hasAllPrefixes(String word) {
            TrieNode curr = this;
            for (char c : word.toCharArray()) {
                TrieNode child = curr.children.getOrDefault(c, null);
                if (child == null) {
                    return false;
                }       
                if (!child.isWord) {
                    return false;
                }
                curr = child;
            }
            return true;
        }

        private TrieNode getOrCreateChild(char c) {
            if (children.containsKey(c)) {
                return children.get(c);
            }
            TrieNode node = new TrieNode();
            children.put(c, node);
            return node;
        }
    }
}
