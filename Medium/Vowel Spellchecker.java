class Solution {
  public String[] spellchecker(String[] wordlist, String[] queries) {
    Map<String, String> capsMap = new HashMap<>();
    Map<String, String> vowMap = new HashMap<>();
    Set<String> perfect = new HashSet<>();
    for (String word : wordlist) {
      perfect.add(word);
      capsMap.putIfAbsent(word.toLowerCase(), word);
      vowMap.putIfAbsent(getVowelKey(word.toLowerCase()), word);
    }
    String[] ans = new String[queries.length];
    for (int i = 0; i < queries.length; i++) {
      if (perfect.contains(queries[i])) {
        ans[i] = queries[i];
      }
      else if (capsMap.containsKey(queries[i].toLowerCase())) {
        ans[i] = capsMap.get(queries[i].toLowerCase());
      }
      else {
        ans[i] = vowMap.getOrDefault(getVowelKey(queries[i].toLowerCase()), "");
      }
    }
    return ans;
  }
  
  private String getVowelKey(String word) {
    StringBuilder sb = new StringBuilder();
    for (char c : word.toCharArray()) {
      if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
        sb.append('*');
      }
      else {
        sb.append(c);
      }
    }
    return sb.toString();
  }
}
