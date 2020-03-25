class Solution {
  Map<Character, int[]> map;
  public boolean judgeCircle(String moves) {
    map = new HashMap<>();
    map.put('U', new int[]{-1, 0});
    map.put('D', new int[]{1, 0});
    map.put('L', new int[]{0, -1});
    map.put('R', new int[]{0, 1});
    int x = 0;
    int y = 0;
    for (char c : moves.toCharArray()) {
      int[] dir = map.get(c);
      x += dir[0];
      y += dir[1];
    }
    return x == 0 && y == 0;
  }
}
