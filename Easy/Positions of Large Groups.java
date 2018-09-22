class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> positions = new ArrayList<>();

        int i = 1;
        int count = 1;
        int start = 0;

        while (i < S.length()) {
            if (S.charAt(i) == S.charAt(i-1)) {
                count++;
            }
            else {
                if (count >= 3) {
                    List<Integer> temp = Arrays.asList(start, i-1);
                    positions.add(temp);
                }

                start = i;
                count = 1;
            }

            i++;
        }

        if (count >= 3) {
            positions.add(Arrays.asList(start, i-1));
        }

        return positions;
    }
}
