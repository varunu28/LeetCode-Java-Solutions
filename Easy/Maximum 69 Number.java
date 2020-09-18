class Solution {
  public int maximum69Number (int num) {
    int lastSixIndex = Integer.MAX_VALUE;
    int count = 0;
    int copy = num;
    while (copy > 0) {
      int rem = copy % 10;
      if (rem == 6) {
        lastSixIndex = count;
      }
      copy /= 10;
      count++;
    }
    if (lastSixIndex == Integer.MAX_VALUE) {
      return num;
    }
    return (
      ((num / ((int) Math.pow(10, lastSixIndex + 1))) * ((int) Math.pow(10, lastSixIndex + 1))) +
      (9 * ((int) Math.pow(10, lastSixIndex))) + 
      (num % ((int) Math.pow(10, lastSixIndex)))
    );
  }
}
