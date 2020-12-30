package string.tst;

public class TernarySearchTree {
    private TernarySearchNode root;

    public void add(String str){
        root = add(str.toCharArray(), root, 0);
    }

    private TernarySearchNode add(char[] word, TernarySearchNode node, int ptr) {
        if (node == null){
            node = new TernarySearchNode(word[ptr]);
        }

        if (word[ptr] < node.getData()) {
            node.setLeft(add(word, node.getLeft(), ptr));
        } else if (word[ptr] > node.getData()){
            node.setRight(add(word, node.getRight(), ptr));
        } else {
            if (ptr < word.length-1)
                node.setEqual(add(word, node.getEqual(), ptr + 1));
            else
                node.setEndOfString(true);
        }
        return node;
    }

    public boolean search(String word) {
        return search(root, word.toCharArray(), 0);
    }

    private boolean search(TernarySearchNode r, char[] word, int ptr) {
        if (r == null)
            return false;

        if (word[ptr] < r.getData())
            return search(r.getLeft(), word, ptr);
        else if (word[ptr] > r.getData())
            return search(r.getRight(), word, ptr);
        else {
            if (r.isEndOfString() && ptr == word.length - 1)
                return true;
            else if (ptr == word.length - 1)
                return false;
            else
                return search(r.getEqual(), word, ptr + 1);
        }
    }

    public void delete(String word) {
        delete(root, word.toCharArray(), 0);
    }

    private void delete(TernarySearchNode r, char[] word, int ptr) {
        if (r == null)
            return;

        if (word[ptr] < r.getData())
            delete(r.getLeft(), word, ptr);
        else if (word[ptr] > r.getData())
            delete(r.getRight(), word, ptr);
        else {
            /* to delete a word just make isEnd false **/
            if (r.isEndOfString() && ptr == word.length - 1)
                r.setEndOfString(false);
            else if (ptr < word.length-1)
                delete(r.getEqual(), word, ptr + 1);
        }
    }
}
