class SnapshotArray {

    int[] arr;
    Map<Integer, Map<Integer, Integer>> map;
    int count;
    Map<Integer, Integer> temp;
    public SnapshotArray(int length) {
        arr = new int[length];
        map = new HashMap<>();
        count = 0;
        temp = new HashMap<>();
    }

    public void set(int index, int val) {
        arr[index] = val;
        temp.put(index, val);
    }

    public int snap() {
        map.put(count, new HashMap<>(temp));
        int snapCount = count++;
        temp = new HashMap<>();
        return snapCount;
    }

    public int get(int index, int snap_id) {
        while (snap_id >= 0) {
            if (map.get(snap_id).containsKey(index)) {
                return map.get(snap_id).get(index);
            }

            snap_id--;
        }

        return 0;
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
