class Solution {
  public List<Integer> partitionLabels(String S) {
    if (S == null || S.length() == 0) {
      return new ArrayList<>();
    }
    int[] count = new int[26];
    for (int i = 0; i < S.length(); i++) {
      count[S.charAt(i) - 'a'] = i;
    }
    int start = -1;
    int end = 0;
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < S.length(); i++) {
      end = Math.max(end, count[S.charAt(i) - 'a']);
      if (end == i) {
        list.add(end - start);
        start = end;
      }
    }
    return list;
  }
}
