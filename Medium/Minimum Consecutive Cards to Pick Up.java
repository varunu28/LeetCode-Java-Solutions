class Solution {
  public int minimumCardPickup(int[] cards) {
    int minCount = Integer.MAX_VALUE;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < cards.length; i++) {
      if (map.containsKey(cards[i])) {
        minCount = Math.min(minCount, i - map.get(cards[i]) + 1);
      }
      map.put(cards[i], i);
    }
    return minCount == Integer.MAX_VALUE ? -1 : minCount;
  }
}
