class Solution {
    public String finalString(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        boolean flip = false;
        for (char c : s.toCharArray()) {
            if (c == 'i') {
                flip = !flip;
            } else {
                if (flip) {
                    deque.addFirst(c);
                } else {
                    deque.addLast(c);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : deque){
            sb.append(c);
        }
        return flip ? sb.reverse().toString() : sb.toString();
    }
}
