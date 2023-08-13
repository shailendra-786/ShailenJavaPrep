package dsa.stack;

import java.util.Stack;

class TextEditor {
    private StringBuilder content;
    private Stack<String> undoStack;
    private Stack<String> redoStack;

    public TextEditor() {
        content = new StringBuilder();
        undoStack = new Stack<>();
        redoStack = new Stack<>();
    }

    public void addText(String text) {
        undoStack.push(content.toString());
        content.append(text);
        redoStack.clear();
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            redoStack.push(content.toString());
            content = new StringBuilder(undoStack.pop());
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            undoStack.push(content.toString());
            content = new StringBuilder(redoStack.pop());
        }
    }

    public String getContent() {
        return content.toString();
    }
}

public class UndoRedoOperations {
    public static void main(String[] args) {
    	TextEditor editor = new TextEditor();

        editor.addText("Hello, ");
        editor.addText("world!");

        System.out.println(editor.getContent()); // Output: Hello, world!

        editor.undo();
        System.out.println(editor.getContent()); // Output: Hello,

        editor.redo();
        System.out.println(editor.getContent()); // Output: Hello, world!
    }
}
