class Solution {
  public boolean digitCount(String num) {
    int[] frequency = new int[10];
    for (char c : num.toCharArray()) {
      frequency[Character.getNumericValue(c)]++;
    }
    for (int i = 0; i < num.length(); i++) {
      int digit = i;
      int expectedFrequency = Character.getNumericValue(num.charAt(i));
      if (frequency[digit] != expectedFrequency) {
        return false;
      }
    }
    return true;
  }
}
