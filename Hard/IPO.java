class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        Project[] projects = new Project[n];
        int maximumCapital = w;
        for (int i = 0; i < n; i++) {
            projects[i] = new Project(capital[i], profits[i]);
        }
        Arrays.sort(projects);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int idx = 0;
        for (int i = 0; i < k; i++) {
            while (idx < n && projects[idx].capital <= maximumCapital) {
                pq.add(projects[idx++].profit);
            }
            if (pq.isEmpty()) {
                break;
            }
            maximumCapital += pq.poll();
        }
        return maximumCapital;
    }
    
    private record Project(int capital, int profit) implements Comparable<Project> {

        @Override
        public int compareTo(Project o) {
            return capital - o.capital;
        }
    }
}
