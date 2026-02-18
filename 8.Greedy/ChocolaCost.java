import java.util.*;

public class ChocolaCost {

    public static void main(String[] args) {

        Integer costhor[] = { 2, 1, 3, 1, 4 };
        Integer costver[] = { 4, 1, 2 };

        Arrays.sort(costhor, Collections.reverseOrder());
        Arrays.sort(costver, Collections.reverseOrder());

        int h = 0, v = 0;
        int hp = 1, vp = 1; // Initial state
        int TotalCost = 0;

        while (h < costhor.length && v < costver.length) {

            if (costver[v] <= costhor[h]) { // Horizontal Cut
                TotalCost += (costhor[h] * vp);
                hp++;
                h++;
            } else {
                TotalCost += (costver[v] * hp); // Vertical Cut
                vp++;
                v++;
            }
        }

        while (h < costhor.length) {
            TotalCost += (costhor[h] * vp);
            hp++;
            h++;

        }

        while (v < costver.length) {
            TotalCost += (costver[v] * hp); 
            vp++;
            v++;
        }

        System.out.print("Min Cost for the Cut : "+TotalCost);
    }
}
