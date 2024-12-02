import java.util.Random;

class Island {
    private Location[][] grid;
    private int width;
    private int height;

    public Island(int width, int height) {
        this.width = width;
        this.height = height;
        this.grid = new Location[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                grid[i][j] = new Location();
            }
        }
    }

    public Location getLocation(int x, int y) {
        return grid[x][y];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }


    public void populateIsland() {
        Random random = new Random();
        int numAnimals = random.nextInt(width*height);

        for (int i = 0; i < numAnimals; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int animalType = random.nextInt(15);
            switch (animalType){
                case (0):
                    grid[x][y].addAnimal(new Wolf(x, y));
                    break;
                case (1):
                    grid[x][y].addAnimal(new Snake(x, y));
                    break;
                case (2):
                    grid[x][y].addAnimal(new Fox(x, y));
                    break;
                case (3):
                    grid[x][y].addAnimal(new Bear(x, y));
                    break;
                case (4):
                    grid[x][y].addAnimal(new Eagle(x, y));
                    break;
                case (5):
                    grid[x][y].addAnimal(new Horse(x, y));
                    break;
                case (6):
                    grid[x][y].addAnimal(new Deer(x, y));
                    break;
                case (7):
                    grid[x][y].addAnimal(new Rabbit(x, y));
                    break;
                case (8):
                    grid[x][y].addAnimal(new Mouse(x, y));
                    break;
                case (9):
                    grid[x][y].addAnimal(new Goat(x, y));
                    break;
                case (10):
                    grid[x][y].addAnimal(new Sheep(x, y));
                    break;
                case (11):
                    grid[x][y].addAnimal(new Boar(x, y));
                    break;
                case (12):
                    grid[x][y].addAnimal(new Buffalo(x, y));
                    break;
                case (13):
                    grid[x][y].addAnimal(new Duck(x, y));
                    break;
                case (14):
                    grid[x][y].addAnimal(new Caterpillar(x, y));
                    break;
            }
        }
    }
}