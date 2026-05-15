package Tree1;

public class CountofNodes {
    

    public static int countNodes(BuildTree.Node root){
        if(root == null){
            return 0;
        }

        int LeftCount=countNodes(root.left);
        int RightCount=countNodes(root.right);

        return LeftCount + RightCount+1;
    }
    public static void main(String[] args){
        BuildTree.Node root =new BuildTree.Node(1);
         root.left =new BuildTree.Node(2);
         root.right =new BuildTree.Node(3);
         root.left.left =new BuildTree.Node(4);
         root.left.right =new BuildTree.Node(5);

        


        System.out.print("Total No of Nodes : "+countNodes(root));
    }
}


