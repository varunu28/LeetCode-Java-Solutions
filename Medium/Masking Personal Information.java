class Solution {
    public static String maskPII(String S) {
        if (S.length() == 0) {
            return S;
        }
        
        if (S.indexOf('@') != -1) {
            return formatEmail(S);
        }
        else {
            return formatNumber(S);
        }
    }

    private static String formatNumber(String s) {
        StringBuilder sb = new StringBuilder();
        int digitCount = getDigitCount(s);

        if (digitCount > 10) {
            sb.append("+");
            int extra = digitCount - 10;
            while (extra-- > 0) {
                sb.append("*");
            }
            sb.append("-");
        }
        sb.append("***-***-");

        StringBuilder last4 = new StringBuilder();
        for (int i=s.length()-1; i>=0; i--) {
            if (Character.isDigit(s.charAt(i))) {
                last4.append(s.charAt(i));
            }

            if (last4.length() == 4) {
                break;
            }
        }

        sb.append(last4.reverse().toString());

        return sb.toString();
    }

    private static int getDigitCount(String s) {
        char[] chars = s.toCharArray();
        int count = 0;

        for (char c : chars) {
            if (Character.isDigit(c)) {
                count++;
            }
        }

        return count;
    }

    private static String formatEmail(String s) {
        int idx = s.indexOf('@');
        int revStart = idx - 1;
        while (revStart >= 0 && Character.isLetter(s.charAt(revStart))) {
            revStart--;
        }

        StringBuilder sb = new StringBuilder();

        sb.
        append(s.substring(0, revStart+1)).
        append(Character.toLowerCase(s.charAt(revStart + 1))).
        append("*****").
        append(Character.toLowerCase(s.charAt(s.indexOf('@') - 1))).
        append(s.substring(s.indexOf('@')));

        return sb.toString().toLowerCase();
    }
}
