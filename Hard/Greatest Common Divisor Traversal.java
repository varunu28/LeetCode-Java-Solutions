class Solution {

    private static final int MAX = 100_000;

    public boolean canTraverseAllPairs(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return true;
        }
        boolean[] exists = new boolean[MAX + 1];
        for (int num : nums) {
            exists[num] = true;
        }
        if (exists[1]) {
            return false;
        }
        int[] sieve = new int[MAX + 1];
        for (int i = 2; i <= MAX; i++) {
            if (sieve[i] == 0) {
                for (int j = i; j <= MAX; j += i) {
                    sieve[j] = i;
                }
            }
        }
        Union union = new Union(2 * MAX + 1);
        for (int num : nums) {
            int curr = num;
            while (curr > 1) {
                int prime = sieve[curr];
                int root = prime + MAX;
                if (union.find(root) != union.find(num)) {
                    union.merge(root, num);
                }
                while (curr % prime == 0) {
                    curr /= prime;
                }
            }
        }
        int count = 0;
        for (int i = 2; i <= MAX; i++) {
            if (exists[i] && union.find(i) == i) {
                count++;
            }
        }
        return count == 1;
    }

    private class Union {
        private final int[] union;
        private final int[] size;

        public Union(int n) {
            this.union = new int[n + 1];
            this.size = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                union[i] = i;
                size[i] = 1;
            }
        }

        public int find(int num) {
            return union[num] == num ? num : (union[num] = find(union[num]));
        }

        public void merge(int x, int y) {
            int findX = find(x);
            int findY = find(y);
            if (findX == findY) {
                return;
            }
            if (size[findX] > size[findY]) {
                int temp = findX;
                findX = findY;
                findY = temp;
            }
            union[findX] = findY;
            size[findY] += size[findX];
        }
    }
}
