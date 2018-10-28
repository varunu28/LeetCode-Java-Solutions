class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();

        for (String email : emails) {
            String localName = email.split("@")[0];
            String domainName = email.split("@")[1];

            localName = localName.replace(".", "");
            int idx = localName.indexOf('+');
            if (idx != -1) {
                localName = localName.substring(0, idx);
            }

            set.add(localName+"@"+domainName);
        }

        return set.size();
    }
}
