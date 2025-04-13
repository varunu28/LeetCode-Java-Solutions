class Solution {
    public int findClosest(int x, int y, int z) {
        int diffOne = Math.abs(x - z);
        int diffTwo = Math.abs(y - z);
        return diffOne == diffTwo ? 0 : (diffOne < diffTwo ? 1 : 2);
    }
}
