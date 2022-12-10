import java.util.Scanner;

public class App{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        //input panjang array 2 dimensi untuk generate minesweeper
        int sizeArray = 5;

        //generate array berdasarkan size

        // i = baris
        // j = kolom

        //instansiasi array 2 dimensi
        int[][] minesweeperBoard = new int[5][5];
        String[][] minesweeperCheck = new String[5][5];
        for (int i = 0; i < sizeArray; i++) {
            for (int j = 0; j < sizeArray; j++) {
                //input angka yang ingin di input dimana (i,j) i = baris, j = kolom
                int num = sc.nextInt();
                
                //put num to board
                minesweeperBoard[i][j] = num;
                
                minesweeperCheck[i][j]="bisajadi";
            }
        }
        while(true){
            if(checkAll(minesweeperCheck)==true){
                break;
            }
            for (int i = 0; i < sizeArray; i++) {
                for (int j = 0; j < sizeArray; j++) {
                    //kalo jumlah kotak di sekitar angkaX == angkaX, kotak diisi string "ya"
                    //kalo angkaX == 0, kotak diisi string "tidak"
                    if(minesweeperBoard[i][j]==0){
                        minesweeperCheck[i][j]="tidak";
                        minesweeperCheck[i+1][j]="tidak";
                        minesweeperCheck[i-1][j]="tidak";
                        minesweeperCheck[i][j+1]="tidak";
                        minesweeperCheck[i][j-1]="tidak";
                        minesweeperCheck[i+1][j+1]="tidak";
                        minesweeperCheck[i+1][j-1]="tidak";
                        minesweeperCheck[i-1][j+1]="tidak";
                        minesweeperCheck[i-1][j-1]="tidak";
                    }else if(minesweeperBoard[i][j]==4 && ((i==0 && (j==0||j==4))||(i==4 && (j==0||j==4)))){
                        minesweeperCheck[i][j]="tidak";
                        minesweeperCheck[i+1][j]="tidak";
                        minesweeperCheck[i-1][j]="tidak";
                        minesweeperCheck[i][j+1]="tidak";
                        minesweeperCheck[i][j-1]="tidak";
                        minesweeperCheck[i+1][j+1]="tidak";
                        minesweeperCheck[i+1][j-1]="tidak";
                        minesweeperCheck[i-1][j+1]="tidak";
                        minesweeperCheck[i-1][j-1]="tidak";
                    }else if(minesweeperBoard[i][j]==6 && (i==0||i==4||j==0||j==4)){
                        minesweeperCheck[i][j]="tidak";
                        minesweeperCheck[i+1][j]="tidak";
                        minesweeperCheck[i-1][j]="tidak";
                        minesweeperCheck[i][j+1]="tidak";
                        minesweeperCheck[i][j-1]="tidak";
                        minesweeperCheck[i+1][j+1]="tidak";
                        minesweeperCheck[i+1][j-1]="tidak";
                        minesweeperCheck[i-1][j+1]="tidak";
                        minesweeperCheck[i-1][j-1]="tidak";
                    }
                    //kalo jumlah kotak "ya" di sekitar angka X == angkaX, kotak lainnya diisi "tidak"
                    else if(minesweeperBoard[i][j]>=0){
                        int hitung = 0;
                        if(minesweeperCheck[i][j].equals("ya")){
                            hitung++;
                        }
                        if(minesweeperCheck[i+1][j].equals("ya")){
                            hitung++;
                        }
                        if(minesweeperCheck[i-1][j].equals("ya")){
                            hitung++;
                        }
                        if(minesweeperCheck[i][j+1].equals("ya")){
                            hitung++;
                        }
                        if(minesweeperCheck[i][j-1].equals("ya")){
                            hitung++;
                        }
                        if(minesweeperCheck[i+1][j+1].equals("ya")){
                            hitung++;
                        }
                        if(minesweeperCheck[i+1][j-1].equals("ya")){
                            hitung++;
                        }
                        if(minesweeperCheck[i-1][j+1].equals("ya")){
                            hitung++;
                        }
                        if(minesweeperCheck[i-1][j-1].equals("ya")){
                            hitung++;
                        }

                        if(minesweeperBoard[i][j]==hitung){
                            if(!minesweeperCheck[i][j].equals("ya")){
                                minesweeperCheck[i][j]="tidak";
                            }
                            if(!minesweeperCheck[i+1][j].equals("ya")){
                                minesweeperCheck[i+1][j]="tidak";
                            }
                            if(!minesweeperCheck[i-1][j].equals("ya")){
                                minesweeperCheck[i-1][j]="tidak";
                            }
                            if(!minesweeperCheck[i][j+1].equals("ya")){
                                minesweeperCheck[i][j+1]="tidak";
                            }
                            if(!minesweeperCheck[i][j-1].equals("ya")){
                                minesweeperCheck[i][j-1]="tidak";
                            }
                            if(!minesweeperCheck[i+1][j+1].equals("ya")){
                                minesweeperCheck[i+1][j+1]="tidak";
                            }
                            if(!minesweeperCheck[i+1][j-1].equals("ya")){
                                minesweeperCheck[i+1][j-1]="tidak";
                            }
                            if(!minesweeperCheck[i-1][j+1].equals("ya")){
                                minesweeperCheck[i-1][j+1]="tidak";
                            }
                            if(!minesweeperCheck[i-1][j-1].equals("ya")){
                                minesweeperCheck[i-1][j-1]="tidak";
                            }
                        }
                    }  
                    
                    //kalo jumlah kotak "tidak" di sekitar angka X == (jumlah kotak di sekitar - angkaX), kotak lainnya diisi "ya"
                }  
            }
        }
        printBoard2(minesweeperCheck);
        //
//        printBoard(minesweeperBoard);
    }
    
    public static boolean checkAll(String[][] board){
        boolean check = true;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if(board[i][j].equals("bisajadi")){
                    check = false;
                    break;
                }                
            }
        }
        return check;
    }
    public static void printBoard(int[][] board){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void printBoard2(String[][] board){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
}
