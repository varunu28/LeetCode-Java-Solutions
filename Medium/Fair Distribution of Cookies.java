class Solution {
  public int distributeCookies(int[] cookies, int k) {
    int[] share = new int[k];
    return helper(cookies, share, 0);
  }
  
  private int helper(int[] cookies, int[] share, int idx) {
    if (idx == cookies.length) {
      int maxShare = share[0];
      for (int s : share) {
        maxShare = Math.max(s, maxShare);
      }
      return maxShare;
    }
    int result = Integer.MAX_VALUE;
    for(int i = 0; i < share.length; i++){
      share[i] += cookies[idx];
      result = Math.min(result, helper(cookies, share, idx + 1));
      share[i] -= cookies[idx];
    }
    return result;
  }
}
