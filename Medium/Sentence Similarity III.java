class Solution {
  public boolean areSentencesSimilar(String sentence1, String sentence2) {
    return isSimilar(sentence1.split(" "), sentence2.split(" ")) || isSimilar(sentence2.split(" "),
        sentence1.split(" "));
  }

  private boolean isSimilar(String[] matcher, String[] target) {
    int targetStartIdx = 0;
    int matcherCurrentIdx = 0;
    while (targetStartIdx < target.length && matcherCurrentIdx < matcher.length) {
      if (!matcher[matcherCurrentIdx].equals(target[targetStartIdx])) {
        break;
      }
      targetStartIdx++;
      matcherCurrentIdx++;
    }
    if (targetStartIdx == target.length) {
      return true;
    }
    int targetEndIdx = target.length - 1;
    matcherCurrentIdx = matcher.length - 1;
    while (targetEndIdx >= targetStartIdx && matcherCurrentIdx >= 0) {
      if (!matcher[matcherCurrentIdx].equals(target[targetEndIdx])) {
        return false;
      }
      targetEndIdx--;
      matcherCurrentIdx--;
    }
    return targetEndIdx == targetStartIdx - 1;
  }
}
