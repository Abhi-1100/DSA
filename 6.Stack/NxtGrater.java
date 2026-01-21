package Stack;

import java.util.*;
public class NxtGrater {
    public static void main (String[] args){
        int arr[]={6,8,0,1,3};
        Stack<Integer> S=new Stack<>();
        int nextGret[]=new int[arr.length];

        for(int i=arr.length-1 ; i>=0; i--){
            // 1. while
            while(!S.isEmpty() && arr[i] >= arr[S.peek()]){
                S.pop();
            }
            // 2. if-else
            if(S.isEmpty()){
                nextGret[i]=-1;
            }else{
                nextGret[i]=arr[S.peek()];
            }
            // 3. push
            S.push(i);
        }
        for(int n:nextGret){
            System.out.print(n+" ");
        }
    }
}
