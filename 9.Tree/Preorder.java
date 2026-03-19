public class Preorder {
    public static class node {
        int data;
        node left;
        node right;

        node(int val) {
            this.data = val;
            this.right = null;
            this.left = null;
        }
    }

    public static class BinaryTree {
        static int idx = -1;

        public static node BuildTree(int nodes[]) {
            idx++;

            if (nodes[idx] == -1) {
                return null;
            }
            node newNode = new node(nodes[idx]);
            newNode.left = BuildTree(nodes);
            newNode.right = BuildTree(nodes);

            return newNode;

        }
    }

    static void Preorder(node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        Preorder(root.left);
        Preorder(root.right);
    }

    public static void main(String[] args) {
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree tree = new BinaryTree();
        node root = tree.BuildTree(nodes);

        Preorder(root);
    }

}
