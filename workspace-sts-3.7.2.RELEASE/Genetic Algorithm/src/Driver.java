import java.util.Arrays;

public class Driver {

	public static void main(String[] args) {

		Population population = new Population(GeneticAlgorithm.POPULATION_SIZE).initializePopulation();
		GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm();

		System.out.println("--------------------------------------------------------------");
		System.out.println(
				"Generation # 0 " + " | Fittest chromosome fitness: " + population.getChromosome()[0].getFitness());
		printPopulation(population, "Target Chromosome: " + Arrays.toString(GeneticAlgorithm.TARGET_CHROMOSOME));

		int generationNumber = 0;
		while (population.getChromosome()[0].getFitness() < GeneticAlgorithm.TARGET_CHROMOSOME.length) {
			generationNumber++;
			System.out.println("\n--------------------------------------------------------------");
			population = geneticAlgorithm.evolve(population);
			population.sortChromosomesByFitness();
			System.out.println("Generation # " + generationNumber + " | Fittest chromosome fitness: "
					+ population.getChromosome()[0].getFitness());
			printPopulation(population, "Target Chromosome: " + Arrays.toString(GeneticAlgorithm.TARGET_CHROMOSOME));
		}
	}

	public static void printPopulation(Population population, String heading) {
		System.out.println(heading);
		System.out.println("--------------------------------------------------------------");
		for (int i = 0; i < population.getChromosome().length; i++) {
			System.out.println("Chromosome  # " + i + "  : " + Arrays.toString(population.getChromosome()[i].getGenes())
					+ " | Fitness: " + population.getChromosome()[i].getFitness());
		}
	}
}
