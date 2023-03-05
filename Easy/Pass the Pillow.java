class Solution {
    public int passThePillow(int n, int time) {
        int factor = time / (n - 1);
        int remainder = time % (n - 1);
        return factor % 2 != 0 ? (n - remainder) : (1 + remainder);
    }
}
