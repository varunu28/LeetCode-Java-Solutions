class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        Map<Integer, Set<Integer>> map1 = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            map1.computeIfAbsent(A[i], k -> new HashSet<>()).add(i);
            map1.computeIfAbsent(B[i], k -> new HashSet<>()).add(i);
        }

        int min = Integer.MAX_VALUE;

        for (int key : map1.keySet()) {
            if (map1.get(key).size() >= A.length) {
                int cnt1 = findCount(A, B, key);
                int cnt2 = findCount(B, A, key);

                min = Math.min(cnt1, min);
                min = Math.min(cnt2, min);
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private int findCount(int[] a, int[] b, int key) {
        int cnt = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != key && b[i] == key) {
                cnt++;
            }
        }

        return cnt;
    }
}
