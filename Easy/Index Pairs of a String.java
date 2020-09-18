class Solution {
  public int[][] indexPairs(String text, String[] words) {
    TrieNode root = new TrieNode('-');
    for (String word : words) {
      addWord(word, root);
    }
    List<int[]> list = new ArrayList<>();
    for (int i = 0; i < text.length(); i++) {
      int j = i;
      TrieNode curr = root;
      while (j < text.length() && curr.childrens.containsKey(text.charAt(j))) {
        curr = curr.childrens.get(text.charAt(j));
        if (curr.isWord) {
          list.add(new int[]{i, j});
        }
        j++;
      }
    }
    int[][] ans = new int[list.size()][2];
    for (int i = 0; i < list.size(); i++) {
      ans[i] = list.get(i);
    }
    return ans;
  }
  
  private void addWord(String s, TrieNode root) {
    for (int i = 0; i < s.length(); i++) {
      if (!root.childrens.containsKey(s.charAt(i))) {
        root.childrens.put(s.charAt(i), new TrieNode(s.charAt(i)));
      }
      root = root.childrens.get(s.charAt(i));
      if (i == s.length() - 1) {
        root.isWord = true;
      }
    }
  }
}


class TrieNode {
  char c;
  Map<Character, TrieNode> childrens;
  boolean isWord;
  
  public TrieNode(char c) {
    this.c = c;
    childrens = new HashMap<>();
    isWord = false;
  }
}
