class SQL {
    
    private final Map<String, Map<Integer, List<String>>> database;
    private final Map<String, Integer> tableIdMap;

    public SQL(List<String> tableNames, List<Integer> columns) {
        this.database = new HashMap<>();
        this.tableIdMap = new HashMap<>();
        for (String name : tableNames) {
            database.put(name, new HashMap<>());
            tableIdMap.put(name, 1);
        }
    }
    
    public void insertRow(String tableName, List<String> row) {
        // Select the table
        Map<Integer, List<String>> table = this.database.get(tableName);
        // Insert row in the table
        table.put(tableIdMap.get(tableName), row);
        // Increment rowId for the table
        tableIdMap.put(tableName, tableIdMap.get(tableName) + 1);
    }
    
    public void deleteRow(String tableName, int rowId) {
        // Select the table
        Map<Integer, List<String>> table = this.database.get(tableName);
        // Delete the row against the rowId
        table.remove(rowId);
    }
    
    public String selectCell(String tableName, int rowId, int columnId) {
        // Select the table
        Map<Integer, List<String>> table = this.database.get(tableName);
        // Select row
        List<String> row = table.get(rowId);
        // Select column
        return row.get(columnId - 1);
    }
}

/**
 * Your SQL object will be instantiated and called as such:
 * SQL obj = new SQL(names, columns);
 * obj.insertRow(name,row);
 * obj.deleteRow(name,rowId);
 * String param_3 = obj.selectCell(name,rowId,columnId);
 */
