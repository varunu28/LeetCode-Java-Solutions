class Solution {
  public List<String> buildArray(int[] target, int n) {
    List<String> ans = new ArrayList<>();
    final String PUSH = "Push";
    final String POP = "Pop";
    int idx = 0;
    int curr = 1;
    while (idx < target.length) {
      ans.add(PUSH);
      if (target[idx] == curr) {
        idx++;
      }
      else {
        ans.add(POP);
      }
      curr++;
    }
    return ans;
  }
}
