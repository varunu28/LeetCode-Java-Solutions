class Solution {
    public static String multiply(String num1, String num2) {
        int[] ans = new int[num1.length() * num2.length() + 1];
        int pointer = ans.length-1;
        int carry = 0;

        for (int i=num2.length()-1; i>=0; i--) {
            int k = pointer;
            for (int j=num1.length()-1; j>=0; j--) {
                int prod = ans[k] + (num1.charAt(j) - '0') * (num2.charAt(i) - '0')+ carry;
                if (prod > 9) {
                    carry = prod/10;
                    prod = prod%10;
                }
                else {
                    carry = 0;
                }

                ans[k--] = prod;
            }

            while (carry > 0) {
                int prod = ans[k] + carry;
                if (prod > 9) {
                    carry = prod/10;
                    prod = prod%10;
                }
                else {
                    carry = 0;
                }

                ans[k--] = prod;
            }

            pointer--;
        }

        int start = 0;

        while (start < ans.length && ans[start] == 0) {
            start++;
        }

        StringBuilder sb = new StringBuilder();
        while (start < ans.length) {
            sb.append(ans[start++]);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}
