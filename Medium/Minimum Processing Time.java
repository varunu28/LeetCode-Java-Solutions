class Solution {
    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        PriorityQueue<Integer> taskQueue = new PriorityQueue<>();
        PriorityQueue<Integer> processorQueue = new PriorityQueue<>((a, b) -> b - a);
        taskQueue.addAll(tasks);
        processorQueue.addAll(processorTime);
        int totalTime = Integer.MIN_VALUE;
        while (!processorQueue.isEmpty()) {
            int startTime = processorQueue.remove();
            int currTime = Integer.MIN_VALUE;
            for (int i = 0; i < 4; i++) {
                currTime = Math.max(currTime, startTime + taskQueue.remove());
            }
            totalTime = Math.max(totalTime, currTime);
        }
        return totalTime;
    }
}
