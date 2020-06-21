class Solution {
  public String[] getFolderNames(String[] names) {
    int n = names.length;
    Map<String, Integer> map = new HashMap<>();
    String[] ans = new String[n];
    for (int i = 0; i < n; i++) {
      if (map.containsKey(names[i])) {
        Integer val = map.get(names[i]);
        StringBuilder sb = new StringBuilder(names[i]);
        sb.append('(').append(val).append(')');
        while (map.containsKey(sb.toString())) {
          val++;
          sb = new StringBuilder(names[i]);
          sb.append('(').append(val).append(')');
        }
        ans[i] = sb.toString();
        map.put(sb.toString(), 1);
        map.put(names[i], val + 1);
      }
      else {
        ans[i] = names[i];
        map.put(names[i], 1);
      }
    }
    return ans;
  }
}
