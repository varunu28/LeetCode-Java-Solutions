class Solution {
  public int minEatingSpeed(int[] piles, int H) {
    int maxSize = piles[0];
    for (int pile : piles) {
      maxSize = Math.max(pile, maxSize);
    }
    return helper(piles, H, 1, maxSize);
  }
  
  private int helper(int[] piles, int H, int start, int end) {
    while (start < end) {
      int mid = (start + end) / 2;
      if (isPossible(piles, H, mid)) {
        end = mid; 
      }
      else {
        start = mid + 1;
      }
    }
    return start;
  }
  
  private boolean isPossible(int[] piles, int H, int check) {
    int numOfHours = 0;
    for (int pile : piles) {
      int quot = pile / check; 
      numOfHours += quot == 0 ? 1 : quot;
      numOfHours += quot > 0 && pile % check != 0 ? 1 : 0;
    }
    return numOfHours <= H;
  }
}

