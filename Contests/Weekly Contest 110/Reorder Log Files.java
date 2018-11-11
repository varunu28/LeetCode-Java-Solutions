class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> letterLogs = new ArrayList<>();
        List<String> digitLogs = new ArrayList<>();

        for (String log : logs) {
            if(Character.isDigit(log.split("\\s+")[1].charAt(0))) {
                digitLogs.add(log);
            }
            else {
                letterLogs.add(log);
            }
        }

        Collections.sort(letterLogs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] s1 = o1.split("\\s+");
                String[] s2 = o2.split("\\s+");

                StringBuilder sb1 = new StringBuilder();
                StringBuilder sb2 = new StringBuilder();

                for (int i=1; i<s1.length; i++) {
                    sb1.append(s1[i]).append(" ");
                }

                for (int i=1; i<s2.length; i++) {
                    sb2.append(s2[i]).append(" ");
                }

                if (sb1.toString().compareTo(sb2.toString()) == 0) {
                    return s1[0].compareTo(s2[0]);
                }

                return sb1.toString().compareTo(sb2.toString());
            }
        });

        String[] ans = new String[logs.length];

        int i = 0;
        for (String log : letterLogs) {
            ans[i++] = log;
        }

        for (String log : digitLogs) {
            ans[i++] = log;
        }

        return ans;
    }
}
