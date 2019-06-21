class Solution {
    public int numUniqueEmails(String[] emails) {
        return Arrays.stream(emails)
                    .map(e -> getFormattedEmail(e))
                    .collect(Collectors.toSet())
                    .size();
    }
    
    private String getFormattedEmail(String email) {
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        
        while (idx < email.length()) {
            if (email.charAt(idx) == '@' || email.charAt(idx) == '+') {
                break;
            }
            if (email.charAt(idx) != '.') {
                sb.append(email.charAt(idx));
            }
            
            idx++;
        }
        
        while (email.charAt(idx) != '@') {
            idx++;
        }
        
        return sb.append('@').append(email.substring(idx + 1)).toString();
    }
}
