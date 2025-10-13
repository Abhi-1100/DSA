/*
---------------------------------------------------------------
Program: Binary Search in Java
Author: Abhi Kakadiya
Description:
    This program demonstrates the Binary Search algorithm.
    Binary Search is an efficient searching technique that works
    only on **sorted arrays**. It repeatedly divides the search 
    interval in half, comparing the target value to the middle 
    element until the target is found or the range becomes empty.

Key Concepts:
    - Divide and Conquer algorithm
    - Works only on sorted data
    - Reduces the search space by half each iteration
---------------------------------------------------------------

Algorithm Steps:
1. Initialize two pointers:
      left = 0
      right = n - 1
2. Repeat while (left <= right):
      a. Find middle index → mid = (left + right) / 2
      b. If arr[mid] == key → element found
      c. If arr[mid] < key → search in right half (left = mid + 1)
      d. Else → search in left half (right = mid - 1)
3. If element not found, return -1.

---------------------------------------------------------------
Time Complexity:
    - Best Case: O(1)
    - Average Case: O(log n)
    - Worst Case: O(log n)
Space Complexity: O(1)
Type: Iterative Binary Search
---------------------------------------------------------------
*/

public class binarySerch {
    public static int BinarySerch(int arr[], int key) {
        int left = 0;
        int right = arr.length-1;
        while ((left <= right)) {
            int mid;
            mid = (left + right) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;

    }

    public static void main(String args[]) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        System.out.print("key found at indax :" + BinarySerch(arr, 9));
    }
}
