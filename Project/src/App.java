import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App{
    public static void main(String[] args) throws FileNotFoundException{
        File file = new File("D:/Erwin Darsono/minesweeper.txt");
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
                    // System.out.println(num);
                    index++;
                    //put num to board
                    minesweeperBoard[i][j] = num;
                }
            }
        }

        // printBoard(minesweeperBoard);

        // Inisialisasi objek Solver untuk menyelesaikan puzzle tanpa menggunakan algoritma genetik
        Solver solver = new Solver(minesweeperBoard, minesweeperCheck, answer, (int)Math.pow(boardSize,2));
        solver.begin();

        int[] target = solver.convertToArray();

        initializePopulation(populationSize, boardSize, target);
    }

    public static void initializePopulation(int populationSize, int boardSize, int[] target){
        Population population = new Population(populationSize, (int)Math.pow(boardSize,2), target);
        population.generateInitialPopulation();
        population.calculateFitness();
        population.printInfo();
    }

    // public static void printBoard(int[][] minesweeperBoard){
    //     System.out.println("Tes papan");
    //     for (int i = 1; i < minesweeperBoard.length-1; i++) {
    //         for (int j = 1; j < minesweeperBoard.length-1; j++) {
    //             System.out.print(minesweeperBoard[i][j]+"\t");
    //         }
    //         System.out.println();
    //     }
    // }
}