package Stack;

import java.util.*;
class PushAtBottom{
    public static void Push_At_Bottom(Stack<Integer> s, int n){
        //Base Case
        if(s.isEmpty()){
            s.push(n);
            return;
        }
        //Rec using implisit Stack
        int top=s.pop();
        Push_At_Bottom(s, n);
        s.push(top);
    }
    public static void PrintStack(Stack<Integer> s){
         while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }
    public static void main(String[] args){
        Stack<Integer> S=new Stack<>();
        S.push(1);
        S.push(2);
        S.push(3);
        Push_At_Bottom(S,4);
        PrintStack(S);
    }
}