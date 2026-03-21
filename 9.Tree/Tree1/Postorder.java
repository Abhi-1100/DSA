package Tree1;

public class Postorder {
    

    static void postorder(BuildTree.Node root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BuildTree.BinaryTree tree = new BuildTree.BinaryTree();
        BuildTree.Node root = tree.buildTree(nodes);

        postorder(root);
    }

}
