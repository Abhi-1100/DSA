/*
---------------------------------------------------------------
Program: Selection Sort in Java
Author: Abhi Kakadiya
Description:
    This program demonstrates the Selection Sort algorithm.
    Selection Sort works by repeatedly finding the minimum element 
    from the unsorted portion of the array and swapping it with the 
    first unsorted element. 

Key Concepts:
    - Comparison-based sorting algorithm
    - In-place sorting (no extra memory needed)
    - Simple but inefficient for large datasets
---------------------------------------------------------------

Algorithm Steps:
1. Divide the array into two parts: sorted and unsorted.
2. Initially, the sorted part is empty and the unsorted part 
   is the entire array.
3. For each position i (from 0 to n-2):
   a. Find the minimum element in the unsorted part.
   b. Swap it with the element at position i.
4. Continue until the entire array becomes sorted.

---------------------------------------------------------------
Time Complexity:
    - Best Case: O(n²)
    - Average Case: O(n²)
    - Worst Case: O(n²)
Space Complexity: O(1)
Stable: ❌ No
---------------------------------------------------------------
*/
public class selectionSort {
    public static void selection_Sort(int arr[]){
        for(int i=0;i<arr.length-1;i++){
            int min_ind=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[min_ind]>arr[j]){
                    min_ind=j;
                }
            }
            int temp=arr[min_ind];
            arr[min_ind]=arr[i];
            arr[i]=temp;
        }
    }
    public static void print_arr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
     public static void main(String[] args) {
        int arr[]={5,6,7,1,2,3,5,3};
        // selectionSort sort=new selectionSort();
        selection_Sort(arr);
        print_arr(arr);
    }
}
