import java.util.LinkedList;
import java.util.Random;

class Population implements FitnessFunction {
    int populationSize;
    int chromosomeLength;
    // Object[] chromosome;
    int[] target;
    double[] arrScore;

    LinkedList<Integer>[] chromosome;

    public Population(int populationSize, int chromosomeLength, int[] target){
        this.populationSize = populationSize;
        this.target = target;
        this.chromosomeLength = chromosomeLength;
        this.arrScore = new double[populationSize];
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
            System.out.print(" ,fitness: " + arrScore[i] + "%"+ "\n");
        }
    }

    @Override
    public void calculateFitness() {
        // TODO Auto-generated method stub
        for (int i = 0; i < populationSize; i++) {
            int score = 0;
            for (int j = 0; j < chromosome[i].size(); j++) {
                if(chromosome[i].get(j) == target[j]){
                    score++;
                }
            }
            // System.out.println(score/(double)chromosome[i].size()*1.0);
            arrScore[i] = (score/(double)chromosome[i].size()*1.0)*100.0;
        }
    }
}