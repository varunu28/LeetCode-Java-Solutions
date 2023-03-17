import java.util.Optional;

class Trie {

    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
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
        Optional<TrieNode> node = searchHelper(word);
        return node.isPresent() && node.get().isWord;
    }

    public boolean startsWith(String prefix) {
        Optional<TrieNode> node = searchHelper(prefix);
        return node.isPresent();
    }
    
    public Optional<TrieNode> searchHelper(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                return Optional.empty();
            }
            curr = curr.children.get(c);
        }
        return Optional.of(curr);
    }

    private static class TrieNode {
        
        private final Map<Character, TrieNode> children;
        private boolean isWord;

        private TrieNode() {
            this.children = new HashMap<>();
            this.isWord = false;
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
