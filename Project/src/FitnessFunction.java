
import java.util.Random;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author reinasyar
 */
public class FitnessFunction {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] board = new int[size*size];
        
        for(int i=0; i<size*size; i++){
            board[i] = sc.nextInt();
        }
        int[] chromosome = generateRnd(size);
        
        Ffunction fitness = new Ffunction(chromosome, board, size);
        Double res = fitness.fitnessFunction();
        System.out.println("chromosome:");
        for(int i=0; i<size*size;i++){
            System.out.print(chromosome[i]+" ");
        }
        System.out.println("");
        System.out.println("fitness function: "+res);
    }
    
    public static int[] generateRnd(int size){
        Random rand = new Random();
        int[] chromosome = new int[size*size];
        for(int i=0; i<size*size; i++){
            chromosome[i] = rand.nextInt(2);
        }
        return chromosome;
    }
}
class Ffunction{
    
    private int[] chromosome;
    private int[] board;
    private int size;
    
    public Ffunction(int[] chromosome, int[] board, int size){
        this.chromosome = chromosome;
        this.board = board;
        this.size = size;
    }
    
    public Double fitnessFunction(){
        Double res =0.0;
        
        int[][] cMatrix = new int[size+2][size+2];
        int[][] bMatrix = new int[size+2][size+2];
        
        for(int i=0; i<size+2; i++){
            for(int j=0; j<size+2; j++){
                if(i==0||j==0||i==size+1||j==size+1){
                    cMatrix[i][j]=-1;
                    bMatrix[i][j]=-1;
                }
                else{
                    cMatrix[i][j]=chromosome[i+j];
                    bMatrix[i][j]=board[i+j];
                }
            }
        }
        
        Double countAngka = 0.0;
        Double countIya = 0.0;
        
        for(int i=1; i<size+1; i++){
            for(int j=1; j<size+1; j++){
                if(bMatrix[i][j]>-1){
                    countAngka+=bMatrix[i][j];
                    int countAngkaTemp = bMatrix[i][j];
                    int countIyaTemp=0;
                    if(cMatrix[i][j]==1){
                        countIyaTemp++;
                    }
                    if(cMatrix[i-1][j]==1){
                        countIyaTemp++;
                    }
                    if(cMatrix[i+1][j]==1){
                        countIyaTemp++;
                    }
                    if(cMatrix[i][j-1]==1){
                        countIyaTemp++;
                    }
                    if(cMatrix[i][j+1]==1){
                        countIyaTemp++;
                    }
                    if(cMatrix[i-1][j-1]==1){
                        countIyaTemp++;
                    }
                    if(cMatrix[i-1][j+1]==1){
                        countIyaTemp++;
                    }
                    if(cMatrix[i+1][j-1]==1){
                        countIyaTemp++;
                    }
                    if(cMatrix[i+1][j+1]==1){
                        countIyaTemp++;
                    }
                    if(countIyaTemp<=countAngkaTemp){
                        countIya+=countIyaTemp;
                    }
                }
            }
        }
        if(countAngka>0){
            res = countIya/countAngka;
            return res;
        }
        return res;
    }
}
