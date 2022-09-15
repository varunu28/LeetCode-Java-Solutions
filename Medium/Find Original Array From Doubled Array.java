class Solution {
  public int[] findOriginalArray(int[] changed) {
    if (changed.length % 2 != 0) {
      return new int[]{};
    }
    Arrays.sort(changed);
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : changed) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    int[] result = new int[changed.length / 2];
    int resultIdx = 0;
    for (int num : changed) {
      if (map.get(num) > 0) {
        map.put(num, map.get(num) - 1);
        int doubleValue = num * 2;
        if (map.getOrDefault(doubleValue, 0) > 0) {
          map.put(doubleValue, map.get(doubleValue) - 1);
          result[resultIdx++] = num;
        } else {
          return new int[]{};
        }
      }
    }
    return result;
  }
}
