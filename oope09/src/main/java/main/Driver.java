package main;

/**
 * Represents a rally driver in the championship.
 * This class manages driver information, points, and their associated rally car.
 * It demonstrates dependency injection through the relationship with RallyCar.
 */
public class Driver {
    /** The name of the driver */
    private String name;
    
    /** The country the driver represents */
    private String country;
    
    /** The total points accumulated by the driver */
    private int totalPoints;
    
    /** The current rally car assigned to the driver */
    private RallyCar car;

    /**
     * Creates a new driver with the specified details.
     *
     * @param name the name of the driver
     * @param country the country the driver represents
     * @param car the initial rally car assigned to the driver
     */
    public Driver(String name, String country, RallyCar car) {
        this.name = name;
        this.country = country;
        this.car = car;
        this.totalPoints = 0;
    }

    /**
     * Gets the driver's name.
     *
     * @return the driver's name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the driver's country.
     *
     * @return the country the driver represents
     */
    public String getCountry() {
        return country;
    }

    /**
     * Gets the driver's total championship points.
     *
     * @return the total points accumulated
     */
    public int getTotalPoints() {
        return totalPoints;
    }

    /**
     * Gets the current rally car assigned to the driver.
     *
     * @return the current rally car
     */
    public RallyCar getCar() {
        return car;
    }

    /**
     * Assigns a new rally car to the driver.
     * This demonstrates the ability to switch cars between races.
     *
     * @param car the new rally car to assign
     */
    public void setCar(RallyCar car) {
        this.car = car;
    }

    /**
     * Adds points to the driver's total championship points.
     *
     * @param points the points to add
     */
    public void addPoints(int points) {
        this.totalPoints += points;
    }
}