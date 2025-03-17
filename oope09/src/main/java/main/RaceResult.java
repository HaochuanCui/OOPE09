package main;

/**
 * Interface defining the contract for race results in the championship.
 * This interface demonstrates the Interface Segregation Principle by providing
 * only the essential methods needed for managing race results.
 */
public interface RaceResult {
    /**
     * Records a driver's result in the race.
     * This method updates both the race results and the driver's points.
     *
     * @param driver the driver whose result is being recorded
     * @param position the finishing position in the race
     * @param points the points awarded for this position
     */
    void recordResult(Driver driver, int position, int points);

    /**
     * Retrieves the formatted results of the race.
     * The results include the race details and all driver positions and points.
     *
     * @return a formatted string containing the complete race results
     */
    String getResults();
}