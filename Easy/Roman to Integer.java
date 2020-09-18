class Solution {
  public int romanToInt(String s) {
    String[] keys = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
    int[] values = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < keys.length; i++) {
      map.put(keys[i], values[i]);
    }
    int val = 0;
    int idx = 0;
    int n = s.length();
    while (idx < n) {
      char c = s.charAt(idx);
      if (idx + 1 < n && map.containsKey(s.substring(idx, idx + 2))) {
        val += map.get(s.substring(idx, idx + 2));
        idx += 2;
      }
      else {
        val += map.get(String.valueOf(c));
        idx++;
      }
    }
    return val;
  }
}
