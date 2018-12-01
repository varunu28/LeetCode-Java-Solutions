class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] time = new int[n];

        Stack<Task> tasks = new Stack<>();

        for (String log : logs) {
            Task task = new Task(log);

            if (task.status == Status.Start) {
                tasks.push(task);
            }
            else {
                Task top = tasks.pop();
                time[top.num] += task.time - top.time + 1;

                if (!tasks.isEmpty()) {
                    time[tasks.peek().num] -= task.time - top.time + 1;
                }
            }
        }

        return time;
    }
}

class Task {
    public int num;
    public int time;
    public Status status;

    public Task(String log) {
        String[] strs = log.split(":");
        this.num = Integer.parseInt(strs[0]);
        this.time = Integer.parseInt(strs[2]);
        this.status = strs[1].equals("start") ? Status.Start : Status.End;
    }
}

enum Status {
    Start, End;
}
