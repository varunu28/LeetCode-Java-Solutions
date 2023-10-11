class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int[] peopleCopy = Arrays.copyOf(people, people.length);
        Arrays.sort(peopleCopy);
        Arrays.sort(flowers, (a, b) -> Arrays.compare(a, b));
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int idx = 0;
        for (int person : peopleCopy) {
            while (idx < flowers.length && flowers[idx][0] <= person) {
                pq.add(flowers[idx][1]);
                idx++;
            }
            while (!pq.isEmpty() && pq.peek() < person) {
                pq.poll();
            }
            map.put(person, pq.size());
        }
        int[] result = new int[people.length];
        for (int i = 0; i < people.length; i++) {
            result[i] = map.get(people[i]);
        }
        return result;
    }
}
