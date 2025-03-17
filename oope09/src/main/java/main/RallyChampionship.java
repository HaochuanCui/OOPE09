package main;

/**
 * Main class for the Rally Championship system.
 * This class demonstrates the complete functionality of the rally championship
 * management system, including driver management, race results recording,
 * and championship statistics.
 */
public class RallyChampionship {
    /**
     * Main entry point for the Rally Championship system.
     * Sets up and runs a complete championship demonstration with:
     * - Multiple drivers and cars
     * - Two different races
     * - Car switching between races
     * - Complete championship standings and statistics
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        // Get championship manager instance
        ChampionshipManager manager = ChampionshipManager.getInstance();

        // Create different types of rally cars
        RallyCar gravelCar1 = new GravelCar("Subaru", "Impreza", 400, 250);
        RallyCar gravelCar2 = new GravelCar("Ford", "Fiesta", 380, 240);
        RallyCar asphaltCar1 = new AsphaltCar("Toyota", "Yaris", 380, 300);
        RallyCar asphaltCar2 = new AsphaltCar("Hyundai", "i20", 375, 290);

        // Create and register drivers
        Driver ogier = new Driver("Sébastien Ogier", "France", gravelCar1);
        Driver rovanpera = new Driver("Kalle Rovanperä", "Finland", asphaltCar1);
        Driver tanak = new Driver("Ott Tänak", "Estonia", gravelCar2);
        Driver neuville = new Driver("Thierry Neuville", "Belgium", asphaltCar2);

        manager.registerDriver(ogier);
        manager.registerDriver(rovanpera);
        manager.registerDriver(tanak);
        manager.registerDriver(neuville);

        // Create and record Rally Finland results
        RaceResult finlandRally = new RallyRaceResult("Rally Finland", "Jyväskylä");
        finlandRally.recordResult(ogier, 1, 25);
        finlandRally.recordResult(tanak, 2, 18);
        finlandRally.recordResult(rovanpera, 3, 15);
        finlandRally.recordResult(neuville, 4, 12);
        manager.addRaceResult(finlandRally);

        // Demonstrate car switching between races
        ogier.setCar(asphaltCar1);
        rovanpera.setCar(gravelCar1);

        // Create and record Monte Carlo Rally results
        RaceResult monteCarloRally = new RallyRaceResult("Monte Carlo Rally", "Monaco");
        monteCarloRally.recordResult(rovanpera, 1, 25);
        monteCarloRally.recordResult(neuville, 2, 18);
        monteCarloRally.recordResult(ogier, 3, 15);
        monteCarloRally.recordResult(tanak, 4, 12);
        manager.addRaceResult(monteCarloRally);

        // Display championship standings
        System.out.println(manager.getStandings());

        // Display championship leader
        Driver leader = manager.getLeadingDriver();
        System.out.println("===== CHAMPIONSHIP LEADER =====");
        System.out.println(leader.getName() + " with " + leader.getTotalPoints() + " points");

        // Display championship statistics
        System.out.println("===== CHAMPIONSHIP STATISTICS =====");
        System.out.println("Total Drivers: " + ChampionshipManager.getTotalDrivers());
        System.out.println("Total Races: " + ChampionshipManager.getTotalRaces());
        System.out.printf("Average Points Per Driver: %.2f\n", 
            ChampionshipStatistics.calculateAveragePointsPerDriver());
        System.out.println("Most Successful Country: " + 
            ChampionshipStatistics.findMostSuccessfulCountry());
        System.out.println("Total Championship Points: " + 
            manager.getTotalChampionshipPoints());

        // Display race results
        System.out.println("===== RACE RESULTS =====");
        System.out.print(finlandRally.getResults());
        System.out.print(monteCarloRally.getResults());

        // Display car performance ratings
        System.out.println("===== CAR PERFORMANCE RATINGS =====");
        System.out.printf("Gravel Car Performance: %.1f\n", gravelCar1.calculatePerformance());
        System.out.printf("Asphalt Car Performance: %.1f\n", asphaltCar1.calculatePerformance());
    }
}