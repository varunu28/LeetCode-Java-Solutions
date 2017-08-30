class Solution {
    public int findComplement(int num) {
        return getDecimalVal(flip(getBinaryVal(num)));
    }
    
    public String getBinaryVal(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(String.valueOf(n%2));
            n /= 2;
        }
        return sb.reverse().toString();
    }

    public String flip(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<s.length();i++) {
            if (s.charAt(i) == '1') {
                sb.append("0");
            }
            else {
                sb.append("1");
            }
        }
        return sb.reverse().toString();
    }

    public int getDecimalVal(String s) {
        int n = 0;

        for (int i=0;i<s.length();i++) {
            int mul = (int)Math.pow(2, i);
            int num = Integer.parseInt(String.valueOf(s.charAt(i)));
            n += mul*num;
        }
        return n;
    }
}