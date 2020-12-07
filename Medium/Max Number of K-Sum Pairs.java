class Solution {
  public int maxOperations(int[] nums, int k) {
    Map<Integer, Integer> counter = new HashMap<>();
    for (int num : nums) {
      counter.put(num, counter.getOrDefault(num, 0) + 1);
    }
    Set<Integer> keys = counter.keySet();
    int numOfPairs = 0;
    for (Integer key : keys) {
      if (counter.containsKey(k - key) && (k - key != key)) {
        int min = Math.min(counter.get(key), counter.get(k - key));
        counter.put(key, counter.get(key) - min);
        counter.put(k - key, counter.get(k - key) - min);
        numOfPairs += min;
      } else if (counter.containsKey(k - key) && (k - key == key)) {
        numOfPairs += counter.get(key) / 2;
        counter.put(key, counter.get(key) / 2);
      }
    }
    return numOfPairs;
  }
}
