/*
---------------------------------------------------------------
Program: Insertion Sort in Java
Author: Abhi Kakadiya
Description:
    This program demonstrates the Insertion Sort algorithm.
    Insertion Sort works by dividing the array into a sorted 
    and an unsorted part. It repeatedly takes one element 
    from the unsorted part and places it in the correct 
    position in the sorted part.

Key Concepts:
    - Comparison-based sorting
    - In-place sorting (no extra array)
    - Builds the final sorted array one item at a time
    - Works efficiently for small datasets or partially 
      sorted arrays
---------------------------------------------------------------

Algorithm Steps:
1. Start from the second element (index = 1), assuming the first 
   element is already sorted.
2. Store the current element as 'curr'.
3. Compare 'curr' with elements in the sorted portion (on the left).
4. Shift all elements greater than 'curr' one position ahead.
5. Insert 'curr' into its correct position.

---------------------------------------------------------------
Time Complexity:
    - Best Case: O(n) → when array is already sorted
    - Average Case: O(n²)
    - Worst Case: O(n²)
Space Complexity: O(1) (In-place)
Stable: ✅ Yes
---------------------------------------------------------------
*/
public class insertionSort {
   public static void insertion_sort(int arr[]){
        for(int i=1;i<arr.length;i++){
            int curr=arr[i];
            int prev=i-1;
            while(prev>=0 && arr[prev]>curr){
                arr[prev+1]=arr[prev];
                prev--;
            }
            arr[prev+1]=curr;
        }
    }
    public static void print_arr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
   
    public static void main(String[] args) {
        int arr[]={5,6,7,1,2,3,5,3};
       
       insertion_sort(arr);
        print_arr(arr);
    }        
}
