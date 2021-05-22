class Solution {
  public int[] memLeak(int memory1, int memory2) {
    int currentLeak = 1;
    while (Math.max(memory1, memory2) >= currentLeak) {
      if (memory1 >= memory2) {
        memory1 -= currentLeak++;
      } else {
        memory2 -= currentLeak++;
      }
    }
    return new int[]{currentLeak, memory1, memory2};
  }
}
