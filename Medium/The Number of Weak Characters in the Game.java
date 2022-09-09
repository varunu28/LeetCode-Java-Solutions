class Solution {
  public int numberOfWeakCharacters(int[][] properties) {
    int maxAttackValue = 0;
    for (int[] property : properties) {
      maxAttackValue = Math.max(maxAttackValue, property[0]);
    }
    int maxDefense[] = new int[maxAttackValue + 2];
    for (int[] property : properties) {
      int attack = property[0];
      int defense = property[1];
      maxDefense[attack] = Math.max(maxDefense[attack], defense);
    }
    for (int i = maxAttackValue - 1; i >= 0; i--) {
      maxDefense[i] = Math.max(maxDefense[i], maxDefense[i + 1]);
    }
    int count = 0;
    for (int[] property : properties) {
      int attack = property[0];
      int defense = property[1]; 
      if (defense < maxDefense[attack + 1]) {
        count++;
      }
    }
    return count;
  }
}
