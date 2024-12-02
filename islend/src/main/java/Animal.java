import java.util.Random;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;

abstract class Animal {
    protected static final Logger LOGGER = Logger.getLogger(Animal.class.getName());
    protected double weight;
    protected int maxOnCell;
    protected int speed;
    protected double neededFood;
    protected int x;
    protected int y;

    public Animal(double weight, int maxOnCell, int speed, double neededFood, int x, int y) {
        this.weight = weight;
        this.maxOnCell = maxOnCell;
        this.speed = speed;
        this.neededFood = neededFood;
        this.x = x;
        this.y = y;
    }
    protected static final int[][] EAT_CHANCES = {
            {0, 0, 0, 0, 0, 10, 15, 60, 80, 60, 70, 15, 10, 40, 0, 0}, // Волк
            {0, 0, 15, 0, 0, 0, 0, 20, 40, 0, 0, 0, 0, 10, 0, 0}, //Удав
            {0, 0, 0, 0, 0, 0, 0, 70, 90, 0, 0, 0, 0, 60, 40, 0}, //Лиса
            {0, 80, 0, 0, 0, 40, 80, 80, 90, 70, 70, 50, 20, 10, 0, 0},//Медведь
            {0,0, 10, 0, 0, 0, 0, 90, 90, 0, 0, 0, 0, 80, 0, 0}, //Орел
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,100},//Лошадь
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,100},//Олень
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,100},//Кролик
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,90,100},//Мышь
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,100},//Коза
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,100},//Овца
            {0,0,0,0,0,0,0,0,50,0,0,0,0,0,90,100},//Кабан
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,100},//Буйвол
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,90,100},//Утка
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,100}//Гусеница

    };


    public void eat(Location location) {
        List<Animal> animals = location.getAnimals();
        boolean full = false;
        for (Animal animal : animals) {
            if (animal != this) {
                int chance = EAT_CHANCES[getPredatorIndex()][getAnimalIndex(animal)];
                if (new Random().nextInt(100) < chance) {
                    LOGGER.log(Level.INFO, this.getClass().getSimpleName() + " ate animal " + animal.getClass().getSimpleName() + " at (" + x + ", " + y + ")");
                    neededFood -= animal.weight;
                    location.removeAnimal(animal);
                    if (neededFood <= 0) {
                        full = true;
                        break;
                    } else {continue;}
                } else {continue;}
            }

            if (this instanceof Herbivore){
                List<Plant> plants = location.getPlants();
                for (Plant plant : plants) {
                    neededFood -= 1;
                    location.removePlant(plant);
                    LOGGER.log(Level.INFO, this.getClass().getSimpleName() + " ate plant" + " at (" + x + ", " + y + ")");
                    if (neededFood <= 0) {
                        full = true;
                        break;
                    }
                }
            }
        }

        if (!full) {
            die(location);
        }
    }
    public void die(Location location){
        LOGGER.log(Level.INFO, this.getClass().getSimpleName() + " died at (" + x + ", " + y + ")");
        location.removeAnimal(this);
    }
    public abstract int getPredatorIndex();
    public static int getAnimalIndex(Animal animal) {
        if (animal instanceof Wolf) return 0;
        if (animal instanceof Snake) return 1;
        if (animal instanceof Fox) return 2;
        if (animal instanceof Bear) return 3;
        if (animal instanceof Eagle) return 4;
        if (animal instanceof Horse) return 5;
        if (animal instanceof Deer) return 6;
        if (animal instanceof Rabbit) return 7;
        if (animal instanceof Mouse) return 8;
        if (animal instanceof Goat) return 9;
        if (animal instanceof Sheep) return 10;
        if (animal instanceof Boar) return 11;
        if (animal instanceof Buffalo) return 12;
        if (animal instanceof Duck) return 13;
        return 14;
    }
    public void reproduce(Location location) {
        List<Animal> animals = location.getAnimals();
        int count = 0;
        for (Animal animal : animals) {
            if (animal.getClass() == this.getClass()) {
                count++;
            }
        }
        if (count >= 2 && count<maxOnCell) {
            location.addAnimal(createNewInstance(x, y));
            LOGGER.log(Level.INFO, this.getClass().getSimpleName() + " reproduced at (" + x + ", " + y + ")");
        }
    }
    protected abstract Animal createNewInstance(int x, int y);


    public void move(Island island) {
        for (int i = 0; i < this.speed; i++) {
            int direction = getRandomDirection();
            int currentX = getX();
            int currentY = getY();

            int newX = currentX;
            int newY = currentY;

            switch (direction) {
                case 0: // up
                    newY = Math.max(0, currentY - 1);
                    break;
                case 1: // right
                    newX = Math.min(island.getWidth() - 1, currentX + 1);
                    break;
                case 2: // down
                    newY = Math.min(island.getHeight() - 1, currentY + 1);
                    break;
                case 3: // left
                    newX = Math.max(0, currentX - 1);
                    break;
            }


            Location currentLocation = island.getLocation(currentX, currentY);
            Location newLocation = island.getLocation(newX, newY);

            currentLocation.removeAnimal(this);
            newLocation.addAnimal(this);

            setX(newX);
            setY(newY);


            LOGGER.log(Level.INFO, this.getClass().getSimpleName() + " moved from (" + currentX + ", " + currentY + ") to (" + newX + ", " + newY + ")");
        }
    }



    protected int getRandomDirection() {
        Random random = new Random();
        return random.nextInt(4); // 0 - up, 1 - right, 2 - down, 3 - left
    }
    public int getX() {return x;}

    public int getY() {return y;}

    public void setX(int x) {this.x = x;}

    public void setY(int y) {this.y = y;}

}
class Plant {
    public Plant() {}
}



