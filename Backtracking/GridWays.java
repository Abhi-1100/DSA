/*
---------------------------------------------------------------
Program: Grid Ways Problem in Java
Author: Abhi Kakadiya
Description:
    This program calculates the number of unique paths from the
    top-left corner to the bottom-right corner of a 2D grid
    using a :contentReference[oaicite:0]{index=0} +
    recursive traversal approach.

    Movement rules:
      - You can only move Right → (j+1)
      - You can only move Down  ↓ (i+1)

    It explores all valid paths recursively and counts only those
    that successfully reach the destination without crossing boundaries.

Key Concepts:
    - Recursive Backtracking (Explore + Count)
    - Base Case handling for destination & boundary conditions
    - Decision tree traversal on 2D grid coordinates
---------------------------------------------------------------

Algorithm Steps:
1. Base Case – Destination:
   - If (i, j) reaches last cell i == n-1 and j == m-1,
     return 1 as one valid path found.
2. Boundary Check:
   - If i == n or j == m, return 0 (invalid path).
3. Recursive Exploration:
   - Move Right  → recursively call (i, j+1)
   - Move Down   ↓ recursively call (i+1, j)
4. Add results from both moves and return total paths.
---------------------------------------------------------------

Time Complexity: O(2^(n+m))
    - At each cell we have 2 choices (Right or Down)
      leading to exponential path exploration.

Space Complexity: O(n+m)
    - Recursion stack grows up to maximum depth n+m.

Algorithm Type: Recursive Grid Backtracking
---------------------------------------------------------------

Example:
Input  : n = 3, m = 3
Grid   :
    (0,0) → → → (2,2)
Output :
    Total Ways : 6
    Paths include combinations of Right and Down such as:
        R R D D
        R D R D
        D R R D
        etc.
---------------------------------------------------------------
*/


public class GridWays {
    public static int CountWays(int i, int j, int n, int m){
        //Base Cond..
        if(i==n-1 && j==m-1){ // Last Cell
            return 1;
        } else if (i==n || j==m) { //boundary Cross
            return 0;
        }
        int W1=CountWays(i , j+1 , n , m);//Right
        int W2=CountWays(i+1 , j , n , m);//Down 
        return W1+W2;
    }
    public static void main(String[] args){
        int n=3 , m=3;
        System.out.println("Total Ways : "+CountWays(0,0,n,m));
    }
}
