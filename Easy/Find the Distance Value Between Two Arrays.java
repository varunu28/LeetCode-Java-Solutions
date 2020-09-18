class Solution {
  public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
    TreeSet<Integer> set = new TreeSet<>();
    for (int num : arr2) {
      set.add(num);
    }
    int count = 0;
    for (int num : arr1) {
      Integer higher = set.ceiling(num);
      Integer lower = set.floor(num);
      if ((higher != null && Math.abs(higher - num) <= d) || (lower != null && Math.abs(lower - num) <= d)) {
        continue;  
      }
      count++;
    }
    return count;
  }
}
