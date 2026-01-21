package Stack;
import java.util.*;
public class QueueByStack {
    static  class MyQueue {
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();


        public static void Add(int x) {
            if (s1.isEmpty()) {
                s1.push(x);
            } else {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
                s1.push(x);
                while (!s2.isEmpty()) {
                    s1.push(s2.pop());
                }
            }
        }

        public static int Remove() {
            return s1.pop();
        }

        public static int top() {
            return s1.peek();
        }

        public static boolean empty() {
            return s1.isEmpty();
        }
    }


    public static void main(String[] args){
        MyQueue q=new MyQueue();
        q.Add(1);
        q.Add(2);
        q.Add(3);
        q.Add(4);
        q.Remove();
        q.Remove();
        while(!q.empty()){
            System.out.print(q.top()+" ");
            q.Remove();
        }
    }
}
