
public class GeneticAlgorithm {

	public static final int POPULATION_SIZE = 8;
	public static final int[] TARGET_CHROMOSOME = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
	private static final double MUTAION_RATE = 0.025;
	public static final int NUM_OF_ELITE_CHROMOSOMES = 1;
	public static final int TOURNAMENT_SELECTION_SIZE = 4;

	public Population evolve(Population population) {
		return mutatePopulation(crossoverPopulation(population));
	}

	private Population crossoverPopulation(Population population) {

		Population crossoverPopulation = new Population(population.getChromosome().length);

		for (int i = 0; i < NUM_OF_ELITE_CHROMOSOMES; i++) {
			crossoverPopulation.getChromosome()[i] = population.getChromosome()[i];
		}

		for (int i = NUM_OF_ELITE_CHROMOSOMES; i < population.getChromosome().length; i++) {
			Chromosome chromosome1 = selectTournamentPopulation(population).getChromosome()[0];
			Chromosome chromosome2 = selectTournamentPopulation(population).getChromosome()[0];
			crossoverPopulation.getChromosome()[i] = crossoverChromosome(chromosome1, chromosome2);
		}

		return crossoverPopulation;
	}

	private Population mutatePopulation(Population population) {

		Population mutatePopulation = new Population(population.getChromosome().length);

		for (int i = 0; i < NUM_OF_ELITE_CHROMOSOMES; i++) {
			mutatePopulation.getChromosome()[i] = population.getChromosome()[i];
		}

		for (int i = NUM_OF_ELITE_CHROMOSOMES; i < population.getChromosome().length; i++) {
			mutatePopulation.getChromosome()[i] = mutateChromosome(population.getChromosome()[i]);
		}

		return mutatePopulation;
	}

	private Chromosome crossoverChromosome(Chromosome chromosome1, Chromosome chromosome2) {

		Chromosome crossoverChromosome = new Chromosome(TARGET_CHROMOSOME.length);

		for (int i = 0; i < chromosome1.getGenes().length; i++) {
			if (Math.random() < 0.5) {
				crossoverChromosome.getGenes()[i] = chromosome1.getGenes()[i];
			} else {
				crossoverChromosome.getGenes()[i] = chromosome2.getGenes()[i];
			}
		}

		return crossoverChromosome;
	}

	private Chromosome mutateChromosome(Chromosome chromosome) {
		Chromosome mutateChromosome = new Chromosome(TARGET_CHROMOSOME.length);

		for (int i = 0; i < chromosome.getGenes().length; i++) {
			if (Math.random() < MUTAION_RATE) {
				if (Math.random() < 0.5) {
					mutateChromosome.getGenes()[i] = 1;
				} else {
					mutateChromosome.getGenes()[i] = 0;
				}
			} else {
				mutateChromosome.getGenes()[i] = chromosome.getGenes()[i];
			}
		}

		return mutateChromosome;
	}

	private Population selectTournamentPopulation(Population population) {
		Population tournamentPopulaiton = new Population(TOURNAMENT_SELECTION_SIZE);
		for (int i = 0; i < TOURNAMENT_SELECTION_SIZE; i++) {
			tournamentPopulaiton.getChromosome()[i] = population.getChromosome()[(int)(Math.random()*population.getChromosome().length)];
		}
		tournamentPopulaiton.sortChromosomesByFitness();

		return tournamentPopulaiton;
	}

}
