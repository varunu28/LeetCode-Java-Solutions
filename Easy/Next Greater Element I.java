class Solution {
  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    Stack<Integer> stack = new Stack<>();
    int[] nextMaximum = new int[nums2.length];
    Map<Integer, Integer> indexMap = new HashMap<>();
    for (int i = nums2.length - 1; i >= 0; i--) {
      while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
        stack.pop();
      }
      nextMaximum[i] = stack.isEmpty() ? -1 : stack.peek();
      stack.push(nums2[i]);
      indexMap.put(nums2[i], i);
    }
    int[] nextMaximumResult = new int[nums1.length];
    for (int i = 0; i < nums1.length; i++) {
      nextMaximumResult[i] = nextMaximum[indexMap.get(nums1[i])];
    }
    return nextMaximumResult;
  }
}
