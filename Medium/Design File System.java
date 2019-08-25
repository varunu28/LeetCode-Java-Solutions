class FileSystem {

    Map<String, Integer> map;
    public FileSystem() {
        map = new HashMap<>();
    }
    
    public boolean create(String path, int value) {
        if (map.containsKey(path)) {
            return false;
        }
        int lastIdx = path.lastIndexOf('/');
        if (lastIdx != 0 && !map.containsKey(path.substring(0, lastIdx))) {
            return false;
        }    
        map.put(path, value);
        return true;
    }
    
    public int get(String path) {
        return map.getOrDefault(path, -1);
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.create(path,value);
 * int param_2 = obj.get(path);
 */
