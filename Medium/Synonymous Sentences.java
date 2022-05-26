class Solution {
  public List<String> generateSentences(List<List<String>> synonyms, String text) {
    Map<String, List<String>> synonymMapping = new HashMap<>();
    for (List<String> synonym : synonyms) {
      synonymMapping.computeIfAbsent(synonym.get(0), k -> new ArrayList<>()).add(synonym.get(1));
      synonymMapping.computeIfAbsent(synonym.get(1), k -> new ArrayList<>()).add(synonym.get(0));
    }
    Set<String> result = new TreeSet<>();
    Queue<String> queue = new LinkedList<>();
    queue.add(text);
    while (!queue.isEmpty()) {
      String removed = queue.remove();
      result.add(removed);
      String[] words = removed.split("\\s+");
      for (int i = 0; i < words.length; i++) {
        for (String synonym : synonymMapping.getOrDefault(words[i], new ArrayList<>())) {
          words[i] = synonym;
          String updatedSentence = String.join(" ", words);
          if (!result.contains(updatedSentence)) {
            queue.add(updatedSentence);
          }
        }
      }
    }
    return new ArrayList<>(result);
  }
}
