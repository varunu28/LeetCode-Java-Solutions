class Solution {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    int l = beginWord.length();
    Map<String, List<String>> map = new HashMap<>();
    for (String word : wordList) {
      for (int i = 0; i < l; i++) {
        String wildCard = word.substring(0, i) + "*" + word.substring(i + 1, l);
        map.computeIfAbsent(wildCard, k -> new ArrayList<>()).add(word);
      }
    }
    Queue<Node> queue = new LinkedList<>();
    queue.add(new Node(beginWord, 1));
    Set<String> visited = new HashSet<>();
    visited.add(beginWord);
    while (!queue.isEmpty()) {
      Node removed = queue.remove();
      String word = removed.word;
      int currLevel = removed.level;
      for (int i = 0; i < l; i++) {
        String newWord = word.substring(0, i) + "*" + word.substring(i + 1);
        for (String wildCard : map.getOrDefault(newWord, new ArrayList<>())) {
          if (wildCard.equals(endWord)) {
            return currLevel + 1;
          }
          if (!visited.contains(wildCard)) {
            visited.add(wildCard);
            queue.add(new Node(wildCard, currLevel + 1));
          }
        }
      }
    }
    return 0;
  }
}


class Node {
  String word;
  int level;

  public Node(String word, int level) {
    this.word = word;
    this.level = level;
  }
}
