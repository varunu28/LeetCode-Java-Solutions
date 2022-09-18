class Solution {
  public int matchPlayersAndTrainers(int[] players, int[] trainers) {
    Arrays.sort(players);
    Arrays.sort(trainers);
    int playerIdx = 0;
    int trainerIdx = 0;
    while (playerIdx < players.length && trainerIdx < trainers.length) {
      if (players[playerIdx] <= trainers[trainerIdx]) {
        playerIdx++;
      }
      trainerIdx++;
    }
    return playerIdx;
  }
}
