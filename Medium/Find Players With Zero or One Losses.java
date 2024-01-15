class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> playerToLossCount = new HashMap<>();
        for (int[] match : matches) {
            int winner = match[0];
            int loser = match[1];
            playerToLossCount.putIfAbsent(winner, 0);
            playerToLossCount.put(loser, playerToLossCount.getOrDefault(loser, 0) + 1);
        }
        List<List<Integer>> result = new ArrayList<>(
            Arrays.asList(new ArrayList<>(), new ArrayList<>())
        );
        for (Map.Entry<Integer, Integer> entry : playerToLossCount.entrySet()) {
            if (entry.getValue() <= 1) {
                result.get(entry.getValue()).add(entry.getKey());
            }
        }
        Collections.sort(result.get(0));
        Collections.sort(result.get(1));
        return result;
    }
}
