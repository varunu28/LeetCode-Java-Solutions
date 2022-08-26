class Solution {
  public boolean reorderedPowerOf2(int n) {
    int[] digitCount = count(n);
    for (int i = 0; i < 31; i++) {
      if (Arrays.equals(digitCount, count(1 << i))) {
        return true;
      }
    }
    return false;
  }
  
  private int[] count(int n) {
    int[] result = new int[10];
    while (n > 0) {
      result[n % 10]++;
      n /= 10;
    }
    return result;
  }
}
