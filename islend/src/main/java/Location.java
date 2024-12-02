import java.util.ArrayList;
import java.util.List;

class Location {
    private List<Animal> animals = new ArrayList<>();
    private List<Plant> plants = new ArrayList<>();

    public void addAnimal(Animal animal) {animals.add(animal);}

    public void removeAnimal(Animal animal) {animals.remove(animal);}

    public void addPlant(Plant plant) {
        plants.add(plant);
    }

    public void removePlant(Plant plant) {
        plants.remove(plant);
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public List<Plant> getPlants() {
        return plants;
    }
}