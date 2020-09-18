class Solution {
  public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
    Map<Integer, String[]> map = new HashMap<>();
    for (int i = 0; i < indexes.length; i++) {
      map.put(indexes[i], new String[]{sources[i], targets[i]});
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < S.length(); i++) {
      if (map.containsKey(i)) {
        String source = map.get(i)[0];
        String target = map.get(i)[1];
        int currIdx = 0;
        boolean mismatch = false;
        while (currIdx + i < S.length() && currIdx < source.length()) {
          if (source.charAt(currIdx) != S.charAt(currIdx + i)) {
            mismatch = true;
            break;
          }
          currIdx++;
        }
        if (mismatch || currIdx != source.length()) {
          sb.append(S.charAt(i));
          continue;
        }
        sb.append(target);
        i += source.length() - 1;
      }
      else {
        sb.append(S.charAt(i));
      }
    }
    return sb.toString();
  }
}
