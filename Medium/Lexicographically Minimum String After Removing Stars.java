class Solution {
    public String clearStars(String s) {
        Deque<Integer>[] count = new Deque[26];
        for (int i = 0; i < 26; i++) {
            count[i] = new ArrayDeque<>();
        }
        char[] letters = s.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] != '*') {
                count[letters[i] - 'a'].push(i);
            } else {
                for (int j = 0; j < 26; j++) {
                    if (!count[j].isEmpty()) {
                        letters[count[j].pop()] = '*';
                        break;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : letters) {
            if (c != '*') {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
