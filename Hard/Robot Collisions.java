class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (a, b) -> Integer.compare(positions[a], positions[b]));
        Stack<Integer> stack = new Stack<>();
        for (Integer index : indices) {
            if (directions.charAt(index) == 'R') {
                stack.push(index);
            } else {
                while (!stack.isEmpty() && healths[index] > 0) {
                    int poppedIndex = stack.pop();
                    if (healths[poppedIndex] > healths[index]) {
                        healths[poppedIndex]--;
                        healths[index] = 0;
                        stack.push(poppedIndex);
                    } else if (healths[poppedIndex] < healths[index]) {
                        healths[index]--;
                        healths[poppedIndex] = 0;
                    } else {
                        healths[poppedIndex] = 0;
                        healths[index] = 0;
                    }
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (healths[i] > 0) {
                result.add(healths[i]);
            }
        }
        return result;
    }
}
