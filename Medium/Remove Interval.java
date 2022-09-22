class Solution {
  public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
    List<List<Integer>> result = new ArrayList<>();
    for (int[] interval : intervals) {
      if (interval[0] > toBeRemoved[1] || interval[1] < toBeRemoved[0]) {
        result.add(Arrays.asList(interval[0], interval[1]));
      } else {
        if (interval[0] < toBeRemoved[0]) {
          result.add(Arrays.asList(interval[0], toBeRemoved[0]));
        }
        if (interval[1] > toBeRemoved[1]) {
          result.add(Arrays.asList(toBeRemoved[1], interval[1]));
        }
      }
    }
    return result;
  } 
}
