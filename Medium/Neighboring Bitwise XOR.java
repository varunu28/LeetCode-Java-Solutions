class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int n = derived.length;
        int[] original = new int[n + 1];
        for (int i = 0; i < derived.length; i++) {
            original[i + 1] = derived[i] ^ original[i];
        }
        boolean checkForZero = (original[0] == original[n]);
        original[0] = 1;
        for (int i = 0; i < n; i++) {
            original[i + 1] = derived[i] ^ original[i];
        }
        boolean checkForOne = (original[0] == original[n]);
        return checkForZero || checkForOne;
    }
}
