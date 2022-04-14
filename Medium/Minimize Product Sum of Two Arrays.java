class Solution {
  public int minProductSum(int[] nums1, int[] nums2) {
    int[] frequencyOne = new int[101];
    int[] frequencyTwo = new int[101];
    for (int i = 0; i < nums1.length; i++) {
      frequencyOne[nums1[i]]++;
      frequencyTwo[nums2[i]]++;
    }
    int idxOne = 0;
    int idxTwo = 100;
    int sum = 0;
    while (idxOne < 101 && idxTwo >= 0) {
      while (idxOne < 101 && frequencyOne[idxOne] == 0) {
        idxOne++;
      }
      while (idxTwo >= 0 && frequencyTwo[idxTwo] == 0) {
        idxTwo--;
      }
      if (idxOne == 101 || idxTwo == -1) {
        break;
      }
      int counter = Math.min(frequencyOne[idxOne], frequencyTwo[idxTwo]);
      sum += counter * idxOne * idxTwo;
      frequencyOne[idxOne] -= counter;
      frequencyTwo[idxTwo] -= counter;
    }
    return sum;
  }   
}
