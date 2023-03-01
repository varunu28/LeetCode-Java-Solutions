class SnapshotArray {
    
    private final TreeMap<Integer, Integer>[] db;
    private int currentSnapId;

    public SnapshotArray(int length) {
        db = new TreeMap[length];
        for (int i = 0; i < length; i++) {
            db[i] = new TreeMap<Integer, Integer>();
            db[i].put(0, 0);
        }
        this.currentSnapId = 0;
    }

    public void set(int index, int val) {
        db[index].put(currentSnapId, val);
    }

    public int snap() {
        return currentSnapId++;
    }

    public int get(int index, int snap_id) {
        return db[index].floorEntry(snap_id).getValue();
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
