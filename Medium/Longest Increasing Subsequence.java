class Solution {
    public int lengthOfLIS(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        
        int[] temp = new int[arr.length];
        Arrays.fill(temp, 1);

        for (int i=1; i<arr.length; i++) {
            for (int j=0; j<i; j++) {
                if (arr[j] < arr[i]) {
                    temp[i] = Math.max(temp[i], temp[j] + 1);
                }
            }
        }

        return Arrays.stream(temp).max().getAsInt();
    }
}
