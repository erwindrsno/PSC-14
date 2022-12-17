import java.util.Scanner;

public class Main2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        //input panjang array 2 dimensi untuk generate minesweeper
        int sizeArray = 5;

        //generate array berdasarkan size

        // i = baris
        // j = kolom

        //instansiasi array 2 dimensi
        int[][] minesweeperBoard = new int[5][5];
        for (int i = 0; i < sizeArray; i++) {
            for (int j = 0; j < sizeArray; j++) {
                //input angka yang ingin di input dimana (i,j) i = baris, j = kolom
                int num = sc.nextInt();
                
                //put num to board
                minesweeperBoard[i][j] = num;
                
            }
        }
        // printBoard2(minesweeperCheck);
        //
        printBoard(minesweeperBoard);
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
                System.out.print(board[i][j]+"\t\t");
            }
            System.out.println();
        }
    }
}
