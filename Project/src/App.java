import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

/*
 * Referensi:
 *  - https://www.baeldung.com/java-genetic-algorithm#:~:text=Genetic%20algorithms%20are%20designed%20to,simplest%20binary%20genetic%20algorithm%20example.
 *  - https://www.youtube.com/watch?v=-jv3CgDN9sc&t=520s
 *  - Dokumentasi java
 *  - https://www.geeksforgeeks.org/linkedlist-set-method-in-java/
 */

public class App{
    public static void main(String[] args) throws FileNotFoundException{
        //Program menerima input dari file
        File file = new File("D:/Erwin Darsono/minesweeper.txt");
        Scanner sc = new Scanner(file);
        String input = sc.nextLine();
        //Mengubah input dari file menjadi dalam bentuk array
        String[] arrSplit = input.split(",");

        //Ukuran pappan dalam 1 dimensi
        int boardSize = (int) Math.sqrt(arrSplit.length);

        //instansiasi array 2 dimensi
        int[][] minesweeperBoard = new int[boardSize+2][boardSize+2];
        String[][] minesweeperCheck = new String[boardSize+2][boardSize+2];
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
                    index++;
                    //put num to board
                    minesweeperBoard[i][j] = num;
                    minesweeperCheck[i][j] = "bisajadi";
                }
            }
        }

        // printBoard(minesweeperCheck);

        // Inisialisasi objek Solver untuk menyelesaikan puzzle tanpa menggunakan algoritma genetik
        Solver solver = new Solver(minesweeperBoard, minesweeperCheck, answer, (int)Math.pow(boardSize,2));
        solver.begin();

        //convert target menjadi dalam bentuk array
        int[] target = solver.convertToArray();
        LinkedList<Integer> llTarget = new LinkedList<>();

        //simpan target dalam bentuk array
        for (int j = 0; j < target.length; j++) {
            llTarget.addLast(target[j]);
        }

        //inisialisasi populasi
        initializePopulation(populationSize, boardSize, target, llTarget);
    }

    public static void initializePopulation(int populationSize, int boardSize, int[] target, LinkedList<Integer> llTarget){
        //generate populasi awal, kalkulasi fitness-nya dan pemilihan parents dengan cara roulette wheel berdasarkan score fitness functionnya.
        Population population = new Population(populationSize, (int)Math.pow(boardSize,2), target);
        population.generateInitialPopulation();
        population.calculateFitness();
        // population.printInfo();
        population.selectParents();

        //selama tidak menemukan global maksimum, akan selalu generate generasi yang baru.
        while(true){
            population.calculateFitness();
            population.selectParents();
            population.generateNewPopulation();
            boolean identical = false;
            //iterasi setiap kromosom
            for (int index = 0; index < populationSize; index++) {
                boolean valid = true;
                //iterasi setiap gen dalam kromosom
                for (int i = 0; i < target.length; i++) {
                    //jika pada gen ke-index terdapat perbedaan dengan target, maka looping akan break dan iterasi ke kromosom selanjutnya
                    if(!population.chromosome[index].get(i).equals(llTarget.get(i))){
                        valid = false;
                        break;
                    }
                }
                System.out.println("Generation ke : " + population.generation);
                //jika global maksimum berhasil ditemukan
                if(valid == true){
                    identical = true;
                    break;
                }
            }
            //jika global maksimum berhasil ditemukan, maka looping akan break
            if(identical == true){
                System.out.println("Generation yang dibutuhkan untuk menemukan solusi: " + population.generation);
                System.out.println();
                break;
            }
        }
    }

    public static void printBoard(String[][] minesweeperBoard){
        System.out.println("Tes papan");
        for (int i = 1; i < minesweeperBoard.length-1; i++) {
            for (int j = 1; j < minesweeperBoard.length-1; j++) {
                System.out.print(minesweeperBoard[i][j]+"\t");
            }
            System.out.println();
        }
    }
}