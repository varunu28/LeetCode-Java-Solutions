class Solution {
  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();
    for (String str : strs) {
      String key = getKey(str);
      map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
    }
    List<List<String>> ans = new ArrayList<>(map.values());
    return ans;
  }
  
  private String getKey(String s) {
    int[] counter = new int[26];
    for (char c : s.toCharArray()) {
      counter[c - 'a']++;
    }
    return Arrays.toString(counter);
  }
}
