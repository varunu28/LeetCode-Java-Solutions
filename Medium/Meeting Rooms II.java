class Solution {
  public int minMeetingRooms(int[][] intervals) {
    Arrays.sort(intervals, Comparator.comparingInt((a) -> a[0]));
    PriorityQueue<int[]> meetingsInProgress = new PriorityQueue<>(
        Comparator.comparingInt((a) -> a[1]));
    int result = 0;
    for (int[] interval : intervals) {
      while (!meetingsInProgress.isEmpty() && meetingsInProgress.peek()[1] <= interval[0]) {
        meetingsInProgress.poll();
      }
      meetingsInProgress.add(interval);
      result = Math.max(result, meetingsInProgress.size());
    }
    return result;
  }
}
