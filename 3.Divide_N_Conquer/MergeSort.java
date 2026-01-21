/*
---------------------------------------------------------------
Program: Merge Sort in Java
Author: Abhi Kakadiya
Description:
    This program demonstrates the Merge Sort algorithm — a
    Divide and Conquer sorting technique. It divides the array
    into two halves, recursively sorts each half, and then
    merges the two sorted halves to produce a fully sorted array.

Key Concepts:
    - Divide and Conquer Algorithm
    - Recursion
    - Merging two sorted subarrays
    - Uses temporary array for merging
---------------------------------------------------------------

Algorithm Steps:
1. Divide:
   - Recursively split the array into two halves until each
     subarray has only one element.
2. Conquer:
   - Recursively sort both halves using Merge Sort.
3. Combine (Merge):
   - Merge two sorted halves into a single sorted array using
     a temporary array.

Example Flow:
Input:  [6, 3, 9, 5, 2, 8]
Divide → [6,3,9] and [5,2,8]
Merge → [3,6,9] and [2,5,8]
Final Merge → [2,3,5,6,8,9]

---------------------------------------------------------------
Time Complexity:
    - Best Case: O(n log n)
    - Average Case: O(n log n)
    - Worst Case: O(n log n)
Space Complexity: O(n)  (due to temporary array)
Stable: ✅ Yes
Algorithm Type: Divide and Conquer, Recursive
---------------------------------------------------------------
Example:
Input  : arr = [6, 3, 9, 5, 2, 8]
Output : 2 3 5 6 8 9
---------------------------------------------------------------
*/

class MergeSort {
    public static  void Mergesort(int arr[],int si,int ei){
        if(si>=ei){
            return;
        }
        int mid=si+(ei-si)/2;
        Mergesort(arr,si,mid);
        Mergesort(arr,mid+1,ei);
        Merge(arr,si,mid,ei);
    }
    public static void Merge(int arr[] ,int si,int mid,int ei){
        int temp[]=new int[ei-si+1];
        int i=si;//
        int j=mid+1;//
        int k=0;//
        while(i<=mid && j<=ei ){
            if(arr[i]<arr[j]){
                temp[k]=arr[i];
                i++;
            }
            else{
                temp[k]=arr[j];
                j++;
            }
            k++;
        }
        while(i<=mid){
            temp[k++]=arr[i++];
        }
        while(j<=ei){
            temp[k++]=arr[j++];
        }
        for(k=0, i=si;k<temp.length;k++,i++){
            arr[i]=temp[k];
        }
    }
    public static  void print(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String[] args ){
        int arr[]={6,3,9,5,2,8};
//        Mergesort(arr,0,arr.length-1);
        print(arr);
    }
}