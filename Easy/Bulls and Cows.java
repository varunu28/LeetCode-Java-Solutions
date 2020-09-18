class Solution {
  public String getHint(String secret, String guess) {
    int[] counter = new int[10];
    for (Character c : secret.toCharArray()) {
      counter[Character.getNumericValue(c)]++;
    }
    int bulls = 0;
    int cows = 0;
    for (int i = 0; i < guess.length(); i++) {
      if (guess.charAt(i) == secret.charAt(i)) {
        bulls++;
      }
      if (counter[Character.getNumericValue(guess.charAt(i))] > 0) {
        counter[Character.getNumericValue(guess.charAt(i))]--;
        cows++;
      }
    }
    return bulls + "A" + (cows - bulls) + "B";
  }
}
