class Solution {
  public List<String> findWords(char[][] board, String[] words) {
    List<String> result = new ArrayList<>();
    TrieNode root = buildTrie(words);
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        dfs(board, i, j, result, root);
      }
    }
    return result;
  }
  
  private TrieNode buildTrie(String[] words) {
    TrieNode root = new TrieNode();
    for (String word : words) {
      TrieNode temp = root;
      for (char c : word.toCharArray()) {
        if (temp.children[c - 'a'] == null) {
          temp.children[c - 'a'] = new TrieNode();
        }
        temp = temp.children[c - 'a'];
     }
       temp.word = word;
    }
    return root;
  }

  private void dfs(char[][] board, int i, int j, List<String> result, TrieNode root) {
    char c = board[i][j];
    if (c == '#' || root.children[c - 'a'] == null) {
      return;
    }
    root = root.children[c - 'a'];
    if (root.word != null) {
      result.add(root.word);
      root.word = null;
    }
    board[i][j] = '#';
    triggerDfsIfValid(board, i, j, result, root);
    board[i][j] = c;
  }
  
  private void triggerDfsIfValid(char[][] board, int i, int j, List<String> result, TrieNode root) {
    if (i > 0) {
      dfs(board, i - 1, j, result, root);
    }
    if (j > 0) {
      dfs(board, i, j - 1, result, root);
    }
    if (i < board.length - 1) {
      dfs(board, i + 1, j, result, root);
    }
    if (j < board[0].length - 1) {
      dfs(board, i, j + 1, result, root);
    }
  }
  
  class TrieNode {
    TrieNode[] children = new TrieNode[26];
    String word;
  }
}
