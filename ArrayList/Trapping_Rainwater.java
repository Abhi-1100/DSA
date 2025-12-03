/*
---------------------------------------------------------------
Program: Trapping Rainwater Problem in Java
Author : Abhi Kakadiya
              ___
             |   |        ___
  ___        |   |       |   |
 |   |       |   |___    |   |
 |   |___    |   |   |___|   |
 |   |   |   |   |   |   |   |
 |   |   |___|   |   |   |   |
______________________________________
Description:
    This program calculates the amount of rainwater that can be
    trapped between vertical elevation bars using the Prefix and
    Suffix Maximum technique with ArrayLists.

    The logic works by:
    - Computing the maximum bar height to the left of each index.
    - Computing the maximum bar height to the right of each index.
    - Determining the water level at each bar using min(leftMax, rightMax).
    - Adding (water level – current height) to the total trapped water.

Key Concepts:
    - ArrayList as Dynamic Array
    - Prefix/Suffix Maximum Computation
    - Index Realignment using Collections.reverse()
    - 1D Traversal and Water Level Calculation
---------------------------------------------------------------

Algorithm Steps:
1. Take input of bar heights stored in ArrayList.
2. Compute LeftMax ArrayList:
     - Start from index 0 and store max height seen so far.
3. Compute RightMax ArrayList:
     - Start from last index and store max height seen so far.
     - Use the last inserted value for comparison instead of index i+1.
4. Reverse RightMax ArrayList to match original indexing.
5. Traverse each bar from 0 to N:
     - Calculate water level = min(LeftMax[i], RightMax[i]).
     - Add trapped water at bar = water level - height[i].
6. Accumulate result and print the total trapped water.
---------------------------------------------------------------

Time Complexity: O(N)
    - Two single passes to compute left & right max + one more pass
      to calculate trapped water.

Space Complexity: O(N)
    - Two auxiliary ArrayLists (leftMax and rightMax) and recursion
      stack is not used.

Algorithm Type: Iterative Precomputation (Prefix + Suffix Max)
---------------------------------------------------------------

Example Dry Run:
Input  : [4, 2, 0, 6, 3, 2, 5]
LeftMax  -> [4, 4, 4, 6, 6, 6, 6]
RightMax -> [6, 6, 6, 6 , 5, 5, 5] (built reverse then aligned)
Water levels (min) at each index -> [4,2,4,5,5,5,5]
Trapped water at each bar -> [0,2,4,0,2,3,0]
Output :
---------------------------------------------------------------
*/

package ArrayList;
import  java.util.ArrayList;
import  java.util.Collections;
public class Trapping_Rainwater {
    public static int TrappedWater(ArrayList<Integer> hight){
        int n=hight.size();
        // Left Max
        ArrayList<Integer> LeftMax=new ArrayList<>();
        LeftMax.add(hight.get(0));
        for(int i=1 ; i<n; i++){
            LeftMax.add(Math.max(hight.get(i),LeftMax.get(i-1)));
        }

        // Right Max
        ArrayList<Integer> RightMax=new ArrayList<>();
        RightMax.add(hight.get(n-1));
        for(int i=n-2; i>=0 ;i--){
            RightMax.add(Math.max(hight.get(i),RightMax.get(RightMax.size()-1)));
        }
        Collections.reverse(RightMax);

        //Count Trapped Water
        int TrappedW=0;
        for(int i=0; i<n ;i++){
            int WaterLevel=Math.min(LeftMax.get(i) , RightMax.get(i));
            TrappedW+=WaterLevel-hight.get(i);
        }
        return TrappedW;
    }
    public static void main(String[] args){
        ArrayList<Integer> Hight=new ArrayList<>();
        Hight.add(4);
        Hight.add(2);
        Hight.add(0);
        Hight.add(6);
        Hight.add(3);
        Hight.add(2);
        Hight.add(5);
        System.out.print(TrappedWater(Hight));
    }
}
