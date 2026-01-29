class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        TrieNode root = new TrieNode();
        for (String word : wordDict) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                if (!curr.children.containsKey(c)) {
                    curr.children.put(c, new TrieNode());
                }
                curr = curr.children.get(c);
            }
            curr.isWord = true;
        }
        boolean[] isWord = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            // If it is either first character or the previous character was ending of a word
            if (i == 0 || isWord[i - 1]) {
                TrieNode curr = root;
                for (int j = i; j < s.length(); j++) {
                    char c = s.charAt(j);
                    if (!curr.children.containsKey(c)) {
                        break;
                    }
                    curr = curr.children.get(c);
                    if (curr.isWord) {
                        isWord[j] = true;
                    }
                }
            }
        }
        return isWord[s.length() - 1];
    }

    class TrieNode {
        boolean isWord;
        Map<Character, TrieNode> children;

        public TrieNode() {
            this.children = new HashMap<>();
        }
    }
}
