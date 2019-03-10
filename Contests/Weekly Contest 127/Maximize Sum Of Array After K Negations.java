class Solution {
    public int largestSumAfterKNegations(int[] A, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : A) {
            pq.add(num);
        }

        while (K-- > 0) {
            int popped = pq.poll();
            popped *= -1;

            pq.add(popped);
        }
        
        int sum = 0;
        while (!pq.isEmpty()) {
            sum += pq.poll();
        }

        return sum;
    }
}
