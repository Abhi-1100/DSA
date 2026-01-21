package Stack;
import java.util.*;

public class MaxAreaofHistogram {

    public static int FindMaxArea(int[] arr) {

        int n = arr.length;

        // 1. Next Smaller to Left (NSL)
        int[] nsl = new int[n];
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nsl[i] = -1;
            } else {
                nsl[i] = s.peek();
            }
            s.push(i);
        }

        // 2. Next Smaller to Right (NSR)
        int[] nsr = new int[n];
        s = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nsr[i] = n;
            } else {
                nsr[i] = s.peek();
            }
            s.push(i);
        }

        // 3. Calculate Max Area
        int max = 0;
        for (int i = 0; i < n; i++) {
            int height = arr[i];
            int width = nsr[i] - nsl[i] - 1;
            int area = height * width;
            max = Math.max(max, area);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] Histogram = {2, 1, 5, 6, 2, 3};
        System.out.print(FindMaxArea(Histogram));
    }

    public static class QueueByStack {
        static class Queue{
            static Stack<Integer> s1=new Stack<>();
            static Stack<Integer> s2=new Stack<>();

            public  boolean isEmpty(){
                return s1.isEmpty();
            }
            // Add
            public static void Add(int data){
                //1.
                if(s1.isEmpty()){
                    s1.push(data);
                }else{
                    while(!s1.isEmpty()){
                        s2.push(s1.pop());
                    }
                    s1.push(data);
                    while (!s2.isEmpty()){
                        s1.push(s2.pop());
                    }
                }
            }
            // Remove
            public static int Remove(){
                return s1.pop();
            }
            // Peek
            public static int peek(){
                return s1.peek();
            }
        }
        public static void main(String[] args){
            Queue q=new Queue();
            q.Add(1);
            q.Add(2);
            q.Add(3);
            q.Add(4);
            q.Remove();
            while(!q.isEmpty()){
                System.out.print(q.peek()+" ");
                q.Remove();
            }
        }
    }
}
