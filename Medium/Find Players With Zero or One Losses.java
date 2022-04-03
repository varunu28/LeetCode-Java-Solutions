class Solution {
  public List<List<Integer>> findWinners(int[][] matches) {
    Map<Integer, Integer> lossCount = new HashMap<>();
    Set<Integer> players = new HashSet<>();
    for (int[] match : matches) {
      lossCount.put(match[1], lossCount.getOrDefault(match[1], 0) + 1);
      players.add(match[0]);
      players.add(match[1]);
    }
    List<Integer> noLoss = new ArrayList<>();
    List<Integer> exactlyOneLoss = new ArrayList<>();
    for (Integer player : players) {
      if (!lossCount.containsKey(player)) {
        noLoss.add(player);
      }
      if (lossCount.getOrDefault(player, 0) == 1) {
        exactlyOneLoss.add(player);
      }
    }
    Collections.sort(noLoss);
    Collections.sort(exactlyOneLoss);
    return Arrays.asList(noLoss, exactlyOneLoss);
  }
}
