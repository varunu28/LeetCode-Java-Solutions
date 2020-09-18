class Solution {
  public int numTeams(int[] rating) {
    int res = 0;
    for (int i = 0; i < rating.length - 1; i++) {
      int[] less = new int[2];
      int[] great = new int[2];
      for (int j = 0; j < rating.length; j++) {
        if (rating[i] < rating[j]) {
          less[i > j ? 0 : 1]++;
        }
        if (rating[i] > rating[j]) {
          great[i > j ? 0 : 1]++;
        }
      }
      res += less[0] * great[1] + less[1] * great[0];
    }
    return res;
  } 
}
