class Solution {
  public int repeatedNTimes(int[] A) {
    Map<Integer, Integer> map = new HashMap<>();
    int n = A.length / 2;
    for (int num : A) {
      map.put(num, map.getOrDefault(num, 0) + 1);
      if (map.get(num) == n) {
        return num;
      }
    }
    return -1;
  }
}
