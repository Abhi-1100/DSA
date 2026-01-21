/*
---------------------------------------------------------------
Program: Quick Sort in Java
Author: Abhi Kakadiya
Description:
    This program demonstrates the Quick Sort algorithm — a
    Divide and Conquer sorting technique. It selects a pivot
    element and partitions the array so that all elements
    smaller (or greater) than the pivot are placed on one side,
    and the larger (or smaller) ones on the other. The process
    is then recursively applied to the subarrays.

Key Concepts:
    - Divide and Conquer Algorithm
    - Recursion
    - Partitioning based on Pivot
    - In-place Sorting (no extra space needed)
---------------------------------------------------------------

Algorithm Steps:
1. Choose a Pivot:
   - In this implementation, the last element (arr[ei]) is chosen
     as the pivot.

2. Partition:
   - Rearrange elements such that:
     • All elements smaller (or equal) to pivot are on the left.
     • All elements greater than pivot are on the right.
   - Return the final pivot index.

3. Recursion:
   - Recursively apply QuickSort to the left and right subarrays
     formed around the pivot index.

Example Flow:
Input:  [6, 3, 9, 5, 2, 8]
Choose pivot = 8
Partition → [6,3,5,2,8,9]
Then recursively sort left part → [2,3,5,6,8,9]
Final Output → [2,3,5,6,8,9]

---------------------------------------------------------------
Time Complexity:
    - Best Case: O(n log n)
    - Average Case: O(n log n)
    - Worst Case: O(n²) (when array is already sorted or pivot is poor)
Space Complexity: O(1) (In-place)
Stable: ❌ No
Algorithm Type: Divide and Conquer, Recursive
---------------------------------------------------------------
Example:
Input  : arr = [6, 3, 9, 5, 2, 8]
Output : 2 3 5 6 8 9
---------------------------------------------------------------
*/

public class QuickSort {
    public static void Quicksort(int arr[] ,int si, int ei){
        if(si>=ei){return;}
        int pidx=Partiton(arr,si,ei);
        Quicksort(arr,si,pidx-1);
        Quicksort(arr,pidx+1,ei);
    }
    public static  int Partiton(int arr[], int si,int ei){
        int piovt=arr[ei];
        int i=si-1;
        for(int j=si;j<ei;j++){
            if(arr[j]>piovt){
                i++;
                int temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
            }
        }
        i++;
        int temp=piovt;
        arr[ei]=arr[i];
        arr[i]=temp;
        return i;
    }
    public static  void print(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String[] args){
        int arr[]={6,3,9,5,2,8};
        Quicksort(arr,0,arr.length-1);
        print(arr);
    }
}
