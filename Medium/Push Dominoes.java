class Solution {
  public String pushDominoes(String dominoes) {
    int[] forces = new int[dominoes.length()];
    int force = 0;
    for (int i = 0; i < dominoes.length(); i++) {
      if (dominoes.charAt(i) == 'R') {
        force = dominoes.length();
      } else if (dominoes.charAt(i) == 'L') {
        force = 0;
      } else {
        force = Math.max(force - 1, 0);
      }
      forces[i] += force;
    }
    force = 0;
    for (int i = dominoes.length() - 1; i >= 0; i--) {
      if (dominoes.charAt(i) == 'L') {
        force = dominoes.length();
      } else if (dominoes.charAt(i) == 'R') {
        force = 0;
      } else {
        force = Math.max(force - 1, 0);
      }
      forces[i] -= force;
    }
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < forces.length; i++) {
      result.append(forces[i] > 0 ? 'R' : (forces[i] < 0 ? 'L' : '.'));
    }
    return result.toString();
  }
}
