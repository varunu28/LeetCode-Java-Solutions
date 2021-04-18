class Solution {
  public boolean checkIfPangram(String sentence) {
    Set<Character> allUnique = sentence.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
    return "abcdefghijklmnopqrstuvwxyz".chars().mapToObj(c -> (char) c)
        .allMatch(allUnique::contains);
  }
}
