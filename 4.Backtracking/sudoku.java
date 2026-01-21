/*
---------------------------------------------------------------
Program: Sudoku Solver in Java
Author: Abhi Kakadiya
Description:
    This program solves a standard 9×9 sudoku puzzle using the
    :contentReference[oaicite:0]{index=0} technique
    combined with recursive grid traversal and constraint validation.

    A valid placement ensures:
      - No repetition in the same column (Vertical check ↑↓)
      - No repetition in the same row (Horizontal check →←)
      - No repetition in the 3×3 sub-grid (Local grid check □)

    It automatically skips pre-filled cells and tries digits from
    1 to 9 where value = 0 (empty), backtracks if constraints fail,
    and confirms if at least one solution exists.

Key Concepts:
    - Constraint-based Backtracking
    - Recursive State Space Search
    - 2D Matrix Traversal
    - Pruning using issafe()
---------------------------------------------------------------

Algorithm Steps:
1. Base Case:
   - If row == 9, all rows are completed → return true.
2. Coordinate Progression:
   - Continue next column (col+1).
   - If col == 8, move to next row (row+1, col=0).
3. Skip Pre-Filled Cells:
   - If board[row][col] != 0, recursively solve next cell.
4. Try All Digits (1–9):
   - If issafe() returns true, place digit and recurse.
   - If recursion fails, reset cell to 0 (Backtracking step).
5. Return false if no digit fits.
---------------------------------------------------------------

Time Complexity: O(9^(n*n))
    - Worst case tries 9 options for each empty cell.

Space Complexity: O(n²)
    - 9×9 board storage + recursion stack depth up to 81.

Algorithm Type: Recursive Grid Backtracking with Constraint Pruning
---------------------------------------------------------------

Example:
Input Grid (partial):
    5 3 0 | 0 7 0 | 0 0 0
    6 0 0 | 1 9 5 | 0 0 0
    0 9 8 | 0 0 0 | 0 6 0
    ...
Empty cells are marked as 0 and attempted in solution.

Output:
    Prints whether "Solution Exist" or "Solution Doesn't Exist"
    based on puzzle validity.
---------------------------------------------------------------
*/

public class sudoku {
    public static boolean issafe(int bord[][], int row, int col, int digit){
        // vertical check
        for(int i=0; i< bord.length; i++){
            if(bord[i][col]==digit){
                return false;
            }
        }
        // horizontal check
        for(int j=0; j< bord.length; j++){
            if(bord[row][j] == digit){
                return false;
            }
        }
        // grid check
        int Strrow=(row/3)*3;
        int Strcol=(col/3)*3;
        for(int i=Strrow; i<Strrow+3; i++){
            for(int j=Strcol; j<Strcol+3; j++){
                if(bord[i][j]==digit){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean SudokuSolver(int bord[][], int row, int col){
        //Base cond..
       if (row == 9) {
            return true;
        }
        // rec func
        int Nxtrow=row , Nxtcol=col+1;  //for itrart to next col
        if(col+1 == 9){
            Nxtrow=row+1;  // when col reaches to end then strat from next row
            Nxtcol=0;
        }
        if(bord[row][col] != 0){
            return SudokuSolver(bord, Nxtrow, Nxtcol);
        }
        for(int Digit=1; Digit<=9; Digit++){
            if(issafe(bord, row , col ,Digit)){
                bord[row][col]=Digit;  //test it from 1 to 9
                if(SudokuSolver(bord, Nxtrow, Nxtcol)){
                    return true;
                }
                bord[row][col]=0; //
            }
        }
        return false;
    }
    public static void main(String[] args){

        int sudoku1[][] = {
                {5, 3, 0,  0, 7, 0,  0, 0, 0},
                {6, 0, 0,  1, 9, 5,  0, 0, 0},
                {0, 9, 8,  0, 0, 0,  0, 6, 0},

                {8, 0, 0,  0, 6, 0,  0, 0, 3},
                {4, 0, 0,  8, 0, 3,  0, 0, 1},
                {7, 0, 0,  0, 2, 0,  0, 0, 6},

                {0, 6, 0,  0, 0, 0,  2, 8, 0},
                {0, 0, 0,  4, 1, 9,  0, 0, 5},
                {0, 0, 0,  0, 8, 0,  0, 7, 9}
        };
        int sudoku2[][] = {
                {5, 1, 6,  8, 4, 9,  7, 3, 2},
                {3, 0, 7,  6, 0, 5,  0, 0, 0},
                {8, 0, 0,  7, 0, 0,  0, 6, 5},

                {1, 3, 5,  0, 6, 7,  0, 0, 0},
                {4, 7, 2,  5, 9, 0,  0, 0, 0},
                {6, 2, 8,  4, 7, 3,  5, 1, 9},

                {7, 6, 3,  9, 0, 4,  0, 5, 1},
                {2, 5, 1,  3, 8, 6,  9, 7, 4},
                {3, 8, 4,  1, 5, 2,  6, 9, 8}  // duplicate 3 in column 0 → unsolvable
        };

        if(SudokuSolver(sudoku2,0,0)){
            System.out.println("Solution Exist");
        }else {
            System.out.println(("Solution Dosen't Exist"));
        }

    }
}
