class Solution {
  public int minSetSize(int[] arr) {
    Map<Integer, Integer> map = new HashMap<>();
    int maxCount = 0;
    for (int num : arr) {
      map.put(num, map.getOrDefault(num, 0) + 1);
      maxCount = Math.max(maxCount, map.get(num));
    }
    int[] bucket = new int[maxCount + 1];
    for (int count : map.values()) {
      bucket[count]++;
    }
    int n = arr.length;
    int setSize = 0;
    int bucketIdx = bucket.length - 1;
    while (n > arr.length / 2) {
      if (bucket[bucketIdx] > 0) {
        setSize++;
        n -= bucketIdx;
        bucket[bucketIdx]--;
      } else {
        bucketIdx--;
      }
    }
    return setSize;
  }
}
