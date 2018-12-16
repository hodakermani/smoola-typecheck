package main.ast.node;

public abstract class Node {
    protected int lineNum;
    protected int colNum;
    public boolean typeCorrect;
    public String selfType;

    public int getColNum() {
        return colNum;
    }

    public void setColNum(int colNum) {
        this.colNum = colNum;
    }

    public int getLineNum() {
        return lineNum;
    }

    public void setLineNum(int lineNum) {
        this.lineNum = lineNum;
    }
}
