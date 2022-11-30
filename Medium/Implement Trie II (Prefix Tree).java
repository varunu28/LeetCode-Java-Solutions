public class Trie {

    private final TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                curr.children.put(c, new TrieNode());
            }
            curr = curr.children.get(c);
            curr.startingWordCount++;
        }
        curr.completeWordCount++;
    }

    public int countWordsEqualTo(String word) {
        TrieNode endNode = searchWord(word);
        return endNode == null ? 0 : endNode.completeWordCount;
    }

    public int countWordsStartingWith(String prefix) {
        TrieNode endNode = searchWord(prefix);
        return endNode == null ? 0 : endNode.startingWordCount;
    }

    public void erase(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            curr = curr.children.get(c);
            curr.startingWordCount--;
        }
        curr.completeWordCount--;
    }

    private TrieNode searchWord(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                return null;
            }
            curr = curr.children.get(c);
        }
        return curr;
    }

    private static class TrieNode {
        Map<Character, TrieNode> children;
        int completeWordCount;
        int startingWordCount;

        public TrieNode() {
            this.children = new HashMap<>();
            this.completeWordCount = 0;
            this.startingWordCount = 0;
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * int param_2 = obj.countWordsEqualTo(word);
 * int param_3 = obj.countWordsStartingWith(prefix);
 * obj.erase(word);
 */
