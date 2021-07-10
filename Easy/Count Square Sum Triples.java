class Solution {
  public int countTriples(int n) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 1; i <= n; i++) {
      map.put(i*i, i);
    }
    int count = 0;
    for (int i = 1; i <= n; i++) {
      for (int j = i + 1; j <= n; j++) {
        int key = i * i + j * j;
        if (map.containsKey(key) && !map.get(key).equals(i) && !map.get(key).equals(j)) {
          count += 2;
        }
      }
    }
    return count;
  }
}
