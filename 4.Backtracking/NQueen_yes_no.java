
public class NQueen_yes_no {
    public static boolean Nqueen(char Bord[][] , int row){
        //Base con..
        if(row == Bord.length){
            return true;
        }
        //Rec fun..
        for(int j=0 ; j< Bord.length ; j++){
            if(isSafe(Bord, row ,j)){
                Bord[row][j]='Q';
                if(Nqueen(Bord, row+1)){
                    return true;
                }
                Bord[row][j]='X';
            }

        }
        return false;
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
                Bord[i][j]='X';
            }
        }
        if(Nqueen(Bord , 0)){
            System.out.println("-----------Solution Found-----------");
            Print(Bord);
        }else {
            System.out.println("-----------Solution Not Found-----------");
        }

    }
}
