import java.util.*;

class ActivitySelect {

    public static void MaxActivitySelect(int[] start, int[] end) {

        // Step 1: Store activities as (index, start, end)
        int[][] Activity = new int[end.length][3];

        for (int i = 0; i < end.length; i++) {
            Activity[i][0] = i;        // activity index
            Activity[i][1] = start[i]; // start time
            Activity[i][2] = end[i];   // end time
        }

        // Step 2: Sort activities by end time
        Arrays.sort(Activity, Comparator.comparingInt(o -> o[2]));

        // Step 3: Select maximum activities
        int MaxAct = 1;
        ArrayList<Integer> Act = new ArrayList<>();

        // Add first activity
        int lastEnd = Activity[0][2];
        Act.add(Activity[0][0]);

        // Select remaining activities
        for (int i = 1; i < Activity.length; i++) {

            if (Activity[i][1] >= lastEnd) {
                Act.add(Activity[i][0]);
                MaxAct++;
                lastEnd = Activity[i][2];
            }
        }

        // Output
        System.out.println("Max Activity: " + MaxAct);

        for (int i = 0; i < Act.size(); i++) {
            System.out.print("A" + Act.get(i) + " ");
        }
    }

    public static void main(String[] args) {

        int startDate[] = {1, 3, 0, 5, 8, 5};
        int endDate[] = {2, 4, 6, 7, 9, 9};

        MaxActivitySelect(startDate, endDate);
    }
}
