class Solution {
  public String[] findWords(String[] words) {
    Map<Character, Integer> map = new HashMap<>();
    update(map, "qwertyuiop", 1);
    update(map, "asdfghjkl", 2);
    update(map, "zxcvbnm", 3);
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < words.length; i++) {
      int rowIdx = -1;
      for (char c : words[i].toCharArray()) {
        if (rowIdx == -1) {
          rowIdx = map.get(Character.toLowerCase(c));
        }
        if (map.get(Character.toLowerCase(c)) != rowIdx) {
          rowIdx = -1;
          break;
        }
      }
      if (rowIdx != -1) {
        list.add(i);
      }
    }
    String[] ans = new String[list.size()];
    for (int i = 0; i < list.size(); i++) {
      ans[i] = words[list.get(i)];
    }
    return ans;
  }
  
  private void update(Map<Character, Integer> map, String s, int row) {
    for (char c : s.toCharArray()) {
      map.put(c, row);
    }
  }
}
