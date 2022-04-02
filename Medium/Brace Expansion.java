class Solution {
  public String[] expand(String s) {
    List<List<String>> splits = parseInput(s);
    List<String> result = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    helper(splits, result, sb, 0);
    Collections.sort(result);
    String[] answer = new String[result.size()];
    for (int i = 0; i < result.size(); i++) {
      answer[i] = result.get(i);
    }
    return answer;
  }

  private void helper(List<List<String>> splits, List<String> result, StringBuilder sb, int idx) {
    if (idx >= splits.size()) {
      if (sb.length() == splits.size()) {
        result.add(new StringBuilder(sb.toString()).toString());
      }
    } else {
      for (int i = idx; i < splits.size(); i++) {
        List<String> currentSplit = splits.get(i);
        for (String section : currentSplit) {
          sb.append(section);
          helper(splits, result, sb, i + 1);
          sb.deleteCharAt(sb.length() - 1);
        }
      }
    }
  }

  private List<List<String>> parseInput(String s) {
    List<List<String>> splits = new ArrayList<>();
    int idx = 0;
    while (idx < s.length()) {
      if (s.charAt(idx) == '{') {
        int endIdx = s.indexOf('}', idx);
        String[] segements = s.substring(idx + 1, endIdx).split(",");
        splits.add(Arrays.asList(segements));
        idx = endIdx + 1;
      } else {
        splits.add(List.of(String.valueOf(s.charAt(idx++))));
      }
    }
    return splits;
  }
}
