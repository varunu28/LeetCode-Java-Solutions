class Solution {
  public boolean makeEqual(String[] words) {
    return Arrays.stream(words)
        .reduce((a, b) -> a + b).orElse("") // Merge all strings
        .chars().mapToObj(c -> (char) c)
        .collect(Collectors.groupingBy(Function.identity(), HashMap::new, Collectors.counting())) // Build a frequency map
        .values().stream()
        .allMatch(v -> v % words.length == 0); // Predicate logic to check frequency of each character
  }
}
