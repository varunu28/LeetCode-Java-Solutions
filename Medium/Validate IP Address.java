class Solution {
    Set<Character> hexCharSet = new HashSet<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'A', 'B', 'C', 'D', 'E', 'F'));
    
    public String validIPAddress(String IP) {
        if (IP.indexOf('.') != -1) {
            return isValidIPv4(IP) ? "IPv4" : "Neither";
        }
        else if (IP.indexOf(':') != -1) {
            return isValidIPv6(IP) ? "IPv6" : "Neither";
        }
        
        return "Neither";
    }
    
    private boolean isValidIPv4(String ip) {
        if (ip.startsWith(".") || ip.endsWith(".")) {
            return false;
        }
        String[] components = ip.split("\\.");
        if (components.length != 4) {
            return false;
        }
        
        for (String component : components) {
            try {
                int value = Integer.parseInt(component);
                if (value < 0 || value > 255) {
                    return false;
                }
                
                if (value > 0 && component.startsWith("0")) {
                    return false;
                }
                
                if (value == 0 && component.length() > 1) {
                    return false;
                }
            } catch(Exception e) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean isValidIPv6(String ip) {
        if (ip.startsWith(":") || ip.endsWith(":")) {
            return false;
        }
        
        String[] components = ip.split(":");
        if (components.length != 8) {
            return false;
        }
        
        for (String component : components) {
            if (component.length() > 4 || component.length() == 0) {
                return false;
            }
            for (char c : component.toCharArray()) {
                if (Character.isLetter(c) && hexCharSet.contains(c)) {
                    continue;
                }
                else if (Character.isDigit(c)) {
                    continue;
                }
                else {
                    return false;
                }
            }
        }
        return true;
    }
}
