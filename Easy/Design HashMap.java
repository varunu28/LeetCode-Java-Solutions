class MyHashMap {

    private static final int BUCKET_COUNT = 1001;

    private static final int BUCKET_SIZE = 1001;

    private final Integer[][] map;

    public MyHashMap() {    
        this.map = new Integer[BUCKET_COUNT][BUCKET_SIZE];
    }
    
    public void put(int key, int value) {
        Position position = getPosition(key);
        map[position.bucket()][position.index()] = value;
    }
    
    public int get(int key) {
        Position position = getPosition(key);
        Integer value = map[position.bucket()][position.index()];
        return value == null ? -1 : value;
    }
    
    public void remove(int key) {
        Position position = getPosition(key);
        map[position.bucket()][position.index()] = null;
    }

    private static Position getPosition(int key) {
        int bucket = key / BUCKET_COUNT;
        int index = key % BUCKET_SIZE;
        return new Position(bucket, index);
    }

    private static record Position(int bucket, int index) {
      
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
