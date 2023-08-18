class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] road : roads) {
            map.computeIfAbsent(road[0], k -> new HashSet<>()).add(road[1]);
            map.computeIfAbsent(road[1], k -> new HashSet<>()).add(road[0]);
        }
        int maximumRank = 0;
        for (int i = 0; i < n; i++) {
            int iRank = map.getOrDefault(i, new HashSet<>()).size();
            for (int j = i + 1; j < n; j++) {
                int combinedRank = iRank + map.getOrDefault(j, new HashSet<>()).size();
                if (map.getOrDefault(j, new HashSet<>()).contains(i)) {
                    combinedRank--;
                }
                maximumRank = Math.max(maximumRank, combinedRank);
            }
        }
        return maximumRank;
    }
}
