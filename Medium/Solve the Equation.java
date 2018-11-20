class Solution {
    public String solveEquation(String equation) {
        String[] sides = equation.split("=");

        int[] leftVal = getParsedValue(sides[0]);
        int[] rightVal = getParsedValue(sides[1]);

        int leftXCount = leftVal[0];
        int rightXCount = rightVal[0];
        int leftNumCount = leftVal[1];
        int rightNumCOunt = rightVal[1];

        int actualXCount = leftXCount - rightXCount;
        int actualNumCount = rightNumCOunt - leftNumCount;

        if (actualXCount == 0 && actualNumCount == 0) {
            return "Infinite solutions";
        }
        else if (actualXCount == 0) {
            return "No solution";
        }
        else if (actualNumCount == 0) {
            return "x=0";
        }
        else {
            if (actualXCount < 0) {
                actualXCount *= -1;
                actualNumCount *= -1;
            }

            if (Math.abs(actualNumCount) / Math.abs(actualXCount) > 0) {
                actualNumCount /= actualXCount;
                actualXCount = 1;
            }

            return (actualXCount > 1 ? actualXCount : "")+ "x=" + actualNumCount;
        }
    }

     private int[] getParsedValue(String s) {

         StringBuilder sb = new StringBuilder();
         boolean negative = false;

         int xCount = 0;
         int numCount = 0;

         for (int i=0; i<s.length(); i++) {
             if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                 if (sb.length() > 0) {
                     if (negative) {
                         sb.insert(0, '-');
                     }

                     if (sb.toString().indexOf('x') != -1) {
                         if (sb.length() == 1) {
                             xCount += 1;
                         }
                         else if (negative && sb.length() == 2) {
                             xCount += -1;
                         }
                         else if (negative) {
                             xCount += -1 * Integer.parseInt(sb.toString().substring(1, sb.length() - 1));
                         }
                         else {
                             xCount += Integer.parseInt(sb.toString().substring(0, sb.length() - 1));
                         }
                     } else {
                         numCount += Integer.parseInt(sb.toString());
                     }
                 }

                 negative = s.charAt(i) == '-';
                 sb = new StringBuilder();
             }
             else {
                 sb.append(s.charAt(i));
             }
         }

         if (sb.length() > 0) {
             if (negative) {
                 sb.insert(0, '-');
             }


             if (sb.toString().indexOf('x') != -1) {
                 if (sb.length() == 1) {
                     xCount += 1;
                 }
                 else if (negative && sb.length() == 2) {
                     xCount += -1;
                 }
                 else if (negative) {
                     xCount += -1 * Integer.parseInt(sb.toString().substring(1, sb.length() - 1));
                 }
                 else {
                     xCount += Integer.parseInt(sb.toString().substring(0, sb.length() - 1));
                 }
             }
             else {
                 numCount += Integer.parseInt(sb.toString());
             }
         }

         return new int[]{xCount, numCount};
     }
}
