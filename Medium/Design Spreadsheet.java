class Spreadsheet {

    private final Map<Character, Map<Integer, Integer>> sheet;

    public Spreadsheet(int rows) {
        sheet = new HashMap<>();
        for (char c = 'A'; c <= 'Z'; c++) {
            sheet.put(c, new HashMap<>());
        }
    }
    
    public void setCell(String cell, int value) {
        char column = cell.charAt(0);
        int rowNumber = Integer.parseInt(cell.substring(1));
        Map<Integer, Integer> row = sheet.get(column);
        row.put(rowNumber, value);
    }
    
    public void resetCell(String cell) {
        setCell(cell, 0);
    }
    
    public int getValue(String formula) {
        String[] split = formula.split("\\+");
        String cellOne = split[0].substring(1);
        String cellTwo = split[1];
        return getCellValue(cellOne) + getCellValue(cellTwo);
    }

    private int getCellValue(String cell) {
        if (!Character.isLetter(cell.charAt(0))) {
            return Integer.parseInt(cell);
        }
        char column = cell.charAt(0);
        int rowNumber = Integer.parseInt(cell.substring(1));
        Map<Integer, Integer> row = sheet.get(column);
        return row.getOrDefault(rowNumber, 0);
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */
