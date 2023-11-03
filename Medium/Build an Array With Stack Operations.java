class Solution {

    private static final String PUSH = "Push";
    private static final String POP = "Pop";

    public List<String> buildArray(int[] target, int n) {
        int idx = 0;
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (target[idx] == i) {
                idx++;
                result.add(PUSH);
            } else {
                result.add(PUSH);
                result.add(POP);
            }
            if (idx == target.length) {
                break;
            }
        }
        return result;
    }
}
