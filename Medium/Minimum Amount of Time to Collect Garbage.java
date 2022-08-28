class Solution {
  public int garbageCollection(String[] garbage, int[] travel) {
    int[] lastIdx = {-1, -1, -1};
    Map<Integer, int[]> garbageCount = new HashMap<>();
    for (int i = 0; i < garbage.length; i++) {
      garbageCount.put(i, new int[3]);
      for (char c : garbage[i].toCharArray()) {
        if (c == 'M') {
          lastIdx[0] = i;
          garbageCount.get(i)[0]++;
        }
        if (c == 'P') {
          lastIdx[1] = i;
          garbageCount.get(i)[1]++;
        }
        if (c == 'G') {
          lastIdx[2] = i;
          garbageCount.get(i)[2]++;
        }
      }
    }
    int time = 0;
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < garbage.length; j++) {
        if (lastIdx[i] < j) {
          break;
        }
        time += j == 0 ? 0 : travel[j - 1];
        time += garbageCount.get(j)[i];
      }
    }
    return time;
  }
}
