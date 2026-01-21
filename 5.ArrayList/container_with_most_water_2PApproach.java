package ArrayList;

import java.util.ArrayList;

public class container_with_most_water_2PApproach {
    public static int Water_Vol(ArrayList<Integer> list){
        int Lp=0 , Rp=list.size()-1;
        int Max_Vol=0;
        while (Lp < Rp){
            int hight=Math.min(list.get(Lp) , list.get(Rp));
            int width=Rp-Lp;
            int area=hight*width;
            Max_Vol=Math.max(Max_Vol , area);
            if(Lp <  Rp){
                Lp++;
            }else {
                Rp--;
            }
        }
        return Max_Vol;
    }
    public static void main(String[] args){
        ArrayList<Integer> List= new ArrayList<>();
        List.add(1);
        List.add(8);
        List.add(6);
        List.add(2);
        List.add(5);
        List.add(4);
        List.add(8);
        List.add(3);
        List.add(7);
        System.out.print(Water_Vol(List));
    }
}
