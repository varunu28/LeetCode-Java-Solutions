class Solution {
  public int sumFourDivisors(int[] nums) {
    int sum = 0;
    for (int num : nums) {
      Set<Integer> set = new HashSet<>();
      for (int i = 1; i <= Math.sqrt(num); i++) {
        int first = i;
        int second = num % i;
        if (second == 0) {
          set.add(first);
          set.add(num / i);
        }
      }
      if (set.size() == 4) {
        for (int d : set) {
          sum += d;
        }
      }
    }
    return sum;
  }
}
