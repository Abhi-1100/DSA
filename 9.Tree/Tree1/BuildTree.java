package Tree1;

public class BuildTree {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int val) {
            this.data = val;
            this.right = null;
            this.left = null;
        }
    }

    public static class BinaryTree {
        private int idx;

        public Node buildTree(int[] nodes) {
            idx = -1;
            return build(nodes);
        }

        private Node build(int[] nodes) {
            idx++;

            if (idx >= nodes.length || nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = build(nodes);
            newNode.right = build(nodes);

            return newNode;

        }
    }
}
