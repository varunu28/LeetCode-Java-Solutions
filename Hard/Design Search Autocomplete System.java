class AutocompleteSystem {

  private final TrieNode root;
  private TrieNode queryNode;
  private final Map<String, Integer> popularityMap;
  StringBuilder sb;
  boolean invalidQuery;

  public AutocompleteSystem(String[] sentences, int[] times) {
    root = new TrieNode();
    this.popularityMap = new HashMap<>();
    for (int i = 0; i < sentences.length; i++) {
      indexSentence(sentences[i], root);
      this.popularityMap.put(
          sentences[i], this.popularityMap.getOrDefault(sentences[i], 0) + times[i]);
    }
    this.queryNode = root;
    this.sb = new StringBuilder();
    this.invalidQuery = false;
  }

  private void indexSentence(String sentence, TrieNode root) {
    for (char c : sentence.toCharArray()) {
      if (!root.children.containsKey(c)) {
        root.children.put(c, new TrieNode());
      }
      root = root.children.get(c);
      root.sentences.add(sentence);
    }
  }

  public List<String> input(char c) {
    if (c == '#') {
      cleanUp();
      return new ArrayList<>();
    }
    this.sb.append(c);
    if (!this.queryNode.children.containsKey(c) || invalidQuery) {
      this.invalidQuery = true;
      return new ArrayList<>();
    }
    this.queryNode = this.queryNode.children.get(c);
    return this.queryNode.sentences.stream()
        .sorted(
            (o1, o2) -> {
              int c1 = popularityMap.get(o2).compareTo(popularityMap.get(o1));
              if (c1 != 0) {
                return c1;
              }
              return o1.compareTo(o2);
            })
        .limit(3)
        .collect(Collectors.toList());
  }

  private void cleanUp() {
    this.queryNode = root;
    String inputString = this.sb.toString();
    this.sb.setLength(0);
    this.popularityMap.put(inputString, this.popularityMap.getOrDefault(inputString, 0) + 1);
    this.invalidQuery = false;
    indexSentence(inputString, root);
  }

  private static class TrieNode {

    private final Map<Character, TrieNode> children;
    private final Set<String> sentences;

    public TrieNode() {
      this.children = new HashMap<>();
      this.sentences = new HashSet<>();
    }
  }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */
