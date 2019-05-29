class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode root = buildTrie(words);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                helper(board, i, j, root, result);
            }
        }

        return result;
    }

    private void helper(char[][] board, int i, int j, TrieNode root, List<String> result) {
        if (i < 0 || i >= board.length || j >= board[i].length || j < 0) {
            return;
        }

        char c = board[i][j];
        if (c == '@' || root.next[c - 'a'] == null) {
            return;
        }

        root = root.next[c - 'a'];
        if (root.word != null) {
            result.add(root.word);
            root.word = null;
        }

        // Choose
        board[i][j] = '@';

        // Explore
        helper(board, i + 1, j, root, result);
        helper(board, i, j + 1, root, result);
        helper(board, i, j - 1, root, result);
        helper(board, i - 1, j, root, result);

        // Un-choose
        board[i][j] = c;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode temp =root;
            for (char c : word.toCharArray()) {
                if (temp.next[c - 'a'] == null) {
                    temp.next[c - 'a'] = new TrieNode();
                }

                temp = temp.next[c - 'a'];
            }

            temp.word = word;
        }

        return root;
    }

    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }
}
