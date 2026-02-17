import java.util.*;

public class IndianCoins {
    
    public static void main(String[] args){
        Integer coin[]={1,2,5,10,20,50,100,500,2000};
        int Amount=590;
        int count=0;
        ArrayList<Integer> list =new ArrayList<>();

        Arrays.sort(coin, Comparator.reverseOrder());
        for(int i=0;i<coin.length; i++){
            if(coin[i] <= Amount){
                while (coin[i] <= Amount) {
                    count++;
                    Amount-=coin[i];
                    list.add(coin[i]);
                }

            }
        }

        System.out.println("Min coin Req. for Amount : "+count);
        System.out.print(list);
    }

}
