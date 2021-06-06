class Solution {
  public int reductionOperations(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
    }
    PriorityQueue<KeyEntry> pq = new PriorityQueue<>(new Comparator<>(){
      public int compare(KeyEntry k1, KeyEntry k2) {
        return k2.key - k1.key;
      }
    });
    for (Integer key : map.keySet()) {
      pq.add(new KeyEntry(key, map.get(key)));
    }
    int numOfSteps = 0;
    while (pq.size() > 1) {
      KeyEntry largest = pq.poll();
      KeyEntry secondLargest = pq.poll();
      secondLargest.val += largest.val;
      pq.add(secondLargest);
      numOfSteps += largest.val;
    }
    return numOfSteps;
  }
}

class KeyEntry {
  int key;
  int val;
  
  public KeyEntry(int key, int val) {
    this.key = key;
    this.val = val;
  }
}
