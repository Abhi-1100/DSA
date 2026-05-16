package Tree1;

public class Diameter {
    public static int Diameteroftree(BuildTree.Node root){
        if(root == null){
            return 0;
        }

        int leftDiam = Diameteroftree(root.left);
        int leftHt = HightOfTree.hightoftree(root.left);
        int rightDiam = Diameteroftree(root.right);
        int rightHt = HightOfTree.hightoftree(root.right);

        int selfDiam = leftHt + rightHt +1;
        return Math.max(selfDiam , Math.max(leftDiam , rightDiam));
    }
    
    public static void main(String[] args){
        BuildTree.Node root =new BuildTree.Node(1);
         root.left =new BuildTree.Node(2);
         root.right =new BuildTree.Node(3);
         root.left.left =new BuildTree.Node(4);
         root.left.right =new BuildTree.Node(5);
         root.right.left =new BuildTree.Node(6);
         root.right.right =new BuildTree.Node(7);
        


        System.out.print("Diameter of tree is : "+Diameteroftree(root));
    }
}
