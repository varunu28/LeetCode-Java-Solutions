class Solution {
  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();
    for (String str : strs) {
      map.computeIfAbsent(sortedStr(str), k -> new ArrayList<>()).add(str);
    }
    List<List<String>> ans = new ArrayList<>();
    for (String key : map.keySet()) {
      ans.add(map.get(key));
    }
    return ans;
  }
  
  private String sortedStr(String s) {
    char[] chars = s.toCharArray();
    Arrays.sort(chars);
    return String.valueOf(chars);
  }
}
