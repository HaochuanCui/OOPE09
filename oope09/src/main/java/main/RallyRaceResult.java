package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Implementation of RaceResult interface for rally races.
 * This class manages the results of a specific rally race event,
 * including tracking positions and points for each participating driver.
 */
public class RallyRaceResult implements RaceResult {
    /** The name of the rally event */
    private String raceName;
    
    /** The location where the rally is held */
    private String location;
    
    /** List of result entries for the race */
    private List<ResultEntry> results;

    /**
     * Creates a new rally race result.
     *
     * @param raceName the name of the rally event
     * @param location the location where the rally is held
     */
    public RallyRaceResult(String raceName, String location) {
        this.raceName = raceName;
        this.location = location;
        this.results = new ArrayList<>();
    }

    @Override
    public void recordResult(Driver driver, int position, int points) {
        results.add(new ResultEntry(driver, position, points));
        driver.addPoints(points);
    }

    @Override
    public String getResults() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Race: %s (%s)\n", raceName, location));
        
        // Sort results by position
        Collections.sort(results);
        
        for (ResultEntry entry : results) {
            sb.append(String.format(" Position %d: %s - %d points\n", 
                entry.position, entry.driver.getName(), entry.points));
        }
        
        return sb.toString();
    }

    /**
     * Gets the name of the rally event.
     *
     * @return the rally name
     */
    public String getRaceName() {
        return raceName;
    }

    /**
     * Gets the location of the rally event.
     *
     * @return the rally location
     */
    public String getLocation() {
        return location;
    }

    /**
     * Internal class representing a single race result entry.
     * Implements Comparable to allow sorting by position.
     */
    private static class ResultEntry implements Comparable<ResultEntry> {
        /** The driver for this result entry */
        private Driver driver;
        
        /** The finishing position */
        private int position;
        
        /** The points awarded */
        private int points;

        /**
         * Creates a new result entry.
         *
         * @param driver the driver
         * @param position the finishing position
         * @param points the points awarded
         */
        public ResultEntry(Driver driver, int position, int points) {
            this.driver = driver;
            this.position = position;
            this.points = points;
        }

        @Override
        public int compareTo(ResultEntry other) {
            return Integer.compare(this.position, other.position);
        }
    }
}