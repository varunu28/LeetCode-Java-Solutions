class FirstUnique {

    private Map<Integer, Integer> map;
    private Queue<Integer> queue;

    public FirstUnique(int[] nums) {
        map = new HashMap<>();
        queue = new LinkedList<>();
        for (int num : nums) {
            add(num);
        }
    }
    
    public int showFirstUnique() {
        while (!queue.isEmpty() && map.get(queue.peek()) > 1) {
            queue.remove();
        }
        return queue.isEmpty() ? -1 : queue.peek();
    }
    
    public void add(int value) {
        queue.add(value);
        map.put(value, map.getOrDefault(value, 0) + 1);
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */
