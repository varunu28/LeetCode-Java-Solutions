class SnapshotArray {
  TreeMap<Integer, Integer>[] A;
  int snapId;
  public SnapshotArray(int length) {
    A = new TreeMap[length];
    snapId = 0;
    for (int i = 0; i < length; i++) {
      A[i] = new TreeMap<Integer, Integer>();
      A[i].put(0, 0);
    }
  }

  public void set(int index, int val) {
    A[index].put(snapId, val);
  }

  public int snap() {
    return snapId++;
  }

  public int get(int index, int snap_id) {
    return A[index].floorEntry(snap_id).getValue();
  }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
