class Solution {
    public int minimizeXor(int num1, int num2) {
        int result = 0;
        int targetSetBitCount = Integer.bitCount(num2);
        int setBitCount = 0;
        int currBit = 31;
        while (setBitCount < targetSetBitCount) {
            if (isSet(num1, currBit) || (targetSetBitCount - setBitCount > currBit)) {
                result = setBit(result, currBit);
                setBitCount++;
            }
            currBit--;
        }
        return result;
    }

    private boolean isSet(int x, int bit) {
        return (x & (1 << bit)) != 0;
    }

    private int setBit(int x, int bit) {
        return x | (1 << bit);
    }
}
