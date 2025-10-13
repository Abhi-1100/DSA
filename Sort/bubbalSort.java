/*
---------------------------------------------------------------
Program: Bubble Sort in Java
Author: Abhi Kakadiya
Description:
    This program demonstrates the Bubble Sort algorithm — 
    one of the simplest sorting techniques. It repeatedly
    compares adjacent elements and swaps them if they are 
    in the wrong order. The pass continues until the array
    is completely sorted.

Key Concepts:
    - Iterative Sorting Algorithm
    - Nested Loops
    - Swapping Elements
    - Optimization using a flag (for early termination)
---------------------------------------------------------------
*/
import java.util.*;
 
class bubbalSort{
   public static void swap(int arr[],int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
   public static void Bubbal_sort(int arr[]){
    int flage=0;
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                    flage+=1;
                }
                
            }
            if(flage==0){
                    return;
                }
        }
        System.out.println(flage);
    }
   public static void print_arr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
   
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,};
       
        Bubbal_sort(arr);
        print_arr(arr);
    }
}