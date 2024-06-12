class Solution {
    public int findWinningPlayer(int[] skills, int k) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < skills.length; i++) {
            indexMap.put(skills[i], i);
        }
        Map<Integer, Integer> winCountMap = new HashMap<>();
        Deque<Integer> deque = new ArrayDeque<>();
        for (int num : skills) {
            deque.addFirst(num);
        }
        while (deque.size() > 1) {
            int first = deque.pollLast();
            int second = deque.pollLast();
            int winner = Math.max(first, second);
            winCountMap.put(winner, winCountMap.getOrDefault(winner, 0) + 1);
            deque.addLast(winner);
            if (winCountMap.get(winner) == k) {
                return indexMap.get(winner);
            }
        }
        return indexMap.get(deque.poll());
    }
}
