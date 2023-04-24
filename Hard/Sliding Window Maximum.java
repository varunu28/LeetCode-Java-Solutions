class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        int start = 0;
        int end = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        while (end < nums.length) {
            // Remove elements from end of  queue as long as the value at end of queue is less
            // than the current value
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[end]) {
                queue.removeLast();
            }
            queue.add(end);
            // Remove the first element from the queue if we have already passed it in our range
            if (start > queue.peekFirst()) {
                queue.removeFirst();
            }
            // Update result if our window is at least of size k
            if (end + 1 >= k) {
                result[start++] = nums[queue.peekFirst()];
            }
            end++;
        }
        return result;
    }
}
