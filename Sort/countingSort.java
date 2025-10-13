/*
---------------------------------------------------------------
Program: Counting Sort in Java
Author: Abhi Kakadiya
Description:
    This program demonstrates the Counting Sort algorithm.
    Counting Sort is a non-comparison-based sorting algorithm 
    that works by counting the occurrences of each element in 
    the input array and then reconstructing the sorted array 
    using those counts.

Key Concepts:
    - Non-comparison-based sorting algorithm
    - Frequency counting
    - Suitable for small ranges of non-negative integers
    - Uses an auxiliary array (count array) for sorting
---------------------------------------------------------------

Algorithm Steps:
1. Find the maximum element in the array to define the size of 
   the count array.
2. Initialize a count array of size (max + 1) with all zeros.
3. Count the frequency of each element in the original array.
4. Overwrite the original array using the counts — 
   repeatedly placing elements according to their frequencies.

---------------------------------------------------------------
Time Complexity:
    - Best Case: O(n + k)
    - Average Case: O(n + k)
    - Worst Case: O(n + k)
      (where n = number of elements, k = range of input)
Space Complexity: O(k)
Stable: ❌ No (but can be modified to be stable)
---------------------------------------------------------------
*/
public class countingSort {
    public static void Counting_sort(int arr[]){
        int max=Integer.MIN_VALUE;
            for(int i=0;i<arr.length;i++){
                max=Math.max(max, arr[i]);
            }
            int count[]=new int[max+1];
            for(int i=0;i<arr.length;i++){
                count[arr[i]]++;
            }
            int j=0;
            for(int i=0;i<count.length;i++){
                while (count[i]>0) {
                    arr[j]=i;
                    j++;
                    count[i]--;
                }
              }      
    }
    public static void print_arr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
   
    public static void main(String[] args) {
        int arr[]={9,7,6,6,2,4,5,1,5,6,4,2,8,5,7,8};
       
        Counting_sort(arr);
        print_arr(arr);
    }
}
