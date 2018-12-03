class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        
        // Parent -> Children Map
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i=0; i<pid.size(); i++) {
            map.computeIfAbsent(ppid.get(i), e -> new ArrayList<>()).add(pid.get(i));
        }
        
        
        List<Integer> processesKilled = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(kill);
        
        while (!queue.isEmpty()) {
            int process = queue.remove();
            processesKilled.add(process);
            List<Integer> childrens = map.getOrDefault(process, new ArrayList<>());
            
            for (Integer child : childrens) {
                queue.add(child);
            }
        }
        
        return processesKilled;
    }
}
