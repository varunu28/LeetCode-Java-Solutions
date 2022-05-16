class Solution {
  public int divisorSubstrings(int num, int k) {
    String numString = String.valueOf(num);
    int count = 0;
    for (int i = 0; i <= numString.length() - k; i++) {
      int substringNum = Integer.parseInt(numString.substring(i, i + k));
      if (substringNum != 0 && num % substringNum == 0) {
        count++;
      }
    }
    return count;
  }
}
