class Solution {
  public int averageValue(int[] nums) {
    int total = 0;
    int count = 0;
    for (int num : nums) {
      if (num % 2 == 0 && num % 3 == 0) {
        total += num;
        count++;
      }
    }
    return count == 0 ? 0 : total / count;
  }
}
