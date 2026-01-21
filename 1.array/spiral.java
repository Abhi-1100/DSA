/*
 * Program: Spiral Matrix Traversal
 * Description:
 * This program prints all the elements of a 2D array (matrix)
 * in a spiral order — starting from the top-left corner and
 * moving right, down, left, and up in layers toward the center.
 *
 * Approach:
 * - Define four boundary variables: startRow, endRow, startCol, endCol.
 * - Traverse:
 *     1. From left to right across the top row.
 *     2. From top to bottom along the rightmost column.
 *     3. From right to left across the bottom row.
 *     4. From bottom to top along the leftmost column.
 * - After completing each layer, move the boundaries inward.
 * - Continue until all elements are printed.
 *
 * Example:
 * Input Matrix:
 * 1 2 4
 * 7 8 4
 * 4 2 9
 *
 * Output:
 * 1 2 4 4 9 2 4 7 8
 */

import java.util.*;
class spiral{
    public static void Spiral_print(int arr[][]){
        int startRow=0;
        int startCol=0;
        int endRow=arr.length-1;
        int endCol=arr[0].length-1;
        while(startRow<=endRow && startCol<=endCol){
            for(int j=startCol;j<=endCol;j++){
                System.out.print(arr[startRow][j]+" ");
            }
            for(int i=startRow+1;i<=endRow;i++){
                System.out.print(arr[i][endCol]+" ");
            }
            for(int j=endCol-1;j>=startCol;j--){
                System.out.print(arr[endRow][j]+" ");
            }
            for(int i=endRow-1;i>=startRow+1;i--){
                System.out.print(arr[i][startCol]+" ");
                
            }
            startRow++;
            startCol++;
            endCol--;
            endRow--;
        }
         //System.out.println();
    }
         public static void main(String[] args){
        int arr[][]={{1,2,4},{7,8,4},{4,2,9}};
        Spiral_print(arr);
         }
    }
   
