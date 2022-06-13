class Solution {
  public int[] successfulPairs(int[] spells, int[] potions, long success) {
    int[] result = new int[spells.length];
    Arrays.sort(potions);
    for (int i = 0; i < spells.length; i++) {
      int idx = getSuccessIdx(potions, spells[i], success);
      result[i] = potions.length - idx;
    }
    return result;
  }
  
  private int getSuccessIdx(int[] potions, int spell, long success) {
    int left = 0;
    int right = potions.length;
    while (left < right) {
      int mid = (left + right) / 2;
      long currSuccess = ((long) potions[mid]) * spell;
      if (currSuccess >= success) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }
}
