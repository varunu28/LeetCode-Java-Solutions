class Solution {
    public static int[] maxSlidingWindowDynamic(int[] nums, int k) {
        if (nums.length == 0 || nums.length < k) {
            return new int[]{};
        }
        
        int[] maxLeft = new int[nums.length];
        int[] maxRight = new int[nums.length];

        maxLeft[0] = nums[0];
        maxRight[nums.length-1] = nums[nums.length-1];

        for (int i=1; i<nums.length; i++) {
            maxLeft[i] = i%k == 0 ? nums[i] : Math.max(nums[i], maxLeft[i-1]);
            int j = nums.length - i - 1;
            maxRight[j] = j%k == 0 ? nums[j] : Math.max(maxRight[j+1], nums[j]);
        }

        int[] ans = new int[nums.length - k + 1];

        for (int i=0; i<=nums.length-k; i++) {
            ans[i] = Math.max(maxRight[i], maxLeft[i + k - 1]);
        }

        return ans;
    }
    
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || nums.length < k) {
            return new int[]{};
        }

        int[] ans = new int[nums.length-k+1];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i=0; i<k; i++) {
            priorityQueue.add(nums[i]);
        }

        int j = 0;
        for (int i=k; i<nums.length; i++) {

            ans[j] = priorityQueue.peek();
            priorityQueue.remove(nums[j]);
            priorityQueue.add(nums[i]);
            j++;
        }

        ans[j] = priorityQueue.peek();

        return ans;
    }
}
