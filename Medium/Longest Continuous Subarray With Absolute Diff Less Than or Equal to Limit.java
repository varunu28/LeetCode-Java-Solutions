class Solution {
  public int longestSubarray(int[] nums, int limit) {
    int maxSize = 0;
    int start = 0;
    Deque<Integer> maxHeap = new ArrayDeque<>();
    Deque<Integer> minHeap = new ArrayDeque<>();
    for (int i = 0; i < nums.length; i++) {
      while (!maxHeap.isEmpty() && maxHeap.peekLast() < nums[i]) {
        maxHeap.pollLast();
      }
      while (!minHeap.isEmpty() && minHeap.peekLast() > nums[i]) {
        minHeap.pollLast();
      }
      minHeap.add(nums[i]);
      maxHeap.add(nums[i]);
      while (maxHeap.peek() - minHeap.peek() > limit) {
        if (maxHeap.peek() == nums[start]) {
          maxHeap.poll();
        }
        if (minHeap.peek() == nums[start]) {
          minHeap.poll();
        }
        start++;
      }
      maxSize = Math.max(maxSize, i - start + 1);
    }
    return maxSize;
  }
}
