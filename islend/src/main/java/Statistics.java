import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Statistics {
    private Island island;
    private ScheduledExecutorService scheduler;

    public Statistics(Island island) {
        this.island = island;
        this.scheduler = Executors.newScheduledThreadPool(1);
    }
    public void animalCount(Island island) {
        for (int z = 0; z < 15; z++) {
            int total = 0;
            for (int i = 0; i < island.getWidth(); i++) {
                for (int j = 0; j < island.getHeight(); j++) {
                    Location location = island.getLocation(i, j);
                    for (Animal animal : location.getAnimals()) {
                        if (Animal.getAnimalIndex(animal) == z) total++;
                    }
                }

            }
            System.out.println(z + " " + total);
        }

    }
    public void start() {
        scheduler.scheduleAtFixedRate(this::printStatistics, 0, 1, TimeUnit.SECONDS);
    }

    private void printStatistics() {
        int totalAnimals = 0;
        int totalPlants = 0;

        for (int i = 0; i < island.getWidth(); i++) {
            for (int j = 0; j < island.getHeight(); j++) {
                Location location = island.getLocation(i, j);
                totalAnimals += location.getAnimals().size();
                totalPlants += location.getPlants().size();
            }
        }

        System.out.println("Total Animals: " + totalAnimals);
        System.out.println("Total Plants: " + totalPlants);
        animalCount(island);
    }

    public void stop() {
        scheduler.shutdown();
    }
}
