class Solution {
  public int minimumLengthEncoding(String[] words) {
    TrieNode root = new TrieNode();
    Map<TrieNode, Integer> nodes = new HashMap<>();
    for (int i = 0; i < words.length; i++) {
      TrieNode curr = root;
      for (int j = words[i].length() - 1; j >= 0; j--) {
        if (curr.children[words[i].charAt(j) - 'a'] == null) {
          curr.children[words[i].charAt(j) - 'a'] = new TrieNode();
          curr.count++;
        }
        curr = curr.children[words[i].charAt(j) - 'a'];
      }
      nodes.put(curr, i);
    }
    int result = 0;
    for (TrieNode node : nodes.keySet()) {
      if (node.count == 0) {
        result += words[nodes.get(node)].length() + 1;
      }
    }
    return result;
  }
  
  private class TrieNode {
    TrieNode[] children;
    int count;
    
    public TrieNode() {
      this.children = new TrieNode[26];
      this.count = 0;
    }
  }
}
