class Solution {
  public int[] singleNumber(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      if (set.contains(num)) {
        set.remove(num);
      }
      else {
        set.add(num);
      }
    }
    Iterator<Integer> iter = set.iterator();
    return new int[]{iter.next(), iter.next()};
  }
}
