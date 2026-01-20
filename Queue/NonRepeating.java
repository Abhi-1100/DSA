import java.util.*;
public class NonRepeating {
    public static void PrintNonRepeating(String str){
        int[] frq=new int[26];
        Queue<Character> Q=new LinkedList<>();
        for(int i=0; i<str.length(); i++){
            char ch=str.charAt(i);
            Q.add(ch);
            frq[ch - 'a']++; // [ch - 'a'] find the index of ch

            while(!Q.isEmpty() && frq[Q.peek()-'a']>1){
                Q.remove();                 // remove until Q becomes Empty or having non repeating char
            }
            if(Q.isEmpty()){ // Q becomes Empty
                System.out.print(-1+" "); // there is no repeating char
            }else{
                System.out.print(Q.peek()+" "); // all repeating char is removed and first one is print
            }

        }
        System.out.println();
    }
    public static void main(String[] args){
        String str ="aabccxb";
        PrintNonRepeating(str);
    }
}
