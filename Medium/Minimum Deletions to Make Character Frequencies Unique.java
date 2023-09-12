class Solution {
    public int minDeletions(String s) {
        int[] frequency = new int[26];
        for (char c : s.toCharArray()) {
            frequency[c - 'a']++;
        }
        Arrays.sort(frequency);
        int numOfDeletions = 0;
        int expectedFrequency = frequency[25];
        for (int i = 25; i >= 0; i--) {
            if (frequency[i] == 0) {
                break;
            }
            if (frequency[i] > expectedFrequency) {
                numOfDeletions += frequency[i] - expectedFrequency;
            } else {
                expectedFrequency = frequency[i];
            }
            if (expectedFrequency > 0) {
                expectedFrequency--;
            }
        }
        return numOfDeletions;
    }
}
