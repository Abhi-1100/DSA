/*
---------------------------------------------------------------
Program: Container With Most Water (Brute Force) in Java
Author : Abhi Kakadiya
      ___                 ___
     |   |<------------->|   |<-> ___
     |   |___            |   |   |   |
     |   |   |    ___    |   |   |   |
     |   |   |   |   |   |   |   |   |
     |   |   |   |   |___|   |___|   |
     |   |   |___|   |   |   |   |   |
     |   |   |   |   |   |   |   |   |
     |   |   |   |   |   |   |   |   |
____________________________________________
 1    8    6   2   5   4   8   3   7   (heights)

Description:
    This program finds the maximum volume of water that can be
    stored between two lines in an elevation map.

    The solution is computed using a brute-force approach by:
    - Trying all possible pairs of lines.
    - Calculating the height of water level using min(line1, line2).
    - Computing the width (distance between the two lines).
    - Multiplying height × width to determine the container area.
    - Tracking the maximum area found so far.

Key Concepts:
    - Nested 1D ArrayList Traversal
    - Two-Pointer Pair Comparison (Brute Mode)
    - Width and Area Calculation
    - Maximum Value Tracking using Math.max()
---------------------------------------------------------------

Algorithm Steps:
1. Take input list of line heights stored using ArrayList.
2. Start outer loop from i = 0 to N-1.
3. Start inner loop from j = i+1 to N-1:
     a) height = min(list[i], list[j])
     b) width  = j - i
     c) area   = height × width
     d) Max_Vol = max(Max_Vol, area)
4. After checking all pairs, return the maximum volume.
5. Print result in the main() function.
---------------------------------------------------------------

Time Complexity: O(N²)
    - Since every possible pair is checked using nested loops.

Space Complexity: O(1) additional
    - Only integer variables are used for tracking max volume.

Approach Type: Simple Brute Force Computation
---------------------------------------------------------------

Example:
Input  : [1,8,6,2,5,4,8,3,7]
Possible Max Volume Pair → line at index 1 and index 8:
height = min(8,7) = 7
width  = 8 - 1 = 7
area   = 7 × 7 = 49
Output : 49
---------------------------------------------------------------
*/

package ArrayList;
import java.util.ArrayList;
public class container_with_most_water_bruteForse {
    public static int Water_Vol(ArrayList<Integer> list){
        int Max_Vol=0;
        for(int i=0; i< list.size(); i++){
            for(int j=i+1; j<list.size(); j++){
                int hight=Math.min(list.get(i), list.get(j));
                int width=j-i;
                int area=hight*width;
                Max_Vol=Math.max(Max_Vol, area);
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
        System.out.println(Water_Vol(List));
    }
}
