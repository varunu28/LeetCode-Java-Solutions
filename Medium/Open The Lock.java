class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> deadEndSet = new HashSet<>(Arrays.asList(deadends));
        String startingPoint = "0000";
        if (deadEndSet.contains(startingPoint)) {
            return -1;
        }
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(startingPoint);
        visited.add(startingPoint);
        int attempts = 0;
        int[] rotations = {-1, 1};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String removed = queue.remove();
                if (removed.equals(target)) {
                    return attempts;
                }
                if (deadEndSet.contains(removed)) {
                    continue;
                }
                for (int j = 0; j < 4; j++) {
                    for (int rotation : rotations) {
                        int newValue = ((removed.charAt(j) - '0') + rotation + 10) % 10;
                        String newRotation = removed.substring(0, j) + newValue + removed.substring(j + 1);
                        if (!visited.contains(newRotation)) {
                            visited.add(newRotation);
                            queue.add(newRotation);
                        }
                    }
                }
            }
            attempts++;
        }
        return -1;
    }
}
