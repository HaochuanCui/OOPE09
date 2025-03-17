package main;

/**
 * Abstract base class for rally cars. This class defines the common properties
 * and behaviors of all rally cars in the championship. Following the Open/Closed
 * principle, this class can be extended to create new types of rally cars without
 * modifying existing code.
 */
public abstract class RallyCar {
    /** The manufacturer of the car */
    protected String make;
    
    /** The model name of the car */
    protected String model;
    
    /** The horsepower of the car's engine */
    protected int horsepower;

    /**
     * Creates a new rally car with the specified details.
     *
     * @param make the manufacturer of the car
     * @param model the model name of the car
     * @param horsepower the horsepower of the car's engine
     */
    public RallyCar(String make, String model, int horsepower) {
        this.make = make;
        this.model = model;
        this.horsepower = horsepower;
    }

    /**
     * Gets the manufacturer of the car.
     *
     * @return the manufacturer name
     */
    public String getMake() {
        return make;
    }

    /**
     * Gets the model name of the car.
     *
     * @return the model name
     */
    public String getModel() {
        return model;
    }

    /**
     * Gets the horsepower of the car's engine.
     *
     * @return the horsepower value
     */
    public int getHorsepower() {
        return horsepower;
    }

    /**
     * Calculates the performance rating of the car.
     * Each subclass must implement this method with its own algorithm
     * based on the specific characteristics of that car type.
     *
     * @return the performance rating value
     */
    public abstract double calculatePerformance();
}