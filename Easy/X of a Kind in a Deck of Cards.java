class Solution {
  public boolean hasGroupsSizeX(int[] deck) {
    Map<Integer, Integer> map = new HashMap<>();
    int maxGroupCount = Integer.MIN_VALUE;
    for (int card : deck) {
      map.put(card, map.getOrDefault(card, 0) + 1);
      maxGroupCount = Math.max(maxGroupCount, map.get(card));
    }
    for (Integer key : map.keySet()) {
      if (map.get(key) < 2) {
        return false;
      }
    }
    for (int i = 2; i <= maxGroupCount; i++) {
      boolean allPaired = true;
      for (Integer key : map.keySet()) {
        if (map.get(key) < i) {
          return false;
        }
        if (map.get(key) % i != 0) {
          allPaired = false;
          break;
        }
      }
      if (allPaired) {
        return true;
      }
    }
    return false;
  }
}
