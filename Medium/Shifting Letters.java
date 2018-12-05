class Solution {
    public String shiftingLetters(String S, int[] shifts) {
        long[] numOfShifts = getNumOfShifts(shifts);
        String shiftedString = getShiftedString(S, numOfShifts);
        
        return shiftedString;
    }
    
    private long[] getNumOfShifts(int[] shifts) {
        long totalShifts = 0;
        long[] cumulativeSum = new long[shifts.length];
        for (int i=0; i<shifts.length; i++) {
            totalShifts += shifts[i];
            cumulativeSum[i] = totalShifts;
        }
        
        long[] numOfShifts = new long[shifts.length];
        
        for (int i=0; i<shifts.length; i++) {
            numOfShifts[i] = (totalShifts - (i > 0 ? cumulativeSum[i-1] : 0)) % 26;
        }
        
        return numOfShifts;
    }
    
    private String getShiftedString(String s, long[] numOfShifts) {
        StringBuilder sb = new StringBuilder();
        
        for (int i=0; i<numOfShifts.length; i++) {
            long shiftedValue = (int) s.charAt(i) + numOfShifts[i];
            if (shiftedValue > 122) {
                shiftedValue = 96 + (shiftedValue - 122); 
            }
            
            sb.append((char) shiftedValue);
        }
        
        return sb.toString();
    }
}
