package Tree1;
import java.util.*;

public class Levaorder {

    public static void main(String[] args) {
        int[] Nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BuildTree.BinaryTree tree = new BuildTree.BinaryTree();
        BuildTree.Node root = tree.buildTree(Nodes);

        levelOrder(root);
    }

    static void levelOrder(BuildTree.Node root) {
        if (root == null) {
            return;
        }

        Queue<BuildTree.Node> q = new LinkedList<>();

        q.add(root); // add the root first
        q.add(null); // for teh extra space

        while (!q.isEmpty()) {
            BuildTree.Node curr = q.remove();
            if (curr == null) { // if root is null root is singal BuildTree.Node
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else { // if root is having any child
                System.out.print(curr.data + " ");

                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }

    }

}
