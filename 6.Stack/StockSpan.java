package Stack;

import java.util.*;

public class StockSpan {

    public static void stockSpan(int stock[] ,int span[]){
        Stack<Integer> s=new Stack<>();
        span[0]=1; //for the day-1
        s.push(0);//push the 0 indx for day-1

        for(int i=1; i<stock.length ;i++){
            int currPrise=stock[i];
            while(!s.isEmpty() && currPrise > stock[s.peek()]){
                s.pop();
            }

            if(s.isEmpty()){ // if ther is not any prevHigh then set as the i+1 
                span[i]=i+1;
            }else{ // else using the (i-PrevHigh) eqn
                int PrevHigh=s.peek(); 
                span[i]=i-PrevHigh;
            }
            s.push(i);
        }
    }

    public static void main(String[] args) {
        int stock[] = { 100, 80, 60, 70, 60, 85, 100 };
        int span[] = new int[stock.length];
        stockSpan(stock, span);
        for (int i = 0; i < span.length; i++) {
            System.out.print(span[i] + " ");
        } 
        
    }
}