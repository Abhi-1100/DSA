/*
---------------------------------------------------------------
Program: Search in a Sorted and Rotated Array (Modified Binary Search)
Author: Abhi Kakadiya
Description:
    This program demonstrates how to find a target element in a
    sorted and rotated array using a modified Binary Search approach.

    A sorted and rotated array is an array that was originally sorted
    in ascending order but was rotated (shifted) around a pivot point.
    Example: [4,5,6,7,0,1,2]

    The idea is to identify which half of the array is sorted at each
    step, and then decide whether to search in the left or right half.

Key Concepts:
    - Divide and Conquer Algorithm
    - Works on partially sorted data
    - Modified Binary Search logic
---------------------------------------------------------------

Algorithm Steps:
1. Find the middle index (mid = si + (ei - si) / 2)
2. If arr[mid] == target → element found, return mid.
3. Determine which part of the array is sorted:
   a. If left half (arr[si] ≤ arr[mid]) is sorted:
        - If target lies within [arr[si], arr[mid]] → search left.
        - Else → search right.
   b. Else (right half is sorted):
        - If target lies within [arr[mid], arr[ei]] → search right.
        - Else → search left.
4. Repeat the process recursively until element is found or range is empty.

---------------------------------------------------------------
Time Complexity:
    - Best Case: O(1)
    - Average Case: O(log n)
    - Worst Case: O(log n)
Space Complexity: O(log n)  (due to recursion)
Algorithm Type: Recursive Binary Search variant
---------------------------------------------------------------
Example:
Input  : arr = [4,5,6,7,0,1,2], target = 0
Process: Left half sorted → no, right half sorted → yes → found at index 4
Output : 4
---------------------------------------------------------------
*/


public class SortedNRotatedSerch {
    public static int serch_ind(int arr[],int target,int si,int ei){
        //base condiation
        if(si>ei){return -1;}

        int mid=si+(ei-si)/2;

        //case FOUND::
        if(arr[mid]==target){
            return mid;
        }
        //casse 1:(mid on Line 1)
        if(arr[si]<arr[mid]){
            //case a:found at left side
            if(arr[si]<=target && target<=arr[mid]){
                return serch_ind(arr,target,si,mid-1);//left
            }//case b:found at right side
            else{
                return serch_ind(arr,target,mid+1,ei);//right
            }
        }//case 2:(mid on Line 2)
        else{
            //case c:right
            if(arr[mid]<=target && target<=arr[ei]){
                return serch_ind(arr,target,mid+1,ei);//right
            }//case d:left
            else {
                return serch_ind(arr,target,si,mid-1);//left

            }
        }
    }
    public static void main(String[] args){
        int arr[]={4,5,6,7,0,1,2};
        int target=0;
        System.out.print(serch_ind(arr,target,0, arr.length-1));
    }
}
