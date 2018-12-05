class Solution {
    Set<Integer> dfs;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Set<Integer> numOfCoursesTaken = new HashSet<>();
        
        for (int[] prerequisite : prerequisites) {
            map.computeIfAbsent(prerequisite[0], e -> new HashSet<>()).add(prerequisite[1]);
        }
        
        for (int i=0; i<numCourses; i++) {
            dfs = new HashSet<>();
            dfsHelper(map, i);
            
            if (dfs.contains(i)) {
                return false;
            }
            
            numOfCoursesTaken.add(i);
        }
        
        return numOfCoursesTaken.size() == numCourses;
    }
    
    private void dfsHelper(Map<Integer, Set<Integer>> map, int courseNum) {
        Iterator<Integer> iterator = map.getOrDefault(courseNum, new HashSet<>()).iterator();
        while (iterator.hasNext()) {
            int course = iterator.next();
            if (!dfs.contains(course)) {
                dfs.add(course);
                dfsHelper(map, course);
            }
        }
    }
}
