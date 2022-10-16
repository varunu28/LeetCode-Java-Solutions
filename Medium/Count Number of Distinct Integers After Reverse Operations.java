class Solution {
  public int countDistinctIntegers(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      set.add(num);
      set.add(reverse(num));
    }
    return set.size();
  }
  
  private int reverse(int num) {
    int reversed = 0;
    while (num > 0) {
      reversed = reversed * 10 + num % 10;
      num /= 10;
    }
    return reversed;
  }
}
