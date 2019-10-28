class Solution {
    public int oddEvenJumps(int[] A) {
        if (A.length <= 1) {
            return A.length;
        }
        boolean[] odd = new boolean[A.length];
        boolean[] even = new boolean[A.length];
        odd[A.length - 1] = even[A.length - 1] = true;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(A[A.length - 1], A.length - 1);
        for (int i = A.length - 2; i >= 0; i--) {
            int val = A[i];
            if (treeMap.containsKey(val)) {
                odd[i] = even[treeMap.get(val)];
                even[i] = odd[treeMap.get(val)];
            }
            else {
                Integer lower = treeMap.lowerKey(val);
                Integer higher = treeMap.higherKey(val);
                if (lower != null) {
                    even[i] = odd[treeMap.get(lower)];
                }
                if (higher != null) {
                    odd[i] = even[treeMap.get(higher)];
                }
            }
            treeMap.put(val, i);
        }
        int count = 0;
        for (boolean b : odd) {
            if (b) {
                count++;
            }
        }
        return count;
    }
}
