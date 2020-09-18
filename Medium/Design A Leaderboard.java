class Leaderboard {
    Map<Integer, Integer> scoreMap;
    Map<Integer, Set<Integer>> playerMap;
    public Leaderboard() {
        scoreMap = new HashMap<>();
        playerMap = new TreeMap<>(Collections.reverseOrder());
    }

    public void addScore(int playerId, int score) {
        if (scoreMap.containsKey(playerId)) {
            int prevScore = scoreMap.get(playerId);
            playerMap.get(prevScore).remove(playerId);
        }
        scoreMap.put(playerId, scoreMap.getOrDefault(playerId, 0) + score);
        playerMap.computeIfAbsent(scoreMap.get(playerId), k -> new HashSet<>()).add(playerId);
    }

    public int top(int K) {
        int sum = 0;
        for (Integer key : playerMap.keySet()) {
            int count = Math.min(K, playerMap.get(key).size());
            sum += key * count;
            K -= count;
            if (K == 0) {
                break;
            }
        }
        return sum;
    }

    public void reset(int playerId) {
        int prevScore = scoreMap.get(playerId);
        playerMap.get(prevScore).remove(playerId);
        scoreMap.put(playerId, 0);
        playerMap.computeIfAbsent(0, k -> new HashSet<>()).add(playerId);
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */
