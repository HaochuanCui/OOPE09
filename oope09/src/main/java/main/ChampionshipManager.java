package main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Championship manager class implementing the Singleton pattern.
 * This class serves as the central management system for the rally championship,
 * handling drivers, races, and overall championship data.
 */
public class ChampionshipManager {
    /** Single instance of the ChampionshipManager */
    private static ChampionshipManager instance;
    
    /** List of all registered drivers */
    private List<Driver> drivers;
    
    /** List of all race results */
    private List<RaceResult> races;
    
    /** Total number of registered drivers */
    private static int totalDrivers = 0;
    
    /** Total number of completed races */
    private static int totalRaces = 0;

    /**
     * Private constructor to prevent direct instantiation.
     * Part of the Singleton pattern implementation.
     */
    private ChampionshipManager() {
        drivers = new ArrayList<>();
        races = new ArrayList<>();
    }

    /**
     * Gets the singleton instance of ChampionshipManager.
     * Creates the instance if it doesn't exist.
     *
     * @return the singleton instance
     */
    public static ChampionshipManager getInstance() {
        if (instance == null) {
            instance = new ChampionshipManager();
        }
        return instance;
    }

    /**
     * Registers a new driver in the championship.
     *
     * @param driver the driver to register
     */
    public void registerDriver(Driver driver) {
        drivers.add(driver);
        totalDrivers++;
    }

    /**
     * Adds a race result to the championship.
     *
     * @param race the race result to add
     */
    public void addRaceResult(RaceResult race) {
        races.add(race);
        totalRaces++;
    }

    /**
     * Gets the current championship standings.
     * Drivers are sorted by total points in descending order.
     *
     * @return formatted string containing the standings
     */
    public String getStandings() {
        List<Driver> sortedDrivers = new ArrayList<>(drivers);
        sortedDrivers.sort((d1, d2) -> d2.getTotalPoints() - d1.getTotalPoints());

        StringBuilder sb = new StringBuilder();
        int position = 1;
        for (Driver driver : sortedDrivers) {
            sb.append(String.format("%d. %s (%s): %d points\n", 
                position++, driver.getName(), driver.getCountry(), driver.getTotalPoints()));
        }
        return sb.toString();
    }

    /**
     * Gets the current championship leader.
     *
     * @return the driver with the most points
     */
    public Driver getLeadingDriver() {
        return drivers.stream()
                .max(Comparator.comparingInt(Driver::getTotalPoints))
                .orElse(null);
    }

    /**
     * Gets all registered drivers.
     *
     * @return list of all drivers
     */
    public List<Driver> getDrivers() {
        return new ArrayList<>(drivers);
    }

    /**
     * Gets the total number of registered drivers.
     *
     * @return total driver count
     */
    public static int getTotalDrivers() {
        return totalDrivers;
    }

    /**
     * Gets the total number of completed races.
     *
     * @return total race count
     */
    public static int getTotalRaces() {
        return totalRaces;
    }

    /**
     * Gets the total championship points across all drivers.
     *
     * @return total points in the championship
     */
    public int getTotalChampionshipPoints() {
        return drivers.stream()
                .mapToInt(Driver::getTotalPoints)
                .sum();
    }
}