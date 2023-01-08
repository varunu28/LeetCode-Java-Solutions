class Solution {
    
    private static final int BULKY_DIMENSION_THRESHOLD = 1000_0;
    private static final int BULKY_VOLUME_THRESHOLD = 1000_000_000;
    private static final int HEAVY_MASS_THRESHOLD = 100;
    
    public String categorizeBox(int length, int width, int height, int mass) {
        long volume = ((long) length) * width * height;
        boolean isBulky = length >= BULKY_DIMENSION_THRESHOLD || 
            width >= BULKY_DIMENSION_THRESHOLD || 
            height >= BULKY_DIMENSION_THRESHOLD || 
            mass >= BULKY_DIMENSION_THRESHOLD ||
            volume >= BULKY_VOLUME_THRESHOLD;
        boolean isHeavy = mass >= HEAVY_MASS_THRESHOLD;
        if (isBulky && isHeavy) {
            return "Both";
        }
        if (!(isBulky || isHeavy)) {
            return "Neither";
        }
        return isBulky ? "Bulky" : "Heavy";
    }
}
