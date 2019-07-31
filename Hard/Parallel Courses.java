class Solution {
    public int minimumSemesters(int N, int[][] relations) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        // A prerequisite counter for each course
        int[] prereqs = new int[N + 1];
        
        for (int[] relation : relations) {
            map.computeIfAbsent(relation[0], k-> new ArrayList<>()).add(relation[1]);
            prereqs[relation[1]]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        // Add all the courses which have no prerequisite
        // So that we can take those courses in first semester
        for (int i = 1; i <= N; i++) {
            if (prereqs[i] == 0) {
                queue.add(i);
            }
        }
        
        int semester = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int course = queue.poll();
                // Decrement N as we have taken a course that is removed from the queue
                N--;
                for (int pre : map.getOrDefault(course, new ArrayList<>())) {
                    /*
                    If a course which depends upon the removed course had only the removed course as prereq then we can
                    add it to the queue
                    */
                    if (--prereqs[pre] == 0) {
                        queue.add(pre);
                    }
                }
            }
            
            // Semester over. New semester starts
            semester++;
        }

        return N == 0 ? semester : -1;
    }
}
