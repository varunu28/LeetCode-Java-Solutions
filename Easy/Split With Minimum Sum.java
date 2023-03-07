class Solution {
    public int splitNum(int num) {
        List<Integer> digits = new ArrayList<>();
        while (num > 0) {
            digits.add(num % 10);
            num /= 10;
        }
        Collections.sort(digits);
        int numOne = 0;
        int numTwo = 0;
        boolean flag = true;
        for (int digit : digits) {
            if (flag) {
                numOne = numOne * 10 + digit;
            } else {
                numTwo = numTwo * 10 + digit;
            }
            flag = !flag;
        }
        return numOne + numTwo;
    }
}
