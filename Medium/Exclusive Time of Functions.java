class Solution {
  public int[] exclusiveTime(int n, List<String> logs) {
    int[] result = new int[n];
    Stack<Log> stack = new Stack<>();
    for (String log : logs) {
      Log currentLog = new Log(log);
      if (currentLog.isStart) {
        stack.push(currentLog);
      } else {
        Log topLog = stack.pop();
        result[topLog.id] += currentLog.time - topLog.time + 1 - topLog.overLappingTime;
        if (!stack.isEmpty()) {
          stack.peek().overLappingTime += currentLog.time - topLog.time + 1;
        }
      }
    }
    return result;
  }

  private static class Log {
    public int id;
    public boolean isStart;
    public int time;
    public int overLappingTime;

    public Log(String log) {
      String[] split = log.split(":");
      this.id = Integer.parseInt(split[0]);
      this.isStart = split[1].equals("start");
      this.time = Integer.parseInt(split[2]);
    }
  }
}
