package Tree1;

public class Preorder {
    
    static void preorder(BuildTree.Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BuildTree.BinaryTree tree = new BuildTree.BinaryTree();
        BuildTree.Node root = tree.buildTree(nodes);

        preorder(root);
    }

}
