/*
---------------------------------------------------------------
Program: Pair Sum Problem using 2-Pointer Technique in Java
Author : Abhi Kakadiya

Visualization:
  Lp →  ●━━━━━━━━━━━━━━━━━━━━━━●  ← Rp
        1  2  3  4  5  6  (Sorted List)
        |                 |
      move →         ← move when needed
---------------------------------------------------------------

Description:
    This program checks whether there exists any pair in a
    **sorted ArrayList<Integer>** whose sum equals a given target.
    It uses the optimized **Two-Pointer approach** to achieve a
    linear time solution instead of brute force nested loops.

Working Logic:
    - A left pointer (`Lp`) starts from the beginning.
    - A right pointer (`Rp`) starts from the end.
    - Sum is calculated using `list[Lp] + list[Rp]`.
    - If sum matches target → pair found.
    - If sum < target → move left pointer to increase sum.
    - If sum > target → move right pointer to decrease sum.

Key Concepts:
    - ArrayList as a Dynamic Array
    - 2-Pointer Optimization Technique
    - Linear Search from Both Ends
    - Sorted Data Precondition
    - Efficient Conditional Index Movement
---------------------------------------------------------------

Algorithm Steps:
1. Initialize:
       `Lp = 0` (start of list),
       `Rp = list.size() - 1` (end of list)
2. While (`Lp < Rp`):
       - Compute `sum = list.get(Lp) + list.get(Rp)`
       - If `sum == target` → return true (pair found)
       - Else If `sum < target` → `Lp++`
       - Else → `Rp--`
3. If loop completes → return false (no valid pair)
---------------------------------------------------------------

Time Complexity: O(N)
    - Only one traversal using while loop moving from both ends.

Space Complexity: O(1)
    - No extra array required other than pointer variables.

Technique Used: 2-Pointer (Greedy Optimization on Sorted List)
---------------------------------------------------------------

Example Dry Run:
Input  : [1, 2, 3, 4, 5, 6], Target = 5

Start  : Lp = 0 (1), Rp = 5 (6)
Step 1 : sum = 1 + 6 = 7 > 5 → Rp--
Step 2 : sum = 1 + 5 = 6 > 5 → Rp--
Step 3 : sum = 1 + 4 = 5 == 5 ✅ → Pair Found!

Output : true
---------------------------------------------------------------
*/

package ArrayList;

import java.util.ArrayList;

public class PairSum_1_2Pointer {
    public static boolean PairSum(ArrayList<Integer> list, int target){
        int Lp=0   ,  Rp=list.size()-1;
        while (Lp < Rp) {
            // case 1:
            if (list.get(Lp) + list.get(Rp) == target) {
                return true;
            }
            // case 2:
            if(list.get(Lp) + list.get(Rp) < target){
                Lp++;
            }
            // case 3:
            if(list.get(Lp) + list.get(Rp) > target){
                Rp--;
            }
        }
        return false;
    }
    public static void main(String[] args){
        ArrayList<Integer> List=new ArrayList<>();
        List.add(1);
        List.add(2);
        List.add(3);
        List.add(4);
        List.add(5);
        List.add(6);
        if(PairSum(List,5)){
            System.out.print("Ther is Possibel Pair for target ");
        }else{
            System.out.print("Ther is no any Possibel Pair for target ");

        }
    }
}
