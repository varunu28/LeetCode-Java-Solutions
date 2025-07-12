class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        Map<String, List<String>> validBusinessLinesMap = new LinkedHashMap<>();
        validBusinessLinesMap.put("electronics", new ArrayList<>());
        validBusinessLinesMap.put("grocery", new ArrayList<>());
        validBusinessLinesMap.put("pharmacy", new ArrayList<>());
        validBusinessLinesMap.put("restaurant", new ArrayList<>());
        int n = code.length;
        for (int i = 0; i < n; i++) {
            if (isActive[i]) {
                String currentCode = code[i];
                String currentBusinessLine = businessLine[i];
                if (validBusinessLinesMap.containsKey(currentBusinessLine) && isValidCode(currentCode)) {
                    validBusinessLinesMap.get(currentBusinessLine).add(currentCode);
                }
            }
        }
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : validBusinessLinesMap.entrySet()) {
            if (!entry.getValue().isEmpty()) {
                List<String> codes = new ArrayList<>(entry.getValue());
                Collections.sort(codes);
                result.addAll(codes);
            }
        }
        return result;
    }

    private boolean isValidCode(String currentCode) {
        if (currentCode == null || currentCode.isBlank()) {
            return false;
        }
        for (char c : currentCode.toCharArray()) {
            if (!(Character.isLetter(c) || Character.isDigit(c) || c == '_')) {
                return false;
            }
        }
        return true;
    }
}
