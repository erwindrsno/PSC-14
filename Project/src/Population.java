import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

class Population implements FitnessFunction, RouletteWheel{
    int populationSize;
    int chromosomeLength;
    int[] target;
    double[] arrScore;
    LinkedList<Integer>[] pair;
    int generation;

    LinkedList<Integer>[] chromosome;
    LinkedList<Integer>[] child;

    public Population(int populationSize, int chromosomeLength, int[] target){
        this.populationSize = populationSize;
        this.target = target;
        this.chromosomeLength = chromosomeLength;
        this.arrScore = new double[populationSize];
        this.chromosome = new LinkedList[populationSize];
        this.child = new LinkedList[populationSize];
        this.generation = 1;
        for (int i = 0; i < populationSize; i++) {
            chromosome[i] = new LinkedList<>();
            child[i] = new LinkedList<>();
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

    public void generateNewPopulation(){
        // this.chromosome = this.child;
        // i sampai 20
        // j sampai 25
        for (int i = 0; i < populationSize; i++) {
            for (int j = 0; j < chromosome[i].size(); j++) {
                chromosome[i].set(j,child[i].get(j));
                // System.out.print(child[i].get(j)+" ");
                // System.out.print(child[i].size());
            }
            // System.out.println();
        }
        this.generation++;
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
        //menghitung fitness function
        for (int i = 0; i < populationSize; i++) {
            int score = 0;
            //jika pada gen ke-j terdapat nilai yang sama dengan target, maka score fitness function bertambah 1
            for (int j = 0; j < chromosome[i].size(); j++) {
                if(chromosome[i].get(j) == target[j]){
                    score++;
                }
            }
            //konversi score ke dalam bentuk persen
            arrScore[i] = (score/(double)chromosome[i].size()*1.0)*100.0;
        }
    }

    @Override
    public void selectParents() {
        //hitung total fitness score
        double totalFitness = 0;
        for (int i = 0; i < arrScore.length; i++) {
            totalFitness += arrScore[i];
        }

        //membuat array probabilitas sepanjang size populasi
        double[] arrProbability = generateProbability(totalFitness);
        //hitung total probabilitas
        double totalProbability = totalProbability(arrProbability);

        // System.out.println("total prob: " + totalProbability);

        //membuat pool untuk memilih parent
        LinkedList<Integer>[] roulettePool = new LinkedList[(int)totalProbability];

        //konsep pembuatan roulette pool adalah sebagai berikut:
        //misal parent a probabilitas 40%, b 30%, c 30%
        //maka pool nya menjadi [a,a,a,a,b,b,b,c,c,c]
        int index = 0;
        int penanda = 0;
        for (int i = 0; i < roulettePool.length; i++) {
            if(penanda != arrProbability[index]){
                penanda++;
                roulettePool[i] = chromosome[index];
            }
            else{
                roulettePool[i] = chromosome[index];
                index++;
                penanda = 0;
            }
        }

        //crossover 10 anak pertama
        for (int i = 0; i < child.length; i++) {
            child[i] = crossOver();
        }
        //crossover 10 anak terakhir
        for (int i = 10; i < child.length; i++) {
            child[i] = crossOver();
        }
    }

    //mutasi salah satu index secara random
    public void mutate(LinkedList<Integer> anak){
        //generate angka random dari 0-24
        int max = 24;
        int min = 0;
        int range = max-min+1;
        int rand = (int)(Math.random() * range) + min;
        //mutasi salah satu index berdasarkan rand
        if(anak.get(rand) == 0){
            anak.remove(rand);
            anak.add(rand,1);
        }
        else{
            anak.remove(rand);
            anak.add(rand,0);
        }
    }

    //crossover
    public LinkedList<Integer> crossOver(){
        //generate angka random dari 0 - 19
        int max = 19;
        int min = 0;
        int range = max-min+1;
        int rand = (int)(Math.random() * range) + min;

        //instansiasi parent 1 dan 2
        LinkedList<Integer> parent1 = chromosome[rand];
        LinkedList<Integer> parent2 = chromosome[rand];
        LinkedList<Integer> child = new LinkedList<>();
        //instansiasi string untuk keperluan encode
        String strChild = "";
        String strP1 = "";
        String strP2 = "";
        //encode linkedlist ke dalam bentuk string, agar mempermudahkan crossover dengan cara substring
        for (int i = 0; i < parent1.size(); i++) {
            strP1 += parent1.get(i);
            strP2 += parent2.get(i);
        }
        //terjadinya crossover
        strChild += strP1.substring(0,12);
        strChild += strP2.substring(12,25);

        //tambahkan hasil encoding ke dalam linkedlist kembali
        for (int i = 0; i < strChild.length(); i++) {
            child.addLast(Integer.parseInt(String.valueOf(strChild.charAt(0))));
        }
        //mutasi anak
        mutate(child);
        return child;
    }

    public double[] generateProbability(double totalFitness){
        double totalProb = 0;
        double[] arrProbability = new double[populationSize];
        for (int i = 0; i < arrScore.length; i++) {
            //perhitungan probabilitas: fitness dibagi dengan total fitness
            arrProbability[i] = (arrScore[i]/totalFitness)*100;
            //jika probabilitas desimal > 0.5, maka dibulat ke atas
            if(arrProbability[i] - Math.floor(arrProbability[i]) >= 0.5){
                arrProbability[i] = Math.ceil(arrProbability[i]);
            }
            //jika probabilitas desimal < 0.5, maka dibulat ke bawah
            else{
                arrProbability[i] = Math.floor(arrProbability[i]);
            }
            totalProb += arrProbability[i];
            // System.out.println("probabilitas: " + arrProbability[i]);
        }
        return arrProbability;
    }

    public double totalProbability(double[] arr){
        double total = 0;
        for (int i = 0; i < arr.length; i++) {
            total += arr[i];
        }
        return total;
    }
}