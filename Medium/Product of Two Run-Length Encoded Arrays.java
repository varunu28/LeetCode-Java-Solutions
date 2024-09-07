class Solution {
    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
        int idxOne = 0;
        int idxTwo = 0;
        List<List<Integer>> result = new ArrayList<>();
        while (idxOne < encoded1.length && idxTwo < encoded2.length) {
            int valOne = encoded1[idxOne][0];
            int valTwo = encoded2[idxTwo][0];
            int countOne = encoded1[idxOne][1];
            int countTwo = encoded2[idxTwo][1];
            int value = valOne * valTwo;
            int count = Math.min(countOne, countTwo);
            encoded1[idxOne][1] -= count;
            encoded2[idxTwo][1] -= count;
            if (encoded1[idxOne][1] == 0) {
                idxOne++;
            }
            if (encoded2[idxTwo][1] == 0) {
                idxTwo++;
            }
            if (!result.isEmpty() && result.get(result.size() - 1).get(0) == value) {
                int existingCount = result.get(result.size() - 1).get(1);
                int newCount = existingCount + count;
                result.get(result.size() - 1).set(1, newCount);
            } else {
                result.add(Arrays.asList(value, count));
            }
        }
        return result;
    }
}
