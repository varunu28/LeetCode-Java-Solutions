class Solution {
  public int countConsistentStrings(String allowed, String[] words) {
    return (int)
        Arrays.stream(words)
            .filter(
                word ->
                    word.chars().mapToObj(c -> (char) c).allMatch(c -> allowed.indexOf(c) != -1))
            .count();
  }
}
