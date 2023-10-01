import java.util.Optional;


class Trie {

    private final Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                curr.children.put(c, new Node());
            }
            curr = curr.children.get(c);
            curr.startingWordCount++;
        }
        curr.endingWordCount++;
    }

    public int countWordsEqualTo(String word) {
        Optional<Node> curr = search(word);
        return curr.map(node -> node.endingWordCount).orElse(0);
    }

    public int countWordsStartingWith(String prefix) {
        Optional<Node> curr = search(prefix);
        return curr.map(node -> node.startingWordCount).orElse(0);
    }

    public void erase(String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            curr = curr.children.get(c);
            curr.startingWordCount--;
        }
        curr.endingWordCount--;
    }

    private Optional<Node> search(String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                return Optional.empty();
            }
            curr = curr.children.get(c);
        }
        return Optional.of(curr);
    }

    private static class Node {

        private int startingWordCount;
        private int endingWordCount;

        private final Map<Character, Node> children;

        public Node() {
            this.startingWordCount = 0;
            this.endingWordCount = 0;
            this.children = new HashMap<>();
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
