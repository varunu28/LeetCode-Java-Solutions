class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<SchoolClass> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int[] schoolClass : classes) {
            pq.add(new SchoolClass(schoolClass[0], schoolClass[1]));
        }
        while (extraStudents-- > 0) {
            SchoolClass schoolClass = pq.poll();
            schoolClass.increment();
            pq.add(schoolClass);
        }
        double totalPassingRatio = 0.0;
        while (!pq.isEmpty()) {
            totalPassingRatio += pq.poll().passRatio();
        }
        return totalPassingRatio / classes.length;
    }

    static class SchoolClass implements Comparable<SchoolClass> {

        private int passingStudents;
        private int totalStudents;

        public SchoolClass(int passingStudents, int totalStudents) {
            this.passingStudents = passingStudents;
            this.totalStudents = totalStudents;
        }

        void increment() {
            passingStudents++;
            totalStudents++;
        }

        double passRatio() {
            return ((double) passingStudents) / totalStudents;
        }

        double gain() {
            return ((double) (passingStudents + 1) / (totalStudents + 1)) - passRatio();
        }

        @Override
        public int compareTo(SchoolClass o) {
            return Double.compare(gain(), o.gain());
        }
    }
}
