class Solution {
  public int maxNumberOfBalloons(String text) {
    Map<Character, Long> textFrequencyMap = getFrequencyMap(text);
    Map<Character, Long> ballonFrequencyMap = getFrequencyMap("balloon");
    return ballonFrequencyMap.keySet().stream()
        .map(k -> 
            (int) (textFrequencyMap.getOrDefault(k, 0L) / ballonFrequencyMap.get(k)))
        .min(Integer::compare)
        .orElse(0);
  }

  private Map<Character, Long> getFrequencyMap(String s) {
    return s.chars()
        .mapToObj(c -> (char) c)
        .collect(Collectors.groupingBy(Function.identity(), HashMap::new, Collectors.counting()));
  }
}
