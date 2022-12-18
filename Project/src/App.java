import java.util.Scanner;

public class App{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        //input panjang array 2 dimensi untuk generate minesweeper
        System.out.println("Input size array");
        int boardSize = sc.nextInt();
        //generate array berdasarkan size

        // i = baris
        // j = kolom
        
        //instansiasi papan permainan, papan untuk memeriksa jawabannya, dan papan yang menampung solusi dalam bentuk binary
        int[][] minesweeperBoard = new int[boardSize+2][boardSize+2];
        String[][] minesweeperCheck = new String[boardSize+2][boardSize+2];
        int[][] answer = new int[boardSize+2][boardSize+2];

        for (int i = 0; i < minesweeperBoard.length; i++) {
            for (int j = 0; j < minesweeperBoard.length; j++) {
                if(i==0||i==minesweeperBoard.length-1||j==0||j==minesweeperBoard.length-1){
                    minesweeperBoard[i][j] = -1;
                    minesweeperCheck[i][j]="bisajadi";
                }else if(i!=0||i!=minesweeperBoard.length-1||j!=0||j!=minesweeperBoard.length-1){
                    //input angka yang ingin di input dimana (i,j) i = baris, j = kolom
                    int num = sc.nextInt();
                    //put num to board
                    minesweeperBoard[i][j] = num;

                    minesweeperCheck[i][j]="bisajadi";
                }
            }
        }

        //Inisialisasi objek Solver untuk menyelesaikan puzzle tanpa menggunakan algoritma genetik
        Solver solver = new Solver(minesweeperBoard, minesweeperCheck, answer);

        Thread t1 = new Thread(solver);
        t1.start();
        // solver.printBoard();

        // Population population = new Population(10, boardSize*boardSize, );
    }
}
