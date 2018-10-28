class Solution {
    public int numSubarraysWithSum(int[] A, int S) {
        Map<Integer, Integer> c = new HashMap<>();

        c.put(0, 1);

        int psum = 0;
        int res = 0;

        for (int i : A) {
            psum += i;
            res += c.getOrDefault(psum - S, 0);
            c.put(psum, c.getOrDefault(psum, 0)+1);
        }

        return res;
    }
}
