class Solution {
  public String getHint(String secret, String guess) {
    int[] counter = new int[10];
    int cows = 0;
    int bulls = 0;
    for (int i = 0; i < guess.length(); i++) {
      int s = Character.getNumericValue(secret.charAt(i));
      int g = Character.getNumericValue(guess.charAt(i));
      if (s == g) {
        bulls++;
      }
      else {
        if (counter[s] < 0) {
          cows++;
        }
        if (counter[g] > 0) {
          cows++;
        }
        counter[s]++;
        counter[g]--;
      }
    }
    return new StringBuilder().append(bulls).append("A").append(cows).append("B").toString();
  }
}
