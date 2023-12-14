class Solution {
    public List<Integer> getGoodIndices(int[][] variables, int target) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < variables.length; i++) {
            int a = variables[i][0];
            int b = variables[i][1];
            int c = variables[i][2];
            int m = variables[i][3];
            int base = 1;
            for (int j = 0; j < b; j++) {
                base = (base * a) % 10;
            }
            int value = 1;
            for (int j = 0; j < c; j++) {
                value = (value * base) % m;
            }
            if (value == target) {
                result.add(i);
            }
        }
        return result;
    }
}
