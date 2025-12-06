class Solution {

    private final Map<Integer, Boolean> isPrimeMap;

    public Solution() {
        this.isPrimeMap = new HashMap<>();
    }

    public boolean completePrime(int num) {
        boolean result = isPrime(num);
        String stringValue = String.valueOf(num);
        return result && allPrefixMatch(stringValue) && allSuffixMatch(stringValue); 
    }

    private boolean allPrefixMatch(String num) {
        for (int i = 1; i < num.length(); i++) {
            if (!isPrime(Integer.parseInt(num.substring(0, i)))) {
                return false;
            }
        }
        return true;
    }

    private boolean allSuffixMatch(String num) {
        for (int i = num.length() - 1; i >= 1; i--) {
            if (!isPrime(Integer.parseInt(num.substring(i)))) {
                return false;
            }
        }
        return true; 
    }

    private boolean isPrime(int num) {
        if (isPrimeMap.containsKey(num)) {
            return isPrimeMap.get(num);
        }
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                isPrimeMap.put(num, false);
                return false;
            }
        }
        isPrimeMap.put(num, true);
        return true;
    }
}
