import java.util.*;
public class StackByQueue {
    static class MyStack{
        static Queue<Integer> q1=new LinkedList<>();
        static Queue<Integer> q2=new LinkedList<>();

        // Empty
        public static boolean empty(){
            return q1.isEmpty() && q2.isEmpty();
        }

        // Push
        public static void push(int data){
            if(!q1.isEmpty()){
                q1.add(data);
            }else{
                q2.add(data);
            }
        }

        // Pop
        public static int pop(){
            if(empty()){
                System.out.println("!!!Stack is Empty");
                return -1;
            }
            int top=-1;
            // Case 1
            if(!q1.isEmpty()){
                while (!q1.isEmpty()){
                    top=q1.remove();
                    if(q1.isEmpty()){
                        break;
                    }
                    q2.add(top);
                }
            }else{ // case 2
                while (!q2.isEmpty()){
                    top=q2.remove();
                    if(q2.isEmpty()){
                        break;
                    }
                    q1.add(top);
                }
            }
            return top;
        }

        // Peek
        public static int peek(){
            if(q1.isEmpty()&&q2.isEmpty()){
                System.out.println("Stack is Empty");
                return -1;
            }
            int top=-1;
            // Case 1
            if(!q1.isEmpty()){
                while (!q1.isEmpty()){
                    top=q1.remove();
                    q2.add(top);
                }
            }else{ // case 2
                while (!q2.isEmpty()){
                    top=q2.remove();

                    q1.add(top);
                }
            }
            return top;

        }
    }
    public static void main(String[] args){
        MyStack s=new MyStack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.pop();
        while(!s.empty()){
            System.out.print(s.peek()+" ");
            s.pop();
        }
    }
}
