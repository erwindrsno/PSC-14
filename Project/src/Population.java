import java.util.LinkedList;
import java.util.Random;

class Population {
    int populationSize;
    int chromosomeLength;
    // Object[] chromosome;
    int[] target;

    LinkedList<Integer>[] chromosome;

    public Population(int populationSize, int chromosomeLength, int[] target){
        this.populationSize = populationSize;
        this.target = target;
        this.chromosomeLength = chromosomeLength;

        this.chromosome = new LinkedList[populationSize];
        for (int i = 0; i < populationSize; i++) {
            chromosome[i] = new LinkedList<>();
        }
    }

    public void generateInitialPopulation(){
        for (int i = 0; i < populationSize; i++) {
            for (int j = 0; j < chromosomeLength; j++) {
                Random rand = new Random();
                int num = rand.nextInt(2);
                chromosome[i].add(num);
            }
        }
        // System.out.println("size chromosome ke-1: " + chromosome[0].size());
    }

    public void printInfo(){
        // System.out.println("Population size: " + this.populationSize);
        // System.out.println("chromosome Length: " + this.chromosomeLength+"\n");
        // System.out.println("chromosome Length 2: " + this.chromosome.length+"\n");

        // for (int i = 0; i < populationSize; i++) {
        //     for (int j = 0; j < chromosome.length; j++) {
        //         System.out.print(chromosome[i].get(j)+" ");
        //     }
        //     System.out.println();
        // }
        // for (int i = 0; i < chromosome[0].size(); i++) {
        //     System.out.print(chromosome[0].get(i)+" ");
        // }
        for (int i = 0; i < populationSize; i++) {
            System.out.print("Chromosome ke-"+(i+1)+": ");
            for (int j = 0; j < chromosome[i].size(); j++) {
                System.out.print(chromosome[i].get(j));
            }
            System.out.println();
        }
    }
}
//how to create array of linkedlist in java?