class Solution {
  public int[] findOriginalArray(int[] changed) {
    if (changed.length % 2 != 0) {
      return new int[]{};
    }
    int[] answer = new int[changed.length / 2];
    int idx = 0;
    Map<Integer, Long> map = Arrays.stream(changed).boxed()
        .collect(Collectors.groupingBy(Function.identity(), TreeMap::new, Collectors.counting()));
    for (Integer key : map.keySet()) {
      if (map.get(key) > map.getOrDefault(key * 2, 0L)) {
        return new int[0];
      }
      for (int i = 0; i < map.get(key); i++) {
        answer[idx++] = key;
        map.put(key * 2, map.get(key * 2) - 1);
      }
    }
    return answer;
  }
}
