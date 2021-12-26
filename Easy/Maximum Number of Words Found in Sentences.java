class Solution {
  public int mostWordsFound(String[] sentences) {
    return Arrays.stream(sentences).map(sentence -> sentence.split("\\s").length)
        .max(Integer::compare).orElse(0);
  }
}
