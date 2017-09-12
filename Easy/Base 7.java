class Solution {
    public String convertToBase7(int num) {
        if (num == 0) return "0";
        int temp = Math.abs(num);
        StringBuilder sb = new StringBuilder("");
        while (temp > 0) {
            sb.append(String.valueOf(temp%7));
            temp /= 7;
        }
        return num < 0 ? "-" + sb.reverse().toString() : sb.reverse().toString();
    }
}
