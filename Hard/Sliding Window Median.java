class Solution {
    public double[] medianSlidingWindow(int[] nums, int windowSize) {
        double[] medians = new double[nums.length - windowSize + 1];
        Map<Integer, Integer> delayedRemovals = new HashMap<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());  
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();                          
        int currentIndex = 0;
        while (currentIndex < windowSize) {
            maxHeap.add(nums[currentIndex++]);
        }
        for (int j = 0; j < windowSize / 2; j++) {
            minHeap.add(maxHeap.poll());
        }
        int medianIndex = 0;
        while (true) {
            if (windowSize % 2 == 1) {
                medians[medianIndex++] = maxHeap.peek();
            } else {
                medians[medianIndex++] = ((double) maxHeap.peek() + (double) minHeap.peek()) / 2.0;
            }
            if (currentIndex >= nums.length) {
                break;
            }
            int outNum = nums[currentIndex - windowSize];  
            int inNum = nums[currentIndex++];             
            int balance = 0;                        
            // Handle outgoing number
            balance += (outNum <= maxHeap.peek() ? -1 : 1);
            delayedRemovals.put(outNum, delayedRemovals.getOrDefault(outNum, 0) + 1);
            // Handle incoming number
            if (!maxHeap.isEmpty() && inNum <= maxHeap.peek()) {
                balance++;
                maxHeap.add(inNum);
            } else {
                balance--;
                minHeap.add(inNum);
            }
            // Rebalance heaps
            if (balance < 0) {
                maxHeap.add(minHeap.poll());
                balance++;
            }
            if (balance > 0) {
                minHeap.add(maxHeap.poll());
                balance--;
            }
            // Remove invalid numbers from the top of the heaps
            while (delayedRemovals.getOrDefault(maxHeap.peek(), 0) > 0) {
                delayedRemovals.put(maxHeap.peek(), delayedRemovals.get(maxHeap.peek()) - 1);
                maxHeap.poll();
            }
            while (!minHeap.isEmpty() && delayedRemovals.getOrDefault(minHeap.peek(), 0) > 0) {
                delayedRemovals.put(minHeap.peek(), delayedRemovals.get(minHeap.peek()) - 1);
                minHeap.poll();
            }
        }
        return medians;
    }
}
