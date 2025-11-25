class Solution {
    public int minimumFlips(int n) {
        String binary = Integer.toBinaryString(n);
        int size = binary.length();
        int flips = 0;
        for (int i = 0; i < size; i++) {
            if (binary.charAt(i) != binary.charAt(size - i - 1)) {
                flips++;
            }
        }
        return flips;
    }
}
