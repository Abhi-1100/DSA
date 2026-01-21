package Stack;
import java.util.*;
public class DuplicateParentheses {
    public static boolean FindDuplicate(String str){
        Stack<Character> s= new Stack<>();
        for(int i=0; i<str.length(); i++){
            char ch=str.charAt(i);

            //Closing
            if(ch==')'){
                int count=0;
                while(s.peek() != '('){
                    s.pop();
                    count++;
                }
                if(count==0){
                    return true;
                } s.pop();
            }else{
                s.push(ch);
            }
        }
        return false;
    }
    public static void main(String[] args){
        String str1 ="()";
        String str2 ="((a+b)+(c+d))";
        if(FindDuplicate(str1)){
            System.out.println("Duplicate Found");
        }else{
            System.out.println("No Duplicate Found");

        }
//        String[] tests = {
//                "((a+b))",
//                "(a+b)",
//                "((a))",
//                "((a+b)+(c+d))",
//                "(((a+b)))",
//                "((a+b)+(c))",
//                "(a+(b)/c)",
//                "((a+b)*(c+d))",
//                "()",
//                "(())",
//                "a+b",
//                "((a)+(b))",
//                "((a+b)+(c*(d)))",
//                "(a+b*(c-d))",
//                "((a+b)+(c+d)+(e))"
//        };
//
//        for (String exp : tests) {
//            System.out.println(exp + " -> " +
//                    (FindDuplicate(exp) ? "Duplicate Found" : "No Duplicate Found"));
//        }

    }
}
