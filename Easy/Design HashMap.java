class MyHashMap {

  /** Initialize your data structure here. */
  Integer[][] map;
  int NUM_OF_BUCKETS = 1000;
  int BUCKET_SIZE = 1000;
  public MyHashMap() {
    map = new Integer[NUM_OF_BUCKETS][BUCKET_SIZE];
  }

  /** value will always be non-negative. */
  public void put(int key, int value) {
    Integer[] bucket = getBucket(key);
    int keyHash = getKeyHash(key);
    bucket[keyHash] = value;
  }

  /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
  public int get(int key) {
    Integer[] bucket = getBucket(key);
    int keyHash = getKeyHash(key);
    return bucket[keyHash] == null ? -1 : bucket[keyHash];
  }

  /** Removes the mapping of the specified value key if this map contains a mapping for the key */
  public void remove(int key) {
    Integer[] bucket = getBucket(key);
    int keyHash = getKeyHash(key);
    bucket[keyHash] = null;
  }
  
  private Integer[] getBucket(int key) {
    int bucketIdx = key / BUCKET_SIZE;
    return map[bucketIdx];
  }
  
  private Integer getKeyHash(int key) {
    return key % BUCKET_SIZE;
  }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
