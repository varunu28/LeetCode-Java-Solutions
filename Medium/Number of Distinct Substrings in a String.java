class Solution {
  public int countDistinct(String s) {
    TrieNode root = new TrieNode();
    int n = s.length();
    int count = 0;
    for (int i = 0; i < n; i++) {
      TrieNode curr = root;
      for (int j = i; j < n; j++) {
        if (!curr.children.containsKey(s.charAt(j))) {
          count++;
          curr.children.put(s.charAt(j), new TrieNode());
        }
        curr = curr.children.get(s.charAt(j));
      }
    }
    return count;
  }
  
  private static class TrieNode {
    Map<Character, TrieNode> children;
    
    public TrieNode() {
      this.children = new HashMap<>();
    }
  }
}
