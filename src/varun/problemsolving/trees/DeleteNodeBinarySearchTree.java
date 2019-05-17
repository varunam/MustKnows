package varun.problemsolving.trees;

public class DeleteNodeBinarySearchTree {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(10);
        binarySearchTree.insert(23);
        binarySearchTree.insert(35);
        binarySearchTree.insert(33);
        binarySearchTree.insert(52);
        binarySearchTree.insert(4);
        binarySearchTree.insert(21);
        binarySearchTree.insert(3);
        binarySearchTree.insert(6);

        System.out.println("Input binary search tree");
        binarySearchTree.printTree();
        System.out.println("\n");

        binarySearchTree.root = deleteNode(binarySearchTree.getRoot(), 21);
        System.out.println("Output binary search tree");
        binarySearchTree.printTree();
    }

    private static BinarySearchTree.Node deleteNode(BinarySearchTree.Node root, int key) {

        BinarySearchTree.Node current = root;
        BinarySearchTree.Node parent = null;

        while (current != null && current.data != key) {

            parent = current;

            if (key < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }

        }

        if (current == null) {
            System.out.println(key + " is not found in the binary search tree");
            return root;
        } else {
            //case 1: checking first condition, if the delete node is a leaf node.
            if (current.left == null && current.right == null) {
                if (current != root) {
                    if (parent.left == current) {
                        parent.left = null;
                    } else
                        parent.right = null;
                } else {
                    root = null;
                }
            } else
                //case 2: when the delete node has both the childs
                if (current.left != null && current.right != null) {
                    BinarySearchTree.Node minSuccessor = minValue(current.right);
                    int value = minSuccessor.data;
                    deleteNode(root, minSuccessor.data);
                    current.data = value;
                } else
                //case 3: when the delete node has only one child
                {

                    BinarySearchTree.Node child = (current.left == null) ? current.right : current.left;

                    if (current != root) {
                        if (parent.left == current) {
                            parent.left = child;
                        } else {
                            parent.right = child;
                        }
                    } else {
                        root = child;
                    }
                }

            return root;
        }
    }

    private static BinarySearchTree.Node minValue(BinarySearchTree.Node left) {
        BinarySearchTree.Node minimum = left;
        while (minimum.left != null) {
            minimum = minimum.left;
        }
        return minimum;
    }
}
