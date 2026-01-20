
public class NQueen_Count {
    static  int count;

    public static void Nqueen(char Bord[][] , int row){
        //Base con..
        if(row == Bord.length){
            count++;
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

    public static void main(String[] args){
        int n=4;
        char Bord[][]= new char[n][n];
        for(int i=0 ; i< Bord.length; i++){
            for(int j=0 ; j<Bord.length ; j++){
                Bord[i][j]='X';
            }
        }
        Nqueen(Bord , 0);
        System.out.println("Total Possibel Count is : "+count);

    }
}
