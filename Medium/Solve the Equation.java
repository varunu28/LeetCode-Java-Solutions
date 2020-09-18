class Solution {
    public String solveEquation(String equation) {
        int leftXCount = 0;
        int rightXCount = 0;
        int leftNumCount = 0;
        int rightNumCount = 0;
        boolean switchDone = false;
        int sign = 1;
        StringBuilder sb = new StringBuilder();

        for (char c : equation.toCharArray()) {
            if (c == '=') {
                if (sb.length() > 0) {
                    leftNumCount += sign * Integer.parseInt(sb.toString());
                    sb.setLength(0);
                    sign = 1;
                }

                switchDone = true;
                continue;
            }

            if (c == 'x') {
                if (switchDone) {
                    rightXCount += sign * (sb.length() > 0 ? Integer.parseInt(sb.toString()) : 1);
                }
                else {
                    leftXCount += sign * (sb.length() > 0 ? Integer.parseInt(sb.toString()) : 1);
                }

                sign = 1;
                sb.setLength(0);
            }
            else if (Character.isDigit(c)) {
                sb.append(c);
            }
            else if (c == '+' || c == '-') {
                if (sb.length() > 0) {
                    if (switchDone) {
                        rightNumCount += sign * (Integer.parseInt(sb.toString()));
                    }
                    else {
                        leftNumCount += sign * (Integer.parseInt(sb.toString()));
                    }

                    sb.setLength(0);
                }

                sign = c == '+' ? 1 : -1;
            }
        }

        if (sb.length() > 0) {
            rightNumCount += sign * Integer.parseInt(sb.toString());
        }

        if (leftXCount == rightXCount && leftNumCount != rightNumCount) {
            return "No solution";
        }
        else if (leftXCount == rightXCount && leftNumCount == rightNumCount) {
            return "Infinite solutions";
        }
        else {
            int totalXCount = leftXCount - rightXCount;
            int totalValueCount = rightNumCount - leftNumCount;

            int gcd = getGcd(totalXCount, totalValueCount);
            if (gcd != 0) {
                totalXCount /= gcd;
                totalValueCount /= gcd;
            }

            if (totalXCount < 0) {
                totalXCount *= -1;
                totalValueCount *= -1;
            }

            return new StringBuilder()
                            .append(totalXCount > 1 ? totalXCount : "")
                            .append("x=")
                            .append(totalValueCount)
                            .toString();
        }
    }

    private int getGcd(int totalXCount, int totalValueCount) {
        if (totalXCount == 0) {
            return totalValueCount;
        }

        return getGcd(totalValueCount % totalXCount, totalXCount);
    }
}
