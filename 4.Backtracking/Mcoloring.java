
class Mcoloring{
    static int n;

static boolean issafe(int[][] graph ,int[] colors , int Vertex, int color){
    for(int i=0;i<n;i++){
        if(graph[Vertex][i]==1 && colors[i]==color){
            return false;
        }
    }
    return true;
}

static boolean solve(int[][] graph, int m, int[] colors, int Vertex){
        if(Vertex == n){
            return true;
        }
        for(int color=1;color<=m;color++){
            if(issafe(graph , colors, Vertex, color)){
                colors[Vertex]=color;
                if(solve(graph, m, colors, Vertex+1)){
                    return true;
                }
                colors[Vertex]=0;
            }
        }

    
    return false;
}

    static void mColoring(int[][] graph, int m) {
        int[] colors = new int[n]; // All 0 (uncolored)

        if (solve(graph, m, colors, 0)) {
            System.out.println("Solution exists with M=" + m + " colors:");
            for (int i = 0; i < n; i++)
                System.out.println("  Vertex " + (i + 1) + " --> Color " + colors[i]);
        } else {
            System.out.println("No solution exists with M=" + m + " colors.");
        }
    }

    public static void main(String[] args){
         n = 5;
        int[][] graph = {
            {0, 1, 1, 1, 0},
            {1, 0, 1, 0, 1},
            {1, 1, 0, 1, 0},
            {1, 0, 1, 0, 1},
            {0, 1, 0, 1, 0}
        };
        int M = 3;
        mColoring(graph, M);
    }
}