class Solution {
  public int canBeTypedWords(String text, String brokenLetters) {
    return (int) Arrays.stream(text.split("\\s+"))
        .filter(e -> e.chars()
            .mapToObj(c -> (char) c)
            .noneMatch(c -> brokenLetters.indexOf(c) != -1))
        .count();
  }
}
