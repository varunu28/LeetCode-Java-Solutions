class Solution {
    public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> list = new ArrayList<>();

        if (nums.length == 0) {
            list.add(getString(lower, upper));
            return list;
        }

        List<String> range = getRange(nums);
        int i = 0;

        while (lower <= upper && i < range.size()) {
            String s = range.get(i);
            if (s.indexOf('>') != -1) {
                int start = Integer.parseInt(s.split("->")[0]);
                int end = Integer.parseInt(s.split("->")[1]);

                if (lower != start) {
                    list.add(getString(lower, start-1));
                }

                lower = end + 1;
            }
            else {
                int num = Integer.parseInt(s);
                if (lower != num) {
                    list.add(getString(lower, num-1));
                }

                lower = num + 1;
            }

            i++;
        }

        String s = range.get(range.size()-1);
        if (s.indexOf('>') != -1) {
            int start = Integer.parseInt(s.split("->")[0]);
            int end = Integer.parseInt(s.split("->")[1]);

            if (end != upper) {
                list.add(getString(end+1, upper));
            }
        }
        else {
            int num = Integer.parseInt(s);
            if (upper != num) {
                list.add(getString(num+1, upper));
            }
        }

        return list;
    }

    private static List<String> getRange(int[] num) {

        List<String> list = new ArrayList<>();
        if (num.length == 0) {
            return list;
        }

        int i = 1;
        StringBuilder sb = new StringBuilder();
        sb.append(num[0]);
        int count = 1;

        while (i<num.length) {
            if (num[i] - num[i-1] == 1 || num[i] - num[i-1] == 0) {
                count++;
            }
            else {
                if (count > 1) {
                    sb.append("->").append(num[i-1]);
                    list.add(sb.toString());
                }
                else {
                    list.add(sb.toString());
                }

                sb = new StringBuilder();
                sb.append(num[i]);
                count = 1;
            }

            i++;
        }
        
        if (count > 1) {
            sb.append("->").append(num[num.length-1]);
        }

        list.add(sb.toString());

        return list;
    }

    private static String getString(int start, int end) {
        StringBuilder sb = new StringBuilder();
        if (start == end) {
            sb.append(start);
        }
        else {
            sb.append(start).append("->").append(end);
        }

        return sb.toString();
    }
}
