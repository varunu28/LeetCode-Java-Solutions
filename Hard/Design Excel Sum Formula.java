class Excel {

    private final Formula[][] formulas;
    private final Stack<int[]> stack;

    public Excel(int height, char width) {
        this.formulas = new Formula[height][(width - 'A') + 1];
        this.stack = new Stack<>();
    }
    
    public void set(int row, char column, int val) {
        formulas[row - 1][column - 'A'] = new Formula(val);
        topologicalSort(row - 1, column - 'A');
        processStack();
    }
    
    public int get(int row, char column) {
        if (formulas[row - 1][column - 'A'] == null) {
            return 0;
        }
        return formulas[row - 1][column - 'A'].value;
    }
    
    public int sum(int row, char column, String[] numbers) {
        Map<String, Integer> cells = parse(numbers);
        int sum = calculateSum(row - 1, column - 'A', cells);
        set(row, column, sum);
        formulas[row - 1][column - 'A'] = new Formula(cells, sum);
        return sum;
    }

    private void topologicalSort(int row, int col) {
        for (int i = 0; i < formulas.length; i++) {
            for (int j = 0; j < formulas[0].length; j++) {
                if (formulas[i][j] != null && formulas[i][j].cells.containsKey("" + (char)('A' + col) + (row + 1))) {
                    topologicalSort(i, j);
                }
            }
        }
        stack.push(new int[]{row, col});
    }

    private void processStack() {
        while (!stack.isEmpty()) {
            int[] popped = stack.pop();
            if (formulas[popped[0]][popped[1]].cells.size() > 0) {
                calculateSum(popped[0], popped[1], formulas[popped[0]][popped[1]].cells);
            }
        }
    }

    private int calculateSum(int row, int col, Map<String, Integer> cells) {
        int sum = 0;
        for (String cell : cells.keySet()) {
            int x = Integer.parseInt(cell.substring(1)) - 1;
            int y = cell.charAt(0) - 'A';
            sum += (formulas[x][y] != null ? formulas[x][y].value : 0) * cells.get(cell);
        }
        formulas[row][col] = new Formula(cells, sum);
        return sum;
    }

    private Map<String, Integer> parse(String[] numbers) {
        Map<String, Integer> cells = new HashMap<>();
        for (String number : numbers) {
            if (number.indexOf(':') < 0) {
                cells.put(number, cells.getOrDefault(number, 0) + 1);
            } else {
                String[] split = number.split(":");
                char cellStartX = split[0].charAt(0);
                char cellEndX = split[1].charAt(0);
                int cellStartY = Integer.parseInt(split[0].substring(1));
                int cellEndY = Integer.parseInt(split[1].substring(1));
                for (int i = cellStartY; i <= cellEndY; i++) {
                    for (char j = cellStartX; j <= cellEndX; j++) {
                        String cell = "" + j + i;
                        cells.put(cell, cells.getOrDefault(cell, 0) + 1);
                    }
                }
            }
        }
        return cells;
    }

    class Formula {
        Map<String, Integer> cells;
        int value;

        public Formula(Map<String, Integer> cells, int value) {
            this.cells = cells;
            this.value = value;
        }

        public Formula(int value) {
            this(new HashMap<>(), value);
        }
    }
}

/**
 * Your Excel object will be instantiated and called as such:
 * Excel obj = new Excel(height, width);
 * obj.set(row,column,val);
 * int param_2 = obj.get(row,column);
 * int param_3 = obj.sum(row,column,numbers);
 */
