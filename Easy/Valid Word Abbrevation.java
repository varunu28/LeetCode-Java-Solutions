class Solution {
    public static boolean validWordAbbreviation(String word, String abbr) {
        char[] wordChar = word.toCharArray();
        char[] abbrChar = abbr.toCharArray();

        int i = 0;
        int j = 0;

        while (j < abbrChar.length && i < wordChar.length) {
            if (abbrChar[j] == wordChar[i]) {
                i++;
                j++;
                continue;
            }

            if (abbrChar[j] <= '0' || abbrChar[j] > '9') {
                return false;
            }

            int start = j;
            while (j<abbrChar.length && abbrChar[j] >= '0' && abbrChar[j] <= '9') {
                ++j;
            }

            int num = Integer.valueOf(abbr.substring(start, j));
            i += num;
        }

        return i == wordChar.length && j == abbrChar.length;
    }
}
