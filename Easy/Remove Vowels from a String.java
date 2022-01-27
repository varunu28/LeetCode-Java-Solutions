class Solution {
  public String removeVowels(String s) {
    return s.chars()
        .mapToObj(c -> (char) c)
        .filter(c -> "aeiou".indexOf(c) == -1)
        .collect(Collector.of(StringBuilder::new,
            StringBuilder::append,
            StringBuilder::append,
            StringBuilder::toString));
  }
}
