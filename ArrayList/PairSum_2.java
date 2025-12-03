/*
---------------------------------------------------------------
Program: Pair Sum in Sorted & Rotated ArrayList using 2-Pointer
Technique (Circular 2-Pointer / Pivot Based) in Java
Author  : Abhi Kakadiya
---------------------------------------------------------------

Description:
    This program checks if a pair exists in a **sorted but rotated
    ArrayList<Integer>** whose sum equals a target value.
    Since the list is rotated, the classic 2-pointer technique cannot
    be directly applied. Instead, we:

    - Find the **rotation pivot (breaking point)** where order breaks.
    - Assign pointers in a **circular manner**:
          `Lp = pivot + 1`  → Smallest element
          `Rp = pivot`      → Largest element
    - Move pointers using **modulo index wrapping** to traverse the
      rotated list correctly without extra memory.

Working Logic:
    1. Identify pivot (`bp`) such that:
            `list[bp] > list[bp+1]`
    2. After pivot is found:
            `Lp` starts at smallest element (bp+1)
            `Rp` starts at largest element (bp)
    3. While (`Lp != Rp`):
         - If sum == target  → Pair found ✔
         - If sum < target   → Move `Lp = (Lp + 1) % n`
         - If sum > target   → Move `Rp = (n + Rp - 1) % n`

Key Concepts:
    - ArrayList as Dynamic Array
    - Pivot (Rotation Point) Detection
    - Circular 2-Pointer Traversal using `% n`
    - Greedy Pair Sum Check (No Sorting Needed Again)
    - Optimized Search on Rotated Sorted Data
---------------------------------------------------------------

Algorithm Steps:
1. Store input heights in ArrayList.
2. Find Breaking Point (`bp` / pivot):
       for i → 0 to n-2:
            if list[i] > list[i+1] → bp = i
3. Initialize pointers:
       Lp = bp + 1  (Smallest value)
       Rp = bp      (Largest value)
4. While Lp != Rp:
       a. Compute sum = list[Lp] + list[Rp]
       b. If sum == target → return true
       c. Else if sum < target → Lp = (Lp+1) % n
       d. Else → Rp = (n + Rp-1) % n
5. If loop ends → return false
---------------------------------------------------------------

Time Complexity: O(N)
    - One pass to find rotation pivot + circular traversal loop.

Space Complexity: O(1)
    - No extra array used, only pointers & pivot variable.

Technique Used: Circular Two-Pointer (Pivot Based Greedy)
---------------------------------------------------------------

Example Dry Run:
Input  : [11, 15, 6, 8, 9, 10]
Target : 16

Breaking Point Found at index 1 (15 > 6)
Lp = 2 → 6  (Smallest)
Rp = 1 → 15 (Largest)

Steps:
(6 + 15 = 21) > 16 → Rp moves circular backward
(6 + 10 = 16) == 16 ✅ → Pair Found!

Output : true
---------------------------------------------------------------

Note:
    - List must be originally **sorted before rotation**.
    - Efficient for rotated CP problems; for unsorted lists,
      HashMap gives better O(N) without pivot detection.
---------------------------------------------------------------
*/

package ArrayList;
import jdk.dynalink.beans.StaticClass;

import java.util.ArrayList;
import java.util.logging.LoggingPermission;

public class PairSum_2 {
    public static  boolean PairSum(ArrayList<Integer> list , int target ){
        int bp=-1;
        int n=list.size();
        // Finding the Braking Point
        for(int i=0; i<n ;i++){
            if(list.get(i) > list.get(i+1)){
                bp=i;
                break;
            }
        }
        int Lp=bp+1  , Rp=bp;
        while(Lp != Rp){
        // case 1:
            if(list.get(Lp)+list.get(Rp) == target){
                return true;
            }
        // case 2:
            if(list.get(Lp)+list.get(Rp) < target){
                Lp=(Lp + 1)% n;
            }
        // case 3:
            if(list.get(Lp)+list.get(Rp) > target){
                Rp=(n+Rp-1)% n;
            }
        }

        return false;
    }
    public static void main(String[] args){
        ArrayList<Integer> List = new ArrayList<>();
        List.add(11);
        List.add(15);
        List.add(6);
        List.add(8);
        List.add(9);
        List.add(10);
        if(PairSum(List,16)){
            System.out.print("Ther is Possibel Pair for target ");
        }else{
            System.out.print("Ther is no any Possibel Pair for target ");

        }
    }
}
