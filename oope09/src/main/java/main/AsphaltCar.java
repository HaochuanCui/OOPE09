package main;

/**
 * Represents a rally car specifically designed for asphalt surfaces.
 * This implementation focuses on downforce as a key performance factor
 * along with the base horsepower to calculate overall performance.
 */
public class AsphaltCar extends RallyCar {
    /** The downforce in kilograms */
    private double downforce;

    /**
     * Creates a new asphalt-specific rally car.
     *
     * @param make the manufacturer of the car
     * @param model the model name of the car
     * @param horsepower the horsepower of the car's engine
     * @param downforce the downforce in kilograms
     */
    public AsphaltCar(String make, String model, int horsepower, double downforce) {
        super(make, model, horsepower);
        this.downforce = downforce;
    }

    /**
     * Gets the downforce of the car.
     *
     * @return the downforce in kilograms
     */
    public double getDownforce() {
        return downforce;
    }

    @Override
    public double calculatePerformance() {
        // Performance calculation: 60% horsepower + 40% downforce
        return (horsepower * 0.6) + (downforce * 0.4);
    }
}