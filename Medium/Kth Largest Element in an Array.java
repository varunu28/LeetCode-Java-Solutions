class Solution {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        for (int i=0; i<nums.length; i++) {
            if (queue.size() < k) {
                queue.add(nums[i]);
            }
            else {
                if (nums[i] > queue.peek()) {
                    queue.remove();
                    queue.add(nums[i]);
                }
            }
        }

        return queue.remove();
    }
}
