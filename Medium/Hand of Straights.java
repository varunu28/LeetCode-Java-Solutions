class Solution {
  public boolean isNStraightHand(int[] hand, int W) {
    if (hand.length % W != 0) {
      return false;
    }
    Map<Integer, Integer> counterMap = new HashMap<>();
    Set<Integer> set = new TreeSet<>();
    for (int num : hand) {
      counterMap.put(num, counterMap.getOrDefault(num, 0) + 1);
      set.add(num);
    }
    Iterator<Integer> iter = set.iterator();
    Integer curr = iter.next();
    while (counterMap.get(curr) > 0) {
      int temp = curr;
      for (int i = 0; i < W; i++) {
        if (counterMap.getOrDefault(temp, 0) == 0) {
          return false;
        }
        counterMap.put(temp, counterMap.get(temp) - 1);
        temp++;
      }
      while (iter.hasNext() && counterMap.get(curr) == 0) {
        curr = iter.next();
      }
    }
    return true;
  }
}
