class TaskManager {

    private final Map<Integer, Task> taskIdToTask;
    private final PriorityQueue<Integer> taskPriorities;
    private final Map<Integer, TreeSet<Task>> priorityToTask;

    public TaskManager(List<List<Integer>> tasks) {
        taskIdToTask = new HashMap<>();
        taskPriorities = new PriorityQueue<>((a,b) -> b - a);
        priorityToTask = new HashMap<>();
        for (List<Integer> t : tasks) {
            add(t.get(0), t.get(1), t.get(2));
        }
    }

    public void add(int userId, int taskId, int priority) {
        Task task = new Task(userId, taskId, priority);
        taskIdToTask.put(taskId, task);
        if (!priorityToTask.containsKey(priority)) {
            taskPriorities.add(priority);
            priorityToTask.put(priority, new TreeSet<>());
        }
        priorityToTask.get(priority).add(task);
    }

    public void edit(int taskId, int newPriority) {
        Task existingTask = taskIdToTask.get(taskId);

        int olderPriority = existingTask.getPriority();
        priorityToTask.get(olderPriority).remove(existingTask);

        existingTask.updatePriority(newPriority);
        if (!priorityToTask.containsKey(newPriority)) {
            taskPriorities.add(newPriority);
            priorityToTask.put(newPriority, new TreeSet<>());
        }
        priorityToTask.get(newPriority).add(existingTask);
    }

    public void rmv(int taskId) {
        Task existingTask = taskIdToTask.get(taskId);
        int olderPriority = existingTask.getPriority();
        priorityToTask.get(olderPriority).remove(existingTask);
        taskIdToTask.remove(taskId);
    }

    public int execTop() {
        while (!taskPriorities.isEmpty() && priorityToTask.get(taskPriorities.peek()).isEmpty()) {
            int priorityToRemove = taskPriorities.remove();
            priorityToTask.remove(priorityToRemove);
        }
        if (taskPriorities.isEmpty()) {
            return -1;
        }
        int highestPriority = taskPriorities.peek();
        TreeSet<Task> tasks = priorityToTask.get(highestPriority);
        Task taskToExecute = tasks.pollLast();
        taskIdToTask.remove(Objects.requireNonNull(taskToExecute).taskId);
        return taskToExecute.userId;
    }

    static class Task implements Comparable<Task> {

        private final int taskId;
        private final int userId;
        private int priority;

        public Task(int userId, int taskId, int priority) {
            this.taskId = taskId;
            this.userId = userId;
            this.priority = priority;
        }

        public void updatePriority(int newPriority) {
            this.priority = newPriority;
        }

        public int getPriority() {
            return this.priority;
        }

        @Override
        public int compareTo(Task other) {
            return this.taskId - other.taskId;
        }
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */
