class Solution {
    public int winningPlayerCount(int n, int[][] pick) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        Set<Integer> winners = new HashSet<>();
        for (int[] p : pick) {
            map.computeIfAbsent(p[0], k -> new HashMap<>());
            map.get(p[0]).put(p[1], map.get(p[0]).getOrDefault(p[1], 0) + 1);
            if (map.get(p[0]).get(p[1]) > p[0]) {
                winners.add(p[0]);
            }
        }
        return winners.size();
    }
}
