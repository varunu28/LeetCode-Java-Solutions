class Solution {
    public int numberOfBeams(String[] bank) {
        int beamCount = 0;
        int prevLaserCount = 0;
        for (String row : bank) {
            int count = 0;
            for (char c : row.toCharArray()) {
                count += c == '1' ? 1 : 0;
            }
            if (count > 0) {
                beamCount += prevLaserCount * count;
                prevLaserCount = count;
            }
        }
        return beamCount;
    }
}
