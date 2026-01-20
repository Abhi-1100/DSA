/*
---------------------------------------------------------------
Program: N-Queen Problem in Java
Author: Abhi Kakadiya
Description:
    This program solves the classic N-Queen chess problem using
    the :contentReference[oaicite:0]{index=0} and
    :contentReference[oaicite:1]{index=1} approach.
    It places N queens on an N×N :contentReference[oaicite:2]{index=2}
    in such a way that no two queens threaten each other.

    The solution ensures:
    - No queen shares the same column (Vertical conflict)
    - No queen shares the same left diagonal (↖ conflict)
    - No queen shares the same right diagonal (↗ conflict)

Key Concepts:
    - Backtracking Algorithm
    - Recursive Exploration + Undo Step
    - Constraint Validation using isSafe()
    - 2D Matrix Traversal
---------------------------------------------------------------

Algorithm Steps:
1. Start from row 0 of the chess board.
2. Try placing queen ('Q') in each column of the current row.
3. Before placing, validate position using isSafe():
     a) Check vertical up column for any queen.
     b) Check left upper diagonal for any queen.
     c) Check right upper diagonal for any queen.
4. If safe, place 'Q' and recursively move to next row.
5. If recursive call returns (no solution ahead), remove 'Q'
   (replace with 'X') — Backtracking step.
6. When all rows are processed, print a valid board configuration.
---------------------------------------------------------------

Time Complexity: O(N!)
    - Worst case, we try all possible queen placements
      for each row and backtrack when invalid.

Space Complexity: O(N²)
    - N×N chess board + Recursion stack up to depth N.

Algorithm Type: Recursive Backtracking with Pruning
---------------------------------------------------------------

Example:
Input  : N = 4
Output :
    2 valid board configurations printed such as:

    Q X X X
    X X Q X
    X Q X X
    X X X Q

---------------------------------------------------------------
*/


public class NQueen {
    public static void Nqueen(char Bord[][] , int row){
        //Base con..
        if(row == Bord.length){
            Print(Bord);
            return;
        }
        //Rec fun..
        for(int j=0 ; j< Bord.length ; j++){
            if(isSafe(Bord, row ,j)){
                Bord[row][j]='Q';
                Nqueen(Bord, row+1);
                Bord[row][j]='X';
            }

        }
    }

    public static boolean isSafe(char Bord[][] , int row, int col){

        // Vertical up
        for(int i=row-1 ; i>=0 ; i--){
            if(Bord[i][col]=='Q'){
                return false;
            }
        }
        // left diag..
        for(int i=row-1 , j=col-1 ; i>=0 && j>=0 ; i--,j--){
            if(Bord[i][j]=='Q'){
                return false;
            }
        }
        // right diag..
        for(int i=row-1 , j=col+1 ; i>=0 && j<Bord.length ; i--,j++){
            if(Bord[i][j]=='Q'){
                return false;
            }
        }

        return true;

    }

    public static void Print(char Bord[][]){
        System.out.println("-----------chess Bord------------");
        for(int i=0 ; i< Bord.length; i++){
            for(int j=0 ; j<Bord.length ; j++){
                System.out.print(Bord[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        int n=4;
        char Bord[][]= new char[n][n];
        for(int i=0 ; i< Bord.length; i++){
            for(int j=0 ; j<Bord.length ; j++){
                System.out.print(Bord[i][j]='X');
            }           
        }
        Nqueen(Bord , 0);

    }
}
