class TextEditor {

    private final Stack<Character> leftStack;
    private final Stack<Character> rightStack;

    public TextEditor() {
        this.leftStack = new Stack<>();
        this.rightStack = new Stack<>();
    }
    
    public void addText(String text) {
        for (int i = 0; i < text.length(); i++) {
            leftStack.push(text.charAt(i));
        }
    }
    
    public int deleteText(int k) {
        int count = 0;
        while (!leftStack.isEmpty() && k-- > 0) {
            leftStack.pop();
            count++;
        }
        return count;
    }
    
    public String cursorLeft(int k) {
        while (!leftStack.isEmpty() && k-- > 0) {
            rightStack.push(leftStack.pop());
        }
        return getLeftString();
    }
    
    public String cursorRight(int k) {
        while (!rightStack.isEmpty() && k-- > 0) {
            leftStack.push(rightStack.pop());
        }
        return getLeftString();
    }

    private String getLeftString() {
        int count = 10;
        StringBuilder sb = new StringBuilder();
        while (!leftStack.isEmpty() && count-- > 0) {
            sb.append(leftStack.pop());
        }
        for (int i = sb.length() - 1; i >= 0; i--) {
            leftStack.push(sb.charAt(i));
        }
        return sb.reverse().toString();
    }
}

/**
 * Your TextEditor object will be instantiated and called as such:
 * TextEditor obj = new TextEditor();
 * obj.addText(text);
 * int param_2 = obj.deleteText(k);
 * String param_3 = obj.cursorLeft(k);
 * String param_4 = obj.cursorRight(k);
 */
