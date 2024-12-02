

abstract class Herbivore extends Animal {
    public Herbivore(double weight, int maxOnCell, int speed, double neededFood, int x, int y) {
        super(weight, maxOnCell, speed, neededFood, x, y);
    }
}
class Horse extends Herbivore {
    public Horse(int x, int y) {
        super(400,20,4,60, x, y);
    }

    @Override
    protected Animal createNewInstance(int x, int y) {
        return new Horse(x, y);
    }

    @Override
    public int getPredatorIndex() {
        return 5;
    }
}
class Deer extends Herbivore {
    public Deer(int x, int y) {
        super(300,20,4,50, x, y);
    }

    @Override
    protected Animal createNewInstance(int x, int y) {
        return new Deer(x, y);
    }

    @Override
    public int getPredatorIndex() {
        return 6;
    }
}
class Rabbit extends Herbivore {
    public Rabbit(int x, int y) {
        super(2, 150, 2, 0.45, x, y);
    }

    @Override
    protected Animal createNewInstance(int x, int y) {
        return new Rabbit(x, y);
    }

    @Override
    public int getPredatorIndex() {
        return 7;
    }
}
class Mouse extends Herbivore {
    public Mouse(int x, int y) {
        super(0.05,500,1,0.01, x, y);
    }

    @Override
    protected Animal createNewInstance(int x, int y) {
        return new Mouse(x, y);
    }

    @Override
    public int getPredatorIndex() {
        return 8;
    }
}
class Goat extends Herbivore {
    public Goat(int x, int y) {
        super(60,140,3,10, x, y);
    }

    @Override
    protected Animal createNewInstance(int x, int y) {
        return new Goat(x, y);
    }

    @Override
    public int getPredatorIndex() {
        return 9;
    }
}
class Sheep extends Herbivore {
    public Sheep(int x, int y) {
        super(70,140,3,15, x, y);
    }

    @Override
    protected Animal createNewInstance(int x, int y) {
        return new Sheep(x, y);
    }

    @Override
    public int getPredatorIndex() {
        return 10;
    }
}
class Boar extends Herbivore {
    public Boar(int x, int y) {
        super(400,50,2,50, x, y);
    }

    @Override
    protected Animal createNewInstance(int x, int y) {
        return new Boar(x, y);
    }

    @Override
    public int getPredatorIndex() {
        return 11;
    }
}
class Buffalo extends Herbivore {
    public Buffalo(int x, int y) {
        super(700,10,3,100, x, y);
    }

    @Override
    protected Animal createNewInstance(int x, int y) {
        return new Buffalo(x, y);
    }

    @Override
    public int getPredatorIndex() {
        return 12;
    }
}
class Duck extends Herbivore {
    public Duck(int x, int y) {
        super(1,200,4,0.15, x, y);
    }

    @Override
    protected Animal createNewInstance(int x, int y) {
        return new Duck(x, y);
    }

    @Override
    public int getPredatorIndex() {
        return 13;
    }
}
class Caterpillar extends Herbivore {
    public Caterpillar(int x, int y) {
        super(0.01,1000,0,0, x, y);
    }

    @Override
    protected Animal createNewInstance(int x, int y) {
        return new Caterpillar(x, y);
    }

    @Override
    public int getPredatorIndex() {
        return 14;
    }
}
