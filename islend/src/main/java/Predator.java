
abstract class Predator extends Animal {

    public Predator(double weight, int maxOnCell, int speed, double neededFood, int x, int y) {
        super(weight, maxOnCell, speed, neededFood, x, y);
    }

}
class Wolf extends Predator {


    public Wolf(int x, int y) {
        super(50, 30, 3, 8, x, y);
    }


    @Override
    public int getPredatorIndex() {
        return 0;
    }

    @Override
    protected Animal createNewInstance(int x, int y) {return new Wolf(x, y);}
}
class Snake extends Predator {
    public Snake(int x, int y) {
        super(15	,30,1,3, x, y);
    }

    @Override
    public int getPredatorIndex() {
        return 1;
    }

    @Override
    protected Animal createNewInstance(int x, int y) {
        return new Snake(x, y);
    }
}
class Fox extends Predator {
    public Fox(int x, int y) {
        super(8,30,2,2, x, y);
    }

    @Override
    public int getPredatorIndex() {
        return 2;
    }

    @Override
    protected Animal createNewInstance(int x, int y) {
        return new Fox(x, y);
    }
}
class Bear extends Predator {
    public Bear(int x, int y) {
        super(500,5,2,80, x, y);
    }


    @Override
    public int getPredatorIndex() {
        return 3;
    }

    @Override
    protected Animal createNewInstance(int x, int y) {
        return new Bear(x, y);
    }
}
class Eagle extends Predator {
    public Eagle(int x, int y) {
        super(6,20,3,1, x, y);
    }

    @Override
    public int getPredatorIndex() {
        return 4;
    }

    @Override
    protected Animal createNewInstance(int x, int y) {
        return new Eagle(x, y);
    }
}