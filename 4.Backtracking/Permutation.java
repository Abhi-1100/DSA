/*
---------------------------------------------------------------
Program: String Permutations using Backtracking in Java
Author: Abhi Kakadiya
Description:
    This program generates and prints all possible permutations
    of a given string using recursion and backtracking. At each
    step, one character is selected and removed from the original
    string, and the remaining substring is passed recursively.
    The answer string (ans) accumulates characters to form
    a full permutation.

Key Concepts:
    - Backtracking Technique on String
    - Recursion (branching through all choices)
    - String character removal and rebuilding states
---------------------------------------------------------------

Algorithm Steps:
1. Base Case:
   - If the input string becomes empty, print the built
     permutation stored in ans and return.
2. Recursive Forward Step:
   - Loop through each character in the string.
   - Pick the current character (curr).
   - Remove it from the original string to form a new substring.
   - Recursively call the function with the new substring and
     append the picked character to ans.
3. Backtracking Step:
   - On returning from recursion, the loop naturally moves to the
     next character, exploring other possibilities (implicit backtracking).

Example Flow:
Initial call:
str = "abc", ans = ""

Recursive branching:
    a → permutations of "bc"
    b → permutations of "ac"
    c → permutations of "ab"

Final Output Permutations:
    abc, acb, bac, bca, cab, cba

---------------------------------------------------------------
Total Permutations = n!  (n = length of string)
Time Complexity: O(n × n!)
    - n for processing substring operations
    - n! recursive calls for all permutations
Space Complexity: O(n)
    - Recursion stack depth equals string length
Algorithm Type: Recursive Backtracking
---------------------------------------------------------------
Example:
Input  : "abc"
Output :
    abc
    acb
    bac
    bca
    cab
    cba
---------------------------------------------------------------
*/

public class Permutation {
    public static void FindPermutations(String str, String ans){
        //Base Con..
        if(str.isEmpty()){
            System.out.println(ans);
            return;
        }
        //Rec Fun..
        for(int i=0 ; i<str.length() ; i++){
            char curr =str.charAt(i);
            String temp=str.substring(0, i) + str.substring(i+1);
            FindPermutations(temp, ans+curr);
        }
    }
    public static void main(String[] args){
        String str="abc";
        FindPermutations(str,"");
    }
}