class Solution {
    public double[] convertTemperature(double celsius) {
        return new double[]{/* kelvin= */celsius + 273.15, /* fahrenheit= */celsius * 1.80 + 32.00};
    }
}
