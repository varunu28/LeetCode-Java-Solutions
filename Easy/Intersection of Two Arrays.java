class Solution {
  public int[] intersection(int[] nums1, int[] nums2) {
    Set<Integer> set = new HashSet<>();
    for (int num : nums1) {
      set.add(num);
    }
    Set<Integer> match = new HashSet<>();
    for (int num : nums2) {
      if (set.contains(num)) {
        match.add(num);
      }
    }
    int[] ans = new int[match.size()];
    Iterator<Integer> iter = match.iterator();
    for (int i = 0; i < ans.length; i++) {
      ans[i] = iter.next();
    }
    return ans;
  }
}
