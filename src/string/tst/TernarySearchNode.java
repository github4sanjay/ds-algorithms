package string.tst;

public class TernarySearchNode {
    private char data;
    private boolean isEndOfString;
    private TernarySearchNode left;
    private TernarySearchNode equal;
    private TernarySearchNode right;

    public TernarySearchNode(char data) {
        this.data = data;
    }

    public char getData() {
        return data;
    }

    public void setData(char data) {
        this.data = data;
    }

    public boolean isEndOfString() {
        return isEndOfString;
    }

    public void setEndOfString(boolean endOfString) {
        isEndOfString = endOfString;
    }

    public TernarySearchNode getLeft() {
        return left;
    }

    public void setLeft(TernarySearchNode left) {
        this.left = left;
    }

    public TernarySearchNode getEqual() {
        return equal;
    }

    public void setEqual(TernarySearchNode equal) {
        this.equal = equal;
    }

    public TernarySearchNode getRight() {
        return right;
    }

    public void setRight(TernarySearchNode right) {
        this.right = right;
    }
}
