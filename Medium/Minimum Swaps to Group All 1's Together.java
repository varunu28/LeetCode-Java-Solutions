class Solution {
  public int minSwaps(int[] data) {
    int totalOnes = 0;
    for (int num : data) {
      totalOnes += num;
    }
    int leftIdx = 0;
    int rightIdx = 0;
    int currOnes = 0;
    int maxOnes = 0;
    while (rightIdx < data.length) {
      currOnes += data[rightIdx++];
      if (rightIdx - leftIdx > totalOnes) {
        currOnes -= data[leftIdx++];
      }
      maxOnes = Math.max(maxOnes, currOnes);
    }
    return totalOnes - maxOnes;
  }
}
