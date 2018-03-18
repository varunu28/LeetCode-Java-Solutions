class Solution {
    public int rotatedDigits(int N) {
        int count = 0;
        for (int i=1;i<=N;i++) {
            if (isValid(i)) {
            	count++;
            }
        }
        return count;
    }

    public boolean isValid(int n) {
    	String s = String.valueOf(n);
        if (s.contains("3") || s.contains("4") || s.contains("7")) {
            return false;
        }
        
        StringBuilder sb = new StringBuilder("");

        for (char c : s.toCharArray()) {
            if (c == '2') {
                sb.append('5');
            }
            else if (c == '5') {
                sb.append('2');
            }
            else if (c == '6') {
                sb.append('9');
            }
            else if (c == '9') {
                sb.append('6');
            }
            else {
                sb.append(c);
            }
        }
        
        return !sb.toString().equals(s)
	}
}