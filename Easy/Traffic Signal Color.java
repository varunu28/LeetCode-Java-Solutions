class Solution {
    public String trafficSignal(int timer) {
        return switch (timer) {
            case int t when t == 0 -> "Green";
            case int t when t == 30 -> "Orange";
            case int t when 30 < t && t <= 90 -> "Red";
            default -> "Invalid";
        };
    }
}
