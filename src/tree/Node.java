package tree;

class Node {
  
    int data;  
    Node left, right;  
  
    Node(int d)  
    {  
        data = d;  
        left = right = null;  
    }  
}  
  
class BinaryTree {  
  
    Node root;  
  
    // Function to find ceil of a given input in BST.  
    // If input is more than the max key in BST,  
    // return -1  
    Integer Ceil(Node node, Integer prev, int input)
    {  
  
        // Base case  
        if (node == null) {  
            return prev;
        }  
  
        // We found equal key  
        if (node.data == input) {  
            return node.data;  
        }  
  
        // If root's key is smaller,  
        // ceil must be in right subtree  
        if (node.data < input) {  
            return Ceil(node.right, null, input);
        }  

        int ceil = Ceil(node.left, node.data, input);

        return (ceil >= input) ? ceil : node.data;
    }  
  
    // Driver Code  
    public static void main(String[] args)  
    {  
        BinaryTree tree = new BinaryTree();  
        tree.root = new Node(8);  
        tree.root.left = new Node(4);  
        tree.root.right = new Node(12);  
        tree.root.left.left = new Node(2);  
        tree.root.left.right = new Node(6);  
        tree.root.right.left = new Node(10);  
        tree.root.right.right = new Node(14);  
        for (int i = 0; i < 16; i++) {  
  
            System.out.println(i + " " + tree.Ceil(tree.root, null, i));
        }  
    }  
}  