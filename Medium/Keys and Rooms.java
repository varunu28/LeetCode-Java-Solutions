class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited.add(0);
        while (!queue.isEmpty()) {
            int removed = queue.remove();
            for (Integer nextRoom : rooms.get(removed)) {
                if (!visited.contains(nextRoom)) {
                    queue.add(nextRoom);
                    visited.add(nextRoom);
                }
            }
        }
        return visited.size() == rooms.size();
    }
}
