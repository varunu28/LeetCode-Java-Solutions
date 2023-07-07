class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int resultSize = k;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            map.put(answerKey.charAt(i), map.getOrDefault(answerKey.charAt(i), 0) + 1);
        }
        int start = 0;
        for (int i = k; i < answerKey.length(); i++) {
            map.put(answerKey.charAt(i), map.getOrDefault(answerKey.charAt(i), 0) + 1);
            while (Math.min(map.getOrDefault('T', 0), map.getOrDefault('F', 0)) > k) {
                map.put(answerKey.charAt(start), map.get(answerKey.charAt(start)) - 1);
                start++;
            }
            resultSize = Math.max(resultSize, i - start + 1);
        }
        return resultSize;
    }
}
