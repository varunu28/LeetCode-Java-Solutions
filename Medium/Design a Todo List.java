class TodoList {

    private final Map<Integer, Task> taskIdToTask;
    private final Map<String, Set<Integer>> tagToTaskId;
    private final Map<Integer, Set<Task>> userIdToTask;
    private int taskId;

    public TodoList() {
        this.taskIdToTask = new HashMap<>();
        this.tagToTaskId = new HashMap<>();
        this.userIdToTask = new HashMap<>();
        this.taskId = 1;
    }

    public int addTask(int userId, String taskDescription, int dueDate, List<String> tags) {
        Task task = new Task(taskDescription, dueDate);
        int currentTaskId = taskId++;
        taskIdToTask.put(currentTaskId, task);
        tags.forEach(tag -> tagToTaskId.computeIfAbsent(tag, k -> new HashSet<>()).add(currentTaskId));
        userIdToTask.computeIfAbsent(userId, k -> new HashSet<>()).add(task);
        return  currentTaskId;
    }

    public List<String> getAllTasks(int userId) {
        return userIdToTask.getOrDefault(userId, new HashSet<>())
                .stream()
                .filter(Task::isPending)
                .sorted()
                .map(Task::getDescription)
                .toList();
    }

    public List<String> getTasksForTag(int userId, String tag) {
        return tagToTaskId.getOrDefault(tag, new HashSet<>())
                .stream()
                .filter(id -> userIdToTask
                        .getOrDefault(userId, new HashSet<>())
                        .contains(taskIdToTask.get(id)))
                .map(taskIdToTask::get)
                .filter(Task::isPending)
                .sorted()
                .map(Task::getDescription)
                .toList();
    }

    public void completeTask(int userId, int taskId) {
        if (!taskIdToTask.containsKey(taskId)) {
            return;
        }
        Task task = taskIdToTask.get(taskId);
        if (userIdToTask.getOrDefault(userId, new HashSet<>()).contains(task)) {
            task.markCompletion();
        }
    }

    private static class Task implements Comparable<Task> {
        private final String taskDescription;
        private final int dueDate;
        private boolean isCompleted;

        public Task(String taskDescription, int dueDate) {
            this.taskDescription = taskDescription;
            this.dueDate = dueDate;
            this.isCompleted = false;
        }

        public void markCompletion() {
            this.isCompleted = true;
        }

        public boolean isPending() {
            return !this.isCompleted;
        }

        public String getDescription() {
            return this.taskDescription;
        }

        @Override
        public int compareTo(Task other) {
            return this.dueDate - other.dueDate;
        }
    }
}

/**
 * Your TodoList object will be instantiated and called as such:
 * TodoList obj = new TodoList();
 * int param_1 = obj.addTask(userId,taskDescription,dueDate,tags);
 * List<String> param_2 = obj.getAllTasks(userId);
 * List<String> param_3 = obj.getTasksForTag(userId,tag);
 * obj.completeTask(userId,taskId);
 */
