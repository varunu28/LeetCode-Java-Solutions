class Leaderboard {

  private Map<Integer, Integer> playerToScoreMapping;
  private Map<Integer, Set<Integer>> scoreToPlayerMapping;

  public Leaderboard() {
    this.playerToScoreMapping = new HashMap<>();
    this.scoreToPlayerMapping = new TreeMap<>(Collections.reverseOrder());
  }

  public void addScore(int playerId, int score) {
    if (playerToScoreMapping.containsKey(playerId)) {
      int previousScore = playerToScoreMapping.get(playerId);
      if (scoreToPlayerMapping.getOrDefault(previousScore, new HashSet<>()).contains(playerId)) {
        scoreToPlayerMapping.get(previousScore).remove(playerId);
      }
      score += previousScore;
    }
    playerToScoreMapping.put(playerId, score);
    scoreToPlayerMapping.computeIfAbsent(score, k -> new HashSet<>()).add(playerId);
  }

  public int top(int K) {
    int totalScore = 0;
    for (Integer currScore : scoreToPlayerMapping.keySet()) {
      int totalPlayersWithScore = scoreToPlayerMapping.get(currScore).size();
      int playersRemaining = Math.min(K, totalPlayersWithScore);
      totalScore += playersRemaining * currScore;
      K -= playersRemaining;
      if (K == 0) {
        break;
      }
    }
    return totalScore;
  }

  public void reset(int playerId) {
    scoreToPlayerMapping.get(playerToScoreMapping.get(playerId)).remove(playerId);
    playerToScoreMapping.put(playerId, 0);
  }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */
