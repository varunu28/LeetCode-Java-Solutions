class Solution {
  public int minEatingSpeed(int[] piles, int h) {
    int minBananaCount = 1;
    int maxBananaCount = maxFromPile(piles);
    while (minBananaCount < maxBananaCount) {
      int mid = (minBananaCount + maxBananaCount) / 2;
      if (canFinishPile(piles, mid, h)) {
        maxBananaCount = mid;
      } else {
        minBananaCount = mid + 1;
      }
    }
    return minBananaCount;
  }
  
  private boolean canFinishPile(int[] piles, int bananaPerHour, int totalHours) {
    int totalTime = 0;
    for (int pile : piles) {
      int numOfHours = pile / bananaPerHour; 
      totalTime += numOfHours == 0 ? 1 : numOfHours;
      totalTime += numOfHours > 0 && pile % bananaPerHour != 0 ? 1 : 0;
    }
    return totalTime <= totalHours;
  }
  
  private int maxFromPile(int[] piles) {
    int maxCount = piles[0];
    for (int i = 1; i < piles.length; i++) {
      maxCount = Math.max(maxCount, piles[i]);
    }
    return maxCount;
  }
}
