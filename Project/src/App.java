import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App{
    public static void main(String[] args) throws FileNotFoundException{
        // Scanner sc = new Scanner(System.in);
        
        // //input panjang array 2 dimensi untuk generate minesweeper
        // System.out.println("Input size array");
        // int boardSize = sc.nextInt();
        // System.out.println("Input population size");
        // int populationSize = sc.nextInt();
        // //generate array berdasarkan size

        // // i = baris
        // // j = kolom
        
        // //instansiasi papan permainan, papan untuk memeriksa jawabannya, dan papan yang menampung solusi dalam bentuk binary
        // int[][] minesweeperBoard = new int[boardSize+2][boardSize+2];
        // String[][] minesweeperCheck = new String[boardSize+2][boardSize+2];
        // int[][] answer = new int[boardSize+2][boardSize+2];

        // System.out.println("Input board");
        // for (int i = 0; i < minesweeperBoard.length; i++) {
        //     for (int j = 0; j < minesweeperBoard.length; j++) {
        //         if(i==0||i==minesweeperBoard.length-1||j==0||j==minesweeperBoard.length-1){
        //             minesweeperBoard[i][j] = -1;
        //             minesweeperCheck[i][j]="bisajadi";
        //         }else if(i!=0||i!=minesweeperBoard.length-1||j!=0||j!=minesweeperBoard.length-1){
        //             //input angka yang ingin di input dimana (i,j) i = baris, j = kolom
        //             int num = sc.nextInt();
        //             //put num to board
        //             minesweeperBoard[i][j] = num;

        //             minesweeperCheck[i][j]="bisajadi";
        //         }
        //     }
        // }


        File file = new File("D:/Users/Erwin Darsono/Desktop/PSC-14");
        Scanner sc = new Scanner(file);
        String input = sc.nextLine();
        String[] arrSplit = input.split(",");
        int kotak = (int) Math.sqrt(arrSplit.length);
        int boardSize = (int) Math.sqrt(arrSplit.length);

        int[][] minesweeperBoard = new int[kotak+2][kotak+2];
        String[][] minesweeperCheck = new String[kotak+2][kotak+2];
        int[][] answer = new int[boardSize+2][boardSize+2];

        int index = 0;
        int populationSize = 20;

        for (int i = 0; i < minesweeperBoard.length; i++) {
            for (int j = 0; j < minesweeperBoard.length; j++) {
                if(i==0||i==minesweeperBoard.length-1||j==0||j==minesweeperBoard.length-1){
                    minesweeperBoard[i][j] = -1;
                    minesweeperCheck[i][j]="bisajadi";
                }
                else if(i!=0||i!=minesweeperBoard.length-1||j!=0||j!=minesweeperBoard.length-1){
                    int num = Integer.parseInt(arrSplit[index]);
                    System.out.println(num);
                    index++;
                    //put num to board
                    minesweeperBoard[i][j] = num;
                }
            }
        }

        printBoard(minesweeperBoard);

        //Inisialisasi objek Solver untuk menyelesaikan puzzle tanpa menggunakan algoritma genetik
        // Solver solver = new Solver(minesweeperBoard, minesweeperCheck, answer, (int)Math.pow(boardSize,2));
        // solver.begin();

        // int[] target = solver.convertToArray();

        // initializePopulation(populationSize, boardSize, target);
    }

    public static void initializePopulation(int populationSize, int boardSize, int[] target){
        Population population = new Population(populationSize, (int)Math.pow(boardSize,2), target);
        population.generateInitialPopulation();
        population.calculateFitness();
        population.printInfo();
    }

    public static void printBoard(int[][] minesweeperBoard){
        System.out.println("Tes papan");
        for (int i = 0; i < minesweeperBoard.length; i++) {
            for (int j = 0; j < minesweeperBoard.length; j++) {
                System.out.print(minesweeperBoard[i][j]);
            }
            System.out.println();
        }
    }
}