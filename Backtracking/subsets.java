/*
---------------------------------------------------------------
Program: Subsets (Backtracking) in Java
Author: Abhi Kakadiya
Description:
    This program demonstrates generating all possible subsets of a 
    given string using recursion and the Backtracking technique.
    It explores all combinations by deciding whether to include or 
    exclude each character and prints "null" for the empty subset.

Key Concepts:
    - Backtracking Algorithm
    - Recursion (YES/NO decision tree)
    - String Subset Generation
    - Detecting and handling empty subset
---------------------------------------------------------------

Algorithm Steps:
1. Base Case Check:
   - If index i reaches string length, print current subset.
   - If subset string is empty, print "null".
2. Include (YES Choice):
   - Add current character and recurse to the next index.
3. Exclude (NO Choice):
   - Do not add the character and recurse to the next index.
4. Backtracking:
   - Since string is immutable, no explicit undo required.
   - Previous states are preserved naturally in recursion stack.

Example Flow:
Input:  "abc"
Choices:
    YES → "a"  → YES → "ab" → YES → "abc"
    YES → "a"  → YES → "ab" → NO  → "ab"
    YES → "a"  → NO  → "a"  → YES → "ac"
    YES → "a"  → NO  → "a"  → NO  → "a"
    NO  → ""   → YES → "bc"
    NO  → ""   → NO  → "" (empty subset → prints "null")

---------------------------------------------------------------
Time Complexity: O(2ⁿ)
    - Each character has 2 choices (include/exclude)
    - Recursive tree generates 2ⁿ subsets
Space Complexity: O(n)
    - Maximum recursion depth is equal to the string length
Stable: ✅ Not applicable (not a sorting algorithm)
Algorithm Type: Recursive, Backtracking (Decision Tree)
---------------------------------------------------------------
Example:
Input  : str = "abc"
Output : All string subsets including "null" for empty subset
---------------------------------------------------------------
*/

public class subsets {
    public static void findSubsets(String str, String ans, int i) {
        // Base Condition
        if (i == str.length()) {
            if (ans.isEmpty())
                System.out.println("null");
            else
                System.out.println(ans);
            return;
        }
        // YES
        findSubsets(str, ans + str.charAt(i), i + 1);
        // NO
        findSubsets(str, ans, i + 1);
    }

    public static void main(String[] args) {
        findSubsets("abc", "", 0);
    }
}
