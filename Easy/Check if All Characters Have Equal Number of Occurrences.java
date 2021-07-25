class Solution {
  public boolean areOccurrencesEqual(String s) {
    return new HashSet<>(s.chars().mapToObj(c -> (char) c)
        .collect(Collectors.groupingBy(Function.identity(), HashMap::new, Collectors.counting()))
        .values()).size() == 1;
  }
}
