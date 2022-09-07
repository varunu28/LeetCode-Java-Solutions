class Solution {
  public int minEatingSpeed(int[] piles, int h) {
    int start = 1;
    int end = 0;
    for (int pile : piles) {
      end = Math.max(end, pile);
    }
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (isPossible(piles, mid, h)) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
    return start;
  }
  
  private boolean isPossible(int[] piles, int k, int h) {
    int numOfHours = 0;
    for (int pile : piles) {
      numOfHours += Math.ceil((double) pile / k);
    }
    return numOfHours <= h;
  }
}
