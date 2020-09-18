class Solution {
  Map<Integer, List<String>> map = new HashMap<>();
  public List<String> wordBreak(String s, List <String> wordDict) {
    Set<String> set = new HashSet<>(wordDict);
    return helper(s, set, 0);
  }

  private List<String> helper(String s, Set<String> set, int start) {
    if (map.containsKey(start)) {
      return map.get(start);
    }

    List<String> ans = new ArrayList <>();
    if (start == s.length()) {
      ans.add("");
    }
    for (int i = start + 1; i <= s.length(); i++) {
      if (set.contains(s.substring(start, i))) {
        List<String> list = helper(s, set, i);
        for (String word : list) {
          ans.add(s.substring(start, i) + (word.equals("") ? "" : " ") + word);
        }
      }
    }

    map.put(start, ans);
    return ans;
  }
}
