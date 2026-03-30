package Tree1;
import java.util.*;
public class HightOfTree {

    public static int hightoftree(BuildTree.Node root){
        if(root == null){
            return 0;
        }

        int lh=hightoftree(root.left);
        int lr=hightoftree(root.right);

        return Math.max(lh , lr)+1;
    }
    public static void main(String[] args){
        BuildTree.Node root =new BuildTree.Node(1);
         root.left =new BuildTree.Node(2);
         root.right =new BuildTree.Node(3);
         root.left.left =new BuildTree.Node(4);
         root.left.right =new BuildTree.Node(5);
         root.right.left =new BuildTree.Node(6);
         root.right.right =new BuildTree.Node(7);
        


        System.out.print("Hight os tree is : "+hightoftree(root));
    }
}
