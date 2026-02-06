import java.util.*;

public class MinAbsoluteDifference {
    public static void minABS(int a[], int b[]) {
        Arrays.sort(a);
        Arrays.sort(b);

        int minDff = 0;
        for (int i = 0; i < a.length; i++) {
            minDff += Math.abs(a[i] - b[i]);
        }

        System.out.println("Min Absolute Difference : " + minDff);
    }

    public static void main(String[] argd) {
        int A[] = { 4, 1, 8, 7 };
        int B[] = { 2, 3, 6, 5 };

        minABS(A, B);
    }
}
