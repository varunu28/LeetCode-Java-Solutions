class Solution {
    public String validIPAddress(String IP) {
        if (isIPv4(IP)) {
            return "IPv4";
        }
        else if (isIPv6(IP)) {
            return "IPv6";
        }
        else {
            return "Neither";
        }
    }

    private boolean isIPv6(String ip) {
        if (ip.indexOf(':') == -1 || ip.charAt(0) == ':' || ip.charAt(ip.length()-1) == ':') {
            return false;
        }

        String[] strs = ip.split(":");
        if (strs.length != 8) {
            return false;
        }

        String pattern = "^*[[0-9][ABCDEF][abcdef]]*$";
        
        for (String str : strs) {
            if (str.length() == 0 || str.length() > 4) {
                return false;
            }
            if (!str.matches(pattern)) {
                return false;
            }
        }

        return true;
    }

    private boolean isIPv4(String ip) {
        if (ip.indexOf('.') == -1 || ip.charAt(0) == '.' || ip.charAt(ip.length()-1) == '.') {
            return false;
        }

        String[] strs = ip.split("\\.");
        if (strs.length != 4) {
            return false;
        }

        for (String str : strs) {
            if (!str.chars().allMatch(Character::isDigit)) {
                return false;
            }

            int num;
            try {
                num = Integer.parseInt(str);
            } catch (NumberFormatException e) {
                return false;
            }

            if (num < 0 || num > 255) {
                return false;
            }

            if (str.startsWith("0") && str.length() > 1) {
                return false;
            }
        }

        return true;
    }
}
