import java.util.LinkedList;

class Population {
    int populationSize;
    int chromosomeSize;
    Object[] chromosome;
    int[] target;

    public Population(int populationSize, int chromosomeSize, int[] target){
        this.populationSize = populationSize;
        this.target = target;
        this.chromosome = new Object[populationSize];
        for (int i = 0; i < populationSize; i++) {
            chromosome[i] = new int[chromosomeSize];
        }
    }
}