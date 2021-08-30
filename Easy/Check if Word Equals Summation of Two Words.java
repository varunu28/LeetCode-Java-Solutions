class Solution {
  public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
    return getNumericalValue(firstWord) + getNumericalValue(secondWord) == getNumericalValue(targetWord);
  }
  
  private int getNumericalValue(String s) {
    int value = 0;
    for (char c : s.toCharArray()) {
      value = value * 10 + (c - 'a');
    }
    return value;
  }
}
