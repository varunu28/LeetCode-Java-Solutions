class Solution {
  public List<List<Integer>> palindromePairs(String[] words) {
    TrieNode root = new TrieNode();
    for (int i = 0; i < words.length; i++) {
      String reversed = new StringBuilder(words[i]).reverse().toString();
      TrieNode curr = root;
      for (int j = 0; j < reversed.length(); j++) {
        if (isPalindrome(reversed, j)) {
          curr.palindromePrefixRemainingIds.add(i);
        }
        if (!curr.children.containsKey(reversed.charAt(j))) {
          curr.children.put(reversed.charAt(j), new TrieNode());
        }
        curr = curr.children.get(reversed.charAt(j));
      }
      curr.wordEndingId = i;
    }
    List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < words.length; i++) {
      String word = words[i];
      TrieNode curr = root;
      for (int j = 0; j < word.length(); j++) {
        if (curr.wordEndingId != -1 && isPalindrome(word, j)) {
          result.add(Arrays.asList(i, curr.wordEndingId));
        }
        char c = word.charAt(j);
        curr = curr.children.get(c);
        if (curr == null) {
          break;
        }
      }
      if (curr == null) {
        continue;
      }
      if (curr.wordEndingId != -1 && curr.wordEndingId != i) {
        result.add(Arrays.asList(i, curr.wordEndingId));
      }
      for (int idx : curr.palindromePrefixRemainingIds) {
        result.add(Arrays.asList(i, idx));
      }
    }
    return result;
  }
  
  private static boolean isPalindrome(String s, int start) {
    int end = s.length() - 1;
    while (start < end) {
      if (s.charAt(start) != s.charAt(end)) {
        return false;
      }
      start++;
      end--;
    }
    return true;
  }
  
  private static class TrieNode {
    private int wordEndingId;
    private Map<Character, TrieNode> children;
    private List<Integer> palindromePrefixRemainingIds;
    
    public TrieNode() {
      this.wordEndingId = -1;
      this.children = new HashMap<>();
      this.palindromePrefixRemainingIds = new ArrayList<>();
    }
  }
}
