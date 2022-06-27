class Solution {
  public int minPartitions(String n) {
    int maxDigit = Character.getNumericValue(n.charAt(0));
    for (char c : n.toCharArray()) {
      maxDigit = Math.max(maxDigit, Character.getNumericValue(c));
    }
    return maxDigit;
  }
}
