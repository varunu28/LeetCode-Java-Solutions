class Solution {
    public int numberOfDays(int Y, int M) {
        int[] arr = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (M == 2) {
            return isLeapYear(Y) ? arr[M - 1] + 1 : arr[M - 1];
        }

        return arr[M- 1];
    }

    private boolean isLeapYear (int y) {
        if (y % 4  == 0) {
            if (y % 100 == 0) {
                return y % 400 == 0;
            }
            else {
                return true;
            }
        }
        else {
            return false;
        }
    }
}
