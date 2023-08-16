class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dequeue = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            if (!dequeue.isEmpty() && dequeue.getFirst() == i - k) {
                dequeue.removeFirst();
            }
            while (!dequeue.isEmpty() && nums[i] > nums[dequeue.getLast()]) {
                dequeue.removeLast();
            }
            dequeue.addLast(i);
            if (i >= k - 1) {
                result[i - k + 1] = nums[dequeue.getFirst()];
            }
        }
        return result;
    }
}
