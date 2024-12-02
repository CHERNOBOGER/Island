import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private Island island;
    private ScheduledExecutorService scheduler;

    public Simulation(Island island) {
        this.island = island;
        this.scheduler = Executors.newScheduledThreadPool(2);
    }

    public void start() {
        scheduler.scheduleAtFixedRate(this::growPlants, 0, 1, TimeUnit.SECONDS);
        scheduler.scheduleAtFixedRate(this::animalLifeCycle, 0, 1, TimeUnit.SECONDS);
    }

    private void growPlants() {
        Random random = new Random();
        for (int i = 0; i < island.getWidth(); i++) {
            for (int j = 0; j < island.getHeight(); j++) {
                Location location = island.getLocation(i, j);
                if (random.nextDouble() < 0.1 && location.getPlants().size()<200) {
                    location.addPlant(new Plant());
                }
            }
        }
    }

    private void animalLifeCycle() {
        for (int i = 0; i < island.getWidth(); i++) {
            for (int j = 0; j < island.getHeight(); j++) {
                Location location = island.getLocation(i, j);
                List<Animal> animals = new ArrayList<>(location.getAnimals());
                for (Animal animal : animals) {
                    animal.move(island);
                    animal.eat(location);
                    animal.reproduce(location);

                }
            }
        }
    }

    public void stop() {
        scheduler.shutdown();
    }
}