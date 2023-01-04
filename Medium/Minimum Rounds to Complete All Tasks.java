class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Long> frequencyMap = Arrays.stream(tasks)
            .boxed()
            .collect(Collectors.groupingBy(
                Function.identity(), 
                HashMap::new, 
                Collectors.counting()));
        int rounds = 0;
        for (Long occurrences : frequencyMap.values()) {
            if (occurrences == 1) {
                return -1;
            }
            if (occurrences % 3 == 0) {
                rounds += (int) (occurrences / 3);
            } else {
                rounds += (int) (occurrences / 3 + 1);
            }
        }
        return rounds;
    }
}
