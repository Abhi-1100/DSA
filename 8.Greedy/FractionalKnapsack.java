import java.util.*;

public class FractionalKnapsack {
    public static void MaxValueinKnapsack(int[] value, int[] wight, int capacity){
        // Creat 2D array and add the retio 
        double[][] ration=new double[value.length][2];
        for(int i=0; i<value.length; i++){
            ration[i][0]=i;
            ration[i][1]=value[i]/(double)wight[i];
        }

        Arrays.sort(ration, Comparator.comparingDouble(o -> o[1]));

        int totalval=0;
        for(int i=value.length-1; i>=0; i--){
            int index=(int)ration[i][0];
            if(capacity > wight[index]){
                totalval +=value[index];
                capacity -= wight[index];
            }else{
                totalval += capacity*ration[i][1];
                capacity=0;
            }
        }

        System.out.println("Max Value : "+totalval);
    }
    public static void main(String[] args){
        int Value[]={60,100,120};
        int wight[]={10,20,30};
        int w=50;

        MaxValueinKnapsack(Value, wight, w);
    }
    
}
