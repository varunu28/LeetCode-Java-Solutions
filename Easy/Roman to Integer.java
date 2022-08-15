class Solution {
  
  public int romanToInt(String s) {
    String[] strings = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
    int[] value = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < strings.length; i++) {
      map.put(strings[i], value[i]);
    } 
    int idx = 0;
    int num = 0;
    while (idx < s.length()) {
      if (idx + 1 < s.length() && map.containsKey(s.substring(idx, idx + 2))) {
        num += map.get(s.substring(idx, idx + 2));
        idx += 2;
      } else {
        num += map.get(s.substring(idx, idx + 1));
        idx++;
      }
    }
    return num;
  }
}
