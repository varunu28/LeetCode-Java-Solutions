class Solution {
    public int maxStarSum(int[] vals, int[][] edges, int k) {
        Map<Integer, PriorityQueue<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], node -> new PriorityQueue<>(Comparator.reverseOrder())).add(vals[edge[1]]);
            graph.computeIfAbsent(edge[1], node -> new PriorityQueue<>(Comparator.reverseOrder())).add(vals[edge[0]]);
        }
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < vals.length; i++) {
            int currSum = vals[i];
            PriorityQueue<Integer> pq = graph.getOrDefault(i, new PriorityQueue<>());
            for (int j = 0; j < k && !pq.isEmpty(); j++){
                currSum += Math.max(pq.poll(), 0);
            }
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}
