class Solution {
    int[] keys;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        keys = new int[rooms.size()];
        keys[0] = 1;
        
        dfs(rooms, 0);
        
        for (int key : keys) {
            if (key == 0) {
                return false;
            }
        }
        
        return true;
    }
    
    private void dfs(List<List<Integer>> rooms, int k) {
        for (int key : rooms.get(k)) {
            if (keys[key] == 0) {
                keys[key]++;
                dfs(rooms, key);
            }
        }
    }
}
