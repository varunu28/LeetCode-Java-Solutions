class Solution {

    private static final char[] CHOICES = {'A', 'C', 'G', 'T'};

    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> validMutations = new HashSet<>();
        for (String mutation : bank) {
            validMutations.add(mutation);
        }
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(startGene);
        visited.add(startGene);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String node = queue.remove();
                if (node.equals(endGene)) {
                    return count;
                }
                for (char choice : CHOICES) {
                    for (int i = 0; i < node.length(); i++) {
                        String nextNode = node.substring(0, i) + choice + node.substring(i + 1);
                        if (validMutations.contains(nextNode) && !visited.contains(nextNode)) {
                            queue.add(nextNode);
                            visited.add(nextNode);
                        }
                    }
                }
            }
            count++;
        }
        return -1;
    }
}
