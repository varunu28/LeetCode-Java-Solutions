class Solution {
    public int maximumGain(String s, int x, int y) {
        // Swap if x < y so we can follow a single iteration
        if (x < y) {
            int temp = x;
            x = y;
            y = temp;
            s = new StringBuilder(s).reverse().toString();
        }
        int countA = 0;
        int countB = 0;
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a') {
                countA++;
            } else if (c == 'b') {
                // Make a pair to consume the excess 'a' count
                if (countA > 0) {
                    countA--;
                    total += x;
                } else {
                    countB++;
                }
            } else {
                // Consume any possible number of pairs & reset the counter
                total += Math.min(countA, countB) * y;
                countA = 0;
                countB = 0;
            }
        }
        total += Math.min(countA, countB) * y;
        return total;
    }
}
