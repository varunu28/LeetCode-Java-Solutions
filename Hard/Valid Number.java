class Solution {
        public boolean isNumber(String s) {
        s = s.trim();
        char[] ch = s.toCharArray();
        int idx = 0;
        int n = ch.length;
        boolean signFound = false;
        boolean decimalFound = false;
        boolean numFound = false;
        boolean expoFound = false;

        while (idx < n) {
            if (ch[idx] == '+' || ch[idx] == '-') {
                if (numFound || signFound || decimalFound) {
                    return false;
                }

                signFound = true;
            }
            else if (ch[idx] == '.') {
                if (decimalFound) {
                    return false;
                }
                decimalFound = true;
            }
            else if (Character.isLetter(ch[idx])) {
                if (ch[idx] == 'e') {
                    if (!numFound) {
                        return false;
                    }
                    idx++;
                    expoFound = true;
                    break;
                }
                else {
                    return false;
                }
            }
            else if (Character.isDigit(ch[idx])) {
                numFound = true;
            }
            else if (ch[idx] == ' ') {
                if (numFound || signFound || decimalFound) {
                    return false;
                }
            }

            idx++;
        }

        if (!numFound) {
            return false;
        }

        if (expoFound && idx == n) {
            return false;
        }

        signFound = false;
        numFound = false;
        while (idx < n) {
            if (ch[idx] == '.') {
                return false;
            }
            else if (ch[idx] == '+' || ch[idx] == '-') {
                if (signFound) {
                    return false;
                }
                if (numFound) {
                    return false;
                }
                signFound = true;
            }
            else if (Character.isDigit(ch[idx])) {
                numFound = true;
            }
            else {
                return false;
            }

            idx++;
        }

        if (expoFound && !numFound) {
            return false;
        }

        return true;
    }
}
