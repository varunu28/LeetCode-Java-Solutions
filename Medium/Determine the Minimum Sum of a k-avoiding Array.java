class Solution {
    public int minimumSum(int n, int k) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        int sum = 1;
        int next = 2;
        while (n > 1) {
            if (set.contains(k - next)) {
                next++;
                continue;
            }
            set.add(next);
            sum += next++;
            n--;
        }
        return sum;
    }
}
