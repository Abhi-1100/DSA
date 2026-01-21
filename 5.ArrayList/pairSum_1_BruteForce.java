/*
---------------------------------------------------------------
Program: Pair Sum Problem using Brute Force Approach in Java
Author : Abhi Kakadiya
---------------------------------------------------------------

Description:
    This program checks whether any two distinct elements inside an
    ArrayList<Integer> produce a sum equal to the given target value.
    It uses the **Brute Force (Nested Loop)** technique to compare
    every possible pair in the list.

Working Logic:
    - The outer loop picks the first element.
    - The inner loop picks the next elements one by one.
    - For each pair, sum is calculated:
            `list[i] + list[j]`
    - If sum equals target → Pair found, return `true`.
    - If no pair matches → return `false`.

Key Concepts:
    - ArrayList as Dynamic Storage
    - Nested Loop Pair Comparison
    - Condition Checking on Every Pair
    - No Sorting Required
---------------------------------------------------------------

Algorithm Steps:
1. Initialize ArrayList and manually insert values.
2. Using nested `for` loop:
       - Outer loop (`i`) goes from `0` to `N-1`
       - Inner loop (`j`) goes from `i+1` to `N-1`
3. If `list.get(i) + list.get(j) == target`
       → return `true`
4. After loops end, return `false`
---------------------------------------------------------------

Time Complexity: O(N²)
    - Because each pair is checked using nested loops.

Space Complexity: O(1)
    - No extra arrays used, only iteration variables.

Technique Used: Brute Force Pair Matching
---------------------------------------------------------------

Example Dry Run:
Input  : [1, 2, 3, 4, 5, 6]
Target : 5

Pairs checked:
(1 + 2 = 3), (1 + 3 = 4), (1 + 4 = 5) ✅ → Pair Found!

Output : true
---------------------------------------------------------------

Note:
    - This method works fine for small inputs but is not optimal
      for large datasets. A 2-pointer or hashmap-based solution can
      improve performance to O(N).
---------------------------------------------------------------
*/

package ArrayList;
import java.util.ArrayList;
public class pairSum_1_BruteForce {
    public static boolean PairSum(ArrayList<Integer> list, int target){
        // BrutForce
        for(int i=0; i<list.size(); i++){
            for(int j=i+1; j<list.size(); j++){
                if(list.get(i)+list.get(j)==target){
                    return true;
                }
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
