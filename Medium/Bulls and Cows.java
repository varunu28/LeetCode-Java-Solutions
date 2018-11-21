class Solution {
    public String getHint(String secret, String guess) {
        char[] secretChar = secret.toCharArray();
        char[] guessChar = guess.toCharArray();
        
        int[] secCount = new int[10];
        int[] guessCount = new int[10];
        
        for (int c : secretChar) {
            secCount[c - '0']++;
        }
        
        for (int c : guessChar) {
            guessCount[c - '0']++;
        }
        
        int sames = 0;
        for (int i=0; i<secCount.length; i++) {
            sames += Math.min(secCount[i], guessCount[i]);
        }
        
        int numOfBulls = 0;
        for (int i=0; i<secretChar.length; i++) {
            if (secretChar[i] == guessChar[i]) {
                numOfBulls++;
            }
        }
        
        int numOfCows = sames - numOfBulls;
        
        StringBuilder sb = new StringBuilder();
        sb.append(numOfBulls).append("A").append(numOfCows).append("B");

        return sb.toString();
    }
}
