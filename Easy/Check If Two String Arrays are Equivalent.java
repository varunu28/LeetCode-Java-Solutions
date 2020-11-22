class Solution {
  public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
    return Arrays.stream(word1).reduce((a, b) -> a + b)
        .equals(Arrays.stream(word2).reduce((a, b) -> a + b));
  }
}
