class StreamChecker {
    String[] words;
    TrieNode root;
    StringBuilder sb = new StringBuilder();
    public StreamChecker(String[] words) {
        this.words = words;
        root = new TrieNode('#');
        treeify(words);
    }

    private void treeify (String[] words) {
        for (String word : words) {
            TrieNode curr = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                char c = word.charAt(i);
                if (curr.childrens[c - 'a'] == null) {
                    curr.childrens[c - 'a'] = new TrieNode(c);
                }

                curr = curr.childrens[c - 'a'];

                if (i == 0) {
                    curr.isWord = true;
                }
            }
        }
    }

    public boolean query(char letter) {
        sb.append(letter);
        TrieNode curr = root;
        for (int i = sb.length() - 1; i >= 0; i--) {
            if (curr.childrens[sb.charAt(i) - 'a'] != null) {
                curr = curr.childrens[sb.charAt(i) - 'a'];
            }
            else {
                break;
            }

            if (curr.isWord) {
                return true;
            }
        }

        return false;
    }

    class TrieNode {
        char key;
        TrieNode[] childrens;
        boolean isWord;

        public TrieNode (char key) {
            this.key = key;
            this.childrens = new TrieNode[26];
            isWord = false;
        }
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
