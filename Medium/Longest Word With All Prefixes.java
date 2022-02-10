class Solution {
  public String longestWord(String[] words) {
    TrieNode root = new TrieNode();
    root.isWord = true;
    Map<Integer, PriorityQueue<String>> map = new TreeMap<>((o1, o2) -> o2 - o1);
    for (String word : words) {
      addToTrie(word, root);
      map.computeIfAbsent(word.length(), k -> new PriorityQueue<>(String::compareTo)).add(word);
    }
    for (Integer key : map.keySet()) {
      PriorityQueue<String> priorityQueue = map.get(key);
      while (!priorityQueue.isEmpty()) {
        String candidateWord = priorityQueue.poll();
        if (wordContainAllPrefixes(candidateWord, root)) {
          return candidateWord;
        }
      }
    }
    return "";
  }

  private boolean wordContainAllPrefixes(String word, TrieNode root) {
    TrieNode curr = root;
    for (int i = 0; i < word.length(); i++) {
      if (!curr.isWord) {
        return false;
      }
      curr = curr.children.get(word.charAt(i));
    }
    return curr.isWord;
  }

  private void addToTrie(String word, TrieNode root) {
    TrieNode curr = root;
    for (int i = 0; i < word.length(); i++) {
      if (!curr.children.containsKey(word.charAt(i))) {
        curr.children.put(word.charAt(i), new TrieNode());
      }
      curr = curr.children.get(word.charAt(i));
    }
    curr.isWord = true;
  }

  private static class TrieNode {
    Map<Character, TrieNode> children;
    boolean isWord;

    public TrieNode() {
      this.children = new HashMap<>();
      this.isWord = false;
    }
  }
}
