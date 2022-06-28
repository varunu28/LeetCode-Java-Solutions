class Solution {
  
  private final int[][] DIRS = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
  
  public List<String> findWords(char[][] board, String[] words) {
    TrieNode root = new TrieNode();
    for (String word : words) {
      TrieNode node = root;
      for (Character letter : word.toCharArray()) {
        if (node.children.containsKey(letter)) {
          node = node.children.get(letter);
        } else {
          TrieNode newNode = new TrieNode();
          node.children.put(letter, newNode);
          node = newNode;
        }
      }
      node.word = word;
    }
    List<String> result = new ArrayList<>();
    for (int row = 0; row < board.length; ++row) {
      for (int col = 0; col < board[row].length; ++col) {
        if (root.children.containsKey(board[row][col])) {
          backtracking(row, col, root, result, board);
        }
      }
    }
    return result;
  }
  
  private void backtracking(int row, int col, TrieNode parent, List<String> result, char[][] board) {
    char letter = board[row][col];
    TrieNode currNode = parent.children.get(letter);
    if (currNode.word != null) {
      result.add(currNode.word);
      currNode.word = null;
    }
    board[row][col] = '#';
    for (int[] dir : DIRS) {
      int newRow = row + dir[0];
      int newCol = col + dir[1];
      if (newRow < 0 || newRow >= board.length || newCol < 0 || newCol >= board[0].length) {
        continue;
      }
      if (currNode.children.containsKey(board[newRow][newCol])) {
        backtracking(newRow, newCol, currNode, result, board);
      }
    }
    board[row][col] = letter;
    if (currNode.children.isEmpty()) {
      parent.children.remove(letter);
    }
  }
  
  private class TrieNode {
    Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    String word = null;
    public TrieNode() {}
  }
}
