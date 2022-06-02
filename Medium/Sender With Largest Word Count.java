import java.util.Map.Entry;


class Solution {
  public String largestWordCount(String[] messages, String[] senders) {
    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < messages.length; i++) {
      int wordCount = messages[i].split("\\s+").length;
      map.put(senders[i], map.getOrDefault(senders[i], 0) + wordCount);
    }
    return map.entrySet().stream()
        .sorted((o1, o2) -> {
          int c = o2.getValue() - o1.getValue();
          if (c != 0) {
            return c;
          }
          return o2.getKey().compareTo(o1.getKey());})
        .map(Entry::getKey)
        .findFirst()
        .orElse("");
  }
}
