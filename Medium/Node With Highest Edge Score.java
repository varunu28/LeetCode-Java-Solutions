class Solution {
  public int edgeScore(int[] edges) {
    Map<Integer, Integer> map = new HashMap<>();
    int highestScore = 0;
    int highestScoreCandidate = Integer.MAX_VALUE;
    for (int i = 0; i < edges.length; i++) {
      map.put(edges[i], map.getOrDefault(edges[i], 0) + i);
      if (highestScore <= map.get(edges[i])) {
        if (highestScore < map.get(edges[i])) {
          highestScore = map.get(edges[i]);
          highestScoreCandidate = edges[i];
        } else if (highestScore == map.get(edges[i]) && highestScoreCandidate > edges[i]) {
          highestScoreCandidate = edges[i];
        }
      }
    }
    return highestScoreCandidate;
  }
}
