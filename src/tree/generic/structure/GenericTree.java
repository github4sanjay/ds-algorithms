package tree.generic.structure;

import java.util.Iterator;
import java.util.Stack;

public class GenericTree implements Iterable<Integer>{

    private final Node root;

    public GenericTree(Node root) {
        this.root = root;
    }

    public GenericTree(int[] arr){
        this.root = GenericTreeUtil.createTree(arr);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new GenericTreeIterator(root);
    }

    public static class GenericTreeIterator implements Iterator<Integer> {

        private final Stack<Node> stack;
        public GenericTreeIterator(Node root) {
            stack = new Stack<>();
            stack.push(root);
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public Integer next() {
            var next = stack.peek();
            var nextVal = stack.pop();
            var children = nextVal.getChildren();
            for (int i=children.size()-1; i>=0; i--){
                stack.push(children.get(i));
            }
            return next.getData();
        }
    }
}
