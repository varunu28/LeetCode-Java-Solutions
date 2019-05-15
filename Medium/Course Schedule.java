class Solution {
    Set<Integer> set = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] prereq : prerequisites) {
            map.computeIfAbsent(prereq[0], k -> new HashSet<>()).add(prereq[1]);
        }
        
        for (int i = 0; i < numCourses; i++) {
            set.clear();
            dfsHelper(map, i);
            
            if (set.contains(i)) {
                return false;
            }
        }
        
        return true;
    }
    
    private void dfsHelper(Map<Integer, Set<Integer>> map, int courseNum) {
        Iterator<Integer> iterator = map.getOrDefault(courseNum, new HashSet<>()).iterator();
        while (iterator.hasNext()) {
            int course = iterator.next();
            if (!set.contains(course)) {
                set.add(course);
                dfsHelper(map, course);
            }
        }
    }
}
