/*
---------------------------------------------------------------
Program: Array Backtracking in Java
Author: Abhi Kakadiya
Description:
    This program demonstrates the Backtracking concept on an
    integer array using recursion. The function assigns values
    while moving forward in recursion and modifies them when
    returning back (stack unwinding), showing how previous
    decisions/states can be revisited and changed.

Key Concepts:
    - Backtracking Technique
    - Recursion (forward + return phase)
    - Array value modification during stack unwind
---------------------------------------------------------------

Algorithm Steps:
1. Base Case:
   - If index i reaches the end of the array, print the array
     and return.
2. Recursive Forward Step:
   - Assign current value (val) to arr[i].
   - Recursively call the function for next index (i+1) and
     next value (val+1).
3. Backtracking Step (Stack Unwinding Phase):
   - After returning from recursion, modify arr[i] by subtracting 2,
     to reveal how past values get changed when going back.

Example Flow:
Initial call:
arr = [0,0,0,0,0], val = 1, i = 0

Recursion assignment:
[1,2,3,4,5]  → printed at base case

Backtracking modification:
[-1,0,1,2,3]  → printed in final print()

---------------------------------------------------------------
Time Complexity: O(n)
    - Each index of the array is visited once
    - Only one recursive branch expands fully to depth n
Space Complexity: O(n)
    - Due to recursion stack storing up to n calls
Algorithm Type: Recursive Backtracking
---------------------------------------------------------------
Example:
Input  : [5 size array], start val = 1
Output :
    Recursion print → 1 2 3 4 5
    Final array     → -1 0 1 2 3
---------------------------------------------------------------
*/
class Array_BackTracking{
    public static void changeArr(int arr[], int i, int val){
        //Base condition
        if(i== arr.length){
            print(arr);
            return;
        }
        //rec fun
        arr[i]=val;
        changeArr(arr, i+1, val+1);
        arr[i]=arr[i]-2;
    }
    public static void print(int arr[]){
        for(int A:arr){
            System.out.print(A+" ");
        }
    }
    public static void main(String[] args){
        int arr[]=new int[5];
        changeArr(arr , 0 , 1 );
        System.out.println();
        print(arr);
    }
}