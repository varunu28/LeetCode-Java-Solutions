class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> deadEndSet = new HashSet<>(Arrays.asList(deadends));
        if (deadEndSet.contains(target) || deadEndSet.contains("0000")) {
            return -1;
        }
        Queue<String> queue = new LinkedList<>();
        Set<String> seen = new HashSet<>();
        queue.add("0000");
        seen.add("0000");
        int steps = 0;
        int[] rotations = {-1, 1};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String removed = queue.remove();
                if (removed.equals(target)) {
                    return steps;
                }
                if (deadEndSet.contains(removed)) {
                    continue;
                }
                for (int j = 0; j < 4; j++) {
                    for (int rotation : rotations) {
                        int changedVal = ((removed.charAt(j) - '0') + rotation + 10) % 10;
                        String newRotation = new StringBuilder()
                                                    .append(removed.substring(0,j))                                                                                         .append(changedVal)
                                                    .append(removed.substring(j + 1))
                                                    .toString();
                        if (!seen.contains(newRotation)) {
                            seen.add(newRotation);
                            queue.add(newRotation);
                        }
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}
