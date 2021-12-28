class Solution {
  public int[] executeInstructions(int n, int[] startPos, String s) {
    int[] result = new int[s.length()];
    Map<Character, int[]> directionToMovementMap = Map.of(
        'R', new int[]{0, 1},
        'L', new int[]{0, -1},
        'U', new int[]{-1, 0},
        'D', new int[]{1, 0}
    );
    for (int i = 0; i < s.length(); i++) {
      int startX = startPos[0];
      int startY = startPos[1];
      int j = i;
      for (; j < s.length(); j++) {
        startX += directionToMovementMap.get(s.charAt(j))[0];
        startY += directionToMovementMap.get(s.charAt(j))[1];
        if (startX < 0 || startY < 0 || startX >= n || startY >= n) {
          break;
        }
      }
      result[i] = j - i;
    }
    return result;
  }
}
