public class Main {

    public static void main(String[] args) {
        Island island = new Island(20, 20);

        island.populateIsland(//island.getLocation()
                 );

        Simulation simulation = new Simulation(island);
        Statistics statistics = new Statistics(island);



        simulation.start();
        statistics.start();


        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        simulation.stop();
        statistics.stop();
    }
}