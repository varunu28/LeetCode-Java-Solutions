class Solution {
  public int totalFruit(int[] fruits) {
    Map<Integer, Integer> map = new HashMap<>();
    int startIdx = 0;
    int endIdx = 0;
    int n = fruits.length;
    int maxPickedCount = 0;
    while (endIdx < n) {
      map.put(fruits[endIdx], map.getOrDefault(fruits[endIdx++], 0) + 1);
      while (startIdx < endIdx && map.size() > 2) {
        map.put(fruits[startIdx], map.get(fruits[startIdx]) - 1);
        if (map.get(fruits[startIdx]) == 0) {
          map.remove(fruits[startIdx]);
        }
        startIdx++;
      }
      maxPickedCount = Math.max(maxPickedCount, endIdx - startIdx);
    }
    return maxPickedCount;
  }   
}
