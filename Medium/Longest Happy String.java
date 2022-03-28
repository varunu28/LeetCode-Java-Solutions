class Solution {
  public String longestDiverseString(int a, int b, int c) {
    PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
    if (a > 0) {
      priorityQueue.add(new int[]{0, a});
    }
    if (b > 0) {
      priorityQueue.add(new int[]{1, b});
    }
    if (c > 0) {
      priorityQueue.add(new int[]{2, c});
    }
    StringBuilder sb = new StringBuilder("zz");
    while (!priorityQueue.isEmpty()) {
      int[] temp = {-1, -1};
      char peekChar = (char) ('a' + priorityQueue.peek()[0]);
      if (peekChar == sb.charAt(sb.length() - 1) && 
          peekChar == sb.charAt(sb.length() - 2)) {
        temp[0] = priorityQueue.peek()[0];
        temp[1] = priorityQueue.peek()[1];
        priorityQueue.poll();
        if (priorityQueue.isEmpty()) {
          break;
        }
      }
      peekChar = (char) ('a' + priorityQueue.peek()[0]);
      if (peekChar != sb.charAt(sb.length() - 1) || 
          peekChar != sb.charAt(sb.length() - 2)) {
        int[] removed = priorityQueue.poll();
        sb.append(peekChar);
        removed[1]--;
        if (removed[1] > 0) {
          priorityQueue.add(removed);
        }
      }
      if (temp[0] != -1) {
        priorityQueue.add(temp);
      }
    }
    return sb.substring(2).toString();
  }
}
