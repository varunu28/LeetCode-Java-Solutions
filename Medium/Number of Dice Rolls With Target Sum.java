class Solution {
  Map<String, Integer> map = new HashMap<>();
  final int MODULO = 1000000007;
  public int numRollsToTarget(int d, int f, int target) {
    if (d == 0 && target == 0) {
      return 1;
    }
    if (d == 0 || target == 0) {
      return 0;
    }
    String key = d + "|" + target;
    if (map.containsKey(key)) {
      return map.get(key);
    }
    int res = 0;
    for (int i = 1; i <= f; i++) {
      if (target >= i) {
        res = (res + numRollsToTarget(d - 1, f, target - i)) % MODULO;
      }
      else {
        break;
      }
    }
    map.put(key, res);
    return map.get(key);
  }
}
