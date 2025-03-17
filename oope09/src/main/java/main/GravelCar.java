package main;

/**
 * Represents a rally car specifically designed for gravel surfaces.
 * This implementation focuses on suspension travel as a key performance factor
 * along with the base horsepower to calculate overall performance.
 */
public class GravelCar extends RallyCar {
    /** The suspension travel in millimeters */
    private double suspensionTravel;

    /**
     * Creates a new gravel-specific rally car.
     *
     * @param make the manufacturer of the car
     * @param model the model name of the car
     * @param horsepower the horsepower of the car's engine
     * @param suspensionTravel the suspension travel in millimeters
     */
    public GravelCar(String make, String model, int horsepower, double suspensionTravel) {
        super(make, model, horsepower);
        this.suspensionTravel = suspensionTravel;
    }

    /**
     * Gets the suspension travel of the car.
     *
     * @return the suspension travel in millimeters
     */
    public double getSuspensionTravel() {
        return suspensionTravel;
    }

    @Override
    public double calculatePerformance() {
        // Performance calculation: 70% horsepower + 30% suspension travel
        return (horsepower * 0.7) + (suspensionTravel * 0.3);
    }
}