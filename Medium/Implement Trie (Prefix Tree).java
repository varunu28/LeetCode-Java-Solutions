class Trie {

    Node trie;
    /** Initialize your data structure here. */
    public Trie() {
        trie = new Node("");
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node curr = trie;
        for(int i=0; i<word.length(); i++) {
            if (!curr.childrens.containsKey(word.charAt(i))) {
                curr.childrens.put(word.charAt(i), new Node(word.substring(0, i+1)));
            }

            curr = curr.childrens.get(word.charAt(i));

            if (i == word.length() - 1) {
                curr.isWord = true;
            }
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node curr = trie;
        for (int i=0; i<word.length(); i++) {
            if (curr.childrens.containsKey(word.charAt(i))) {
                curr = curr.childrens.get(word.charAt(i));
            }
            else {
                return false;
            }
        }

        return curr.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node curr = trie;

        for (int i=0; i<prefix.length(); i++) {
            if (curr.childrens.containsKey(prefix.charAt(i))) {
                curr = curr.childrens.get(prefix.charAt(i));
            }
            else {
                return false;
            }
        }

        return true;
    }

    private static final class Node {
        String prefix;
        Map<Character, Node> childrens;
        boolean isWord;

        public Node(String prefix) {
            this.prefix = prefix;
            this.childrens = new HashMap<>();
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
