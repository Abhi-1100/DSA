package Tree1;

import java.util.*;

public class Levalorder {
    

    



    public static void main(String[] args){
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BuildTree.BinaryTree tree = new BuildTree.BinaryTree();
        BuildTree.Node root = tree.buildTree(nodes);

        levelOrder(root);
    }
    
    static void levelOrder(BuildTree.Node root) {
        if (root == null) {
            return;
        }

        Queue<BuildTree.Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            BuildTree.Node currNode = q.remove();
            System.out.print(currNode.data + " ");

            if (currNode.left != null) {
                q.add(currNode.left);
            }
            if (currNode.right != null) {
                q.add(currNode.right);
            }
        }
    }
    
}
