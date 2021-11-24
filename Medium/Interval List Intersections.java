class Solution {
  public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
    List<int[]> list = new ArrayList<>();
    int idxOne = 0;
    int idxTwo = 0;
    while (idxOne < firstList.length && idxTwo < secondList.length) {
      int maxStart = Math.max(firstList[idxOne][0], secondList[idxTwo][0]);
      int minEnd = Math.min(firstList[idxOne][1], secondList[idxTwo][1]);
      if (maxStart <= minEnd) {
        list.add(new int[]{maxStart, minEnd});
      }
      if (minEnd == firstList[idxOne][1]) {
        idxOne++;
      } else {
        idxTwo++;
      }
    }
    int[][] result = new int[list.size()][2];
    return list.toArray(result);
  }
}
