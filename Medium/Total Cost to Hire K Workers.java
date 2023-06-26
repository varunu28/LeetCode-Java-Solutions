class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> headWorkers = new PriorityQueue<>();
        PriorityQueue<Integer> tailWorkers = new PriorityQueue<>();
        for (int i = 0; i < candidates; i++) {
            headWorkers.add(costs[i]);
        }
        for (int i = Math.max(candidates, costs.length - candidates); i < costs.length; i++) {
            tailWorkers.add(costs[i]);
        }
        int headIdx = candidates;
        int tailIdx = costs.length - candidates - 1;
        long result = 0;
        for (int i = 0; i < k; i++) {
            if (tailWorkers.isEmpty() || (!headWorkers.isEmpty() && headWorkers.peek() <= tailWorkers.peek())) {
                result += headWorkers.poll();
                if (headIdx <= tailIdx) {
                    headWorkers.add(costs[headIdx++]);
                }
            } else {
                result += tailWorkers.poll();
                if (headIdx <= tailIdx) {
                    tailWorkers.add(costs[tailIdx--]);
                }
            }
        }
        return result;
    }
}
