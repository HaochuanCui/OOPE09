package main;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Static utility class providing statistical analysis for the rally championship.
 * This class demonstrates the use of static methods for utility functions
 * and the Single Responsibility Principle by focusing solely on statistics.
 */
public class ChampionshipStatistics {
    
    /**
     * Private constructor to prevent instantiation of utility class.
     */
    private ChampionshipStatistics() {
        // Utility class should not be instantiated
    }
    
    /**
     * Calculates the average points per driver in the championship.
     * Uses the total points divided by the number of drivers.
     *
     * @return average points per driver, or 0 if no drivers
     */
    public static double calculateAveragePointsPerDriver() {
        ChampionshipManager manager = ChampionshipManager.getInstance();
        List<Driver> drivers = manager.getDrivers();
        if (drivers.isEmpty()) {
            return 0.0;
        }
        int totalPoints = drivers.stream()
                .mapToInt(Driver::getTotalPoints)
                .sum();
        return (double) totalPoints / drivers.size();
    }

    /**
     * Finds the country with the highest total points in the championship.
     * Aggregates points by country and returns the country with the most points.
     *
     * @return name of the most successful country, or "No data available" if no drivers
     */
    public static String findMostSuccessfulCountry() {
        ChampionshipManager manager = ChampionshipManager.getInstance();
        List<Driver> drivers = manager.getDrivers();
        if (drivers.isEmpty()) {
            return "No data available";
        }

        Map<String, Integer> countryPoints = drivers.stream()
                .collect(Collectors.groupingBy(
                    Driver::getCountry,
                    Collectors.summingInt(Driver::getTotalPoints)
                ));

        return countryPoints.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("No data available");
    }

    /**
     * Gets the total number of races held in the championship.
     * This is tracked through the ChampionshipManager.
     *
     * @return total number of races completed
     */
    public static int getTotalRacesHeld() {
        return ChampionshipManager.getTotalRaces();
    }
}